package com.fairyonline.xiaoye.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fairyonline.xiaoye.dao.NodeDaoImpl;
import com.fairyonline.xiaoye.dao.SideDaoImpl;
import com.fairyonline.xiaoye.entity.Side;
import com.fairyonline.xiaoye.entity.Node;

@Service
@Repository
public class SideServiceImpl {
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private SideDaoImpl sideDaoImpl;
	@Resource
	private NodeDaoImpl nodeDaoImpl;
	
	/*主方法*/
	//通过file 添加边
	public void AddSideByFile(String fileUrl) {
		Session session = sessionFactory.openSession();
		//获取并拆分文件内容	返回一个文件内容而的String2维数组
		String[][] strArr = this.GetStrArr(fileUrl);
		//将获取到的数组  转换为对象数组
		Side[] sidArr = this.GetSideArr(strArr);
		//将数组中的对象进行补全 并 存入
		this.ComSidAndSave(sidArr);
		session.close();
	}
	
	
	/*子方法*/
	//将数组中的对象进行补全 并 存入
	public void ComSidAndSave(Side[] sidArr) {//complement  补充
		for(Side sid :sidArr) {
			//获取两个节点对象
			Node nod1 = nodeDaoImpl.getByName(sid.getNoName());
			Node nod2 = nodeDaoImpl.getByName(sid.getNtName());
			sid.setNodeOneId(nod1.getId());
			sid.setNodeTwoId(nod2.getId());
			//主要属性已经补全  进行存储
			sideDaoImpl.save(sid);
			//判断两个node是否已经有至少一条边 
			//如果已经有至少一条边了   则 获取LastSide
			Boolean nod1side=false;
			Boolean nod2side=false;
			if(nod1.getFirstSideId()==0) {
				//node还没有边  此边为node的第一条边
				//将Fsid Lsid 都设置成 此边
				nod1side=false;
				nod1.setFirstSideId(sid.getId());
				nod1.setLastSideId(sid.getId());
				nodeDaoImpl.update(nod1);
			}else {
				//node已经有至少一条边的了
				nod1side = true;
				//获取node现在标记的 ListSide
				Side node1LSide = sideDaoImpl.getById(nod1.getLastSideId());
				//将此边的对应node的下一条边id  修改为现在的sid
				node1LSide.setNextSidId(nod1, sid);
				//将node的最后一条边改为现在的sid
				nod1.setLastSideId(sid.getId());
				nodeDaoImpl.update(nod1);
				sideDaoImpl.update(node1LSide);
			}
			if(nod2.getFirstSideId()==0) {
				//node还没有边  此边为node的第一条边
				//将Fsid Lsid 都设置成 此边
				nod2side=false;
				nod2.setFirstSideId(sid.getId());
				nod2.setLastSideId(sid.getId());
				nodeDaoImpl.update(nod2);
			}else {
				//node已经有至少一条边的了
				nod2side = true;
				//获取node现在标记的 ListSide
				Side node2LSide = sideDaoImpl.getById(nod2.getLastSideId());
				//将此边的对应node的下一条边id  修改为现在的sid
				node2LSide.setNextSidId(nod2, sid);
				//将node的最后一条边改为现在的sid
				nod2.setLastSideId(sid.getId());
				nodeDaoImpl.update(nod2);
				sideDaoImpl.update(node2LSide);
			}			
		}//for(Side sid :sidArr)
	}
	//将获取到的数组  转换为对象数组
	public Side[] GetSideArr(String[][] strArr) {
		Side[] sidArr = new Side[strArr.length];
		for(int i=0;i<(strArr.length-1);i++) {
			sidArr[i] = new Side(
					strArr[i+1][0],//版办号
					strArr[i+1][1],//节点一 名字
					Integer.parseInt(strArr[i+1][2]),//相关度
					strArr[i+1][3],//节点二名字
					Integer.parseInt(strArr[i+1][4]),//相关度
					strArr[i+1][5]);//详细内容
		}
//		String str="12";
//		int a =Integer.parseInt(str);
		return sidArr;
	}
	//获取并拆分文件内容	返回一个文件内容而的2维数组
	public String[][] GetStrArr(String fileUrl) {
		String encoding = "UTF-8"; 
		String sign;//sign 分隔符   根据名称后缀  确定分隔符种类
		if(fileUrl.substring(fileUrl.lastIndexOf(".")).equals(".csv"))
			sign=",";
		else
			sign="\t";
		File file = new File(fileUrl);
		Long filelength = file.length();  //获取文件总长度
		byte[] filecontent = new byte[filelength.intValue()];// 创建文件长度的字节数组 
		try {  
            FileInputStream in = new FileInputStream(file);  //创建了一个新的什么东西
            in.read(filecontent);  //读取内容 到刚刚新创建的字节数组(字节数组 大概是长这个样子: [B@325b51b)
            in.close();  //关闭读取
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }
		String str;
		try {
			str = new String(filecontent, encoding);
			String[] strs = str.split("\r\n");
			String[][] strArr = new String[strs.length][];
			for(int i=0 ;i<strs.length;i++) {
	             strArr[i] = strs[i].split(sign);
            }
			return strArr;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	
	
	
}




