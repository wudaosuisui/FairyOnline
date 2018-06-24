package com.fairyonline.xiaoye.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fairyonline.common.DemoException;
import com.fairyonline.statics.AsrMain;
import com.fairyonline.statics.HttpClientTool;
import com.fairyonline.statics.Result;
import com.fairyonline.statics.TtsMain;


@Service
@Repository
public class TulingService {
//	@Resource
	//eeeeee
	public HashMap<String, Object> say(String say,String name){
		//返回值
		Result result = new Result();
		String statusCode =result.getStatusCode();//状态码
		String desc = result.getDesc();//状态码描述
		//执行操作
		
		//“答案文字”-》“答案音频”
		String anWav=null;
		try {
			anWav = new TtsMain(say).run(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DemoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map message =new HashMap<String, Object>(2);
		message.put("anWav",anWav);
//		message.put("jsonObject",jsonObject);
//		System.out.println("askStr  is "+askStr);
//				message.put("jsonObject", jsonObject);
		//存入返回值
		result.getResult().put("message", message);
		result.setStatusCode(statusCode);
		result.setDesc(desc);
		return result.getRe();
	}
	public HashMap<String, Object> ask(String wav) {
		//返回值
		Result result = new Result();
		String statusCode =result.getStatusCode();//状态码
		String desc = result.getDesc();//状态码描述
		//执行操作
		//“询问音频”-》“询问文字”
		System.out.println("wav is "+ wav);
		String askStr = null;
		JSONObject jsonObject =null;
		try {
			askStr = new AsrMain(wav).run();
			jsonObject = JSONArray.parseObject(askStr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DemoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map message =new HashMap<String, Object>(2);
		message.put("askStr",askStr);
		message.put("jsonObject",jsonObject);
		System.out.println("askStr  is "+askStr);
//		message.put("jsonObject", jsonObject);
		//存入返回值
		result.getResult().put("message", message);
		result.setStatusCode(statusCode);
		result.setDesc(desc);
		return result.getRe();
	}
	
	public HashMap<String, Object> test(String askWar) {
		//返回值
		Result result = new Result();
		String statusCode =result.getStatusCode();//状态码
		String desc = result.getDesc();//状态码描述
		//执行操作
//		//“询问音频”-》“询问文字”
//		String askStr = null;
//		JSONObject jsonObject =null;
//		try {
//			askStr = new AsrMain(askWar).run();
//			jsonObject = JSONArray.parseObject(askStr);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (DemoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//“询问文字”-》图灵-》“答案文字”
//		String Url = "utl";
//		Map pr =new HashMap<String, Object>(1);
//		pr.put("askStr",askStr);
//		String jsoStr = HttpClientTool.doGet(Url,pr);//获取返回值json String
//		JSONObject jsonObject = JSONArray.parseObject(jsoStr);//将  json String -》 json 
//		String anStr = jsonObject.getString("anStr");
		//“答案文字”-》“答案音频”
		String anWav=null;
//		try {
//			anWav = new TtsMain("测试文字1").run("anName1");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (DemoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//返回结果

		Map message =new HashMap<String, Object>(1);
//		{{
//			put("askWar",askWar);
//			put("anStr",anStr);
//		}};
//		message.put("askStr",askStr);
		message.put("anWav",anWav);
//		message.put("jsonObject", jsonObject);
		//存入返回值
		result.getResult().put("message", message);
		result.setStatusCode(statusCode);
		result.setDesc(desc);
		return result.getRe();
	}
//	public HashMap<String, Object> asdTuLing(String askWar) {
//		//返回值
//		Result result = new Result();
//		String statusCode =result.getStatusCode();//状态码
//		String desc = result.getDesc();//状态码描述
//		//执行操作
//		//“询问音频”-》“询问文字”
//		String askStr = null;
//		try {
//			askStr = new AsrMain(askWar).run();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (DemoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//“询问文字”-》图灵-》“答案文字”
//		String Url = "utl";
//		Map pr =new HashMap<String, Object>(1);
//		pr.put("askStr",askStr);
//		String jsoStr = HttpClientTool.doGet(Url,pr);//获取返回值json String
//		JSONObject jsonObject = JSONArray.parseObject(jsoStr);//将  json String -》 json 
//		String anStr = jsonObject.getString("anStr");
//		//“答案文字”-》“答案音频”
//		String anWav=null;
//		try {
//			anWav = new TtsMain(anStr).run();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (DemoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//返回结果
//
//		Map message =new HashMap<String, Object>(4)
//		{{
//			put("askWar",askWar);
//			put("anStr",anStr);
//		}};
//		message.put("askStr",askStr);
//		message.put("anWav",anWav);
//		//存入返回值
//		result.getResult().put("message", message);
//		result.setStatusCode(statusCode);
//		result.setDesc(desc);
//		return result.getRe();
//	}
	
	//访问网址，静态方法
	public static String getURLContent(String urlStr) {                 
        
        //请求的url   
        URL url = null;        
          
        //建立的http链接    
        HttpURLConnection httpConn = null;    
          
        //请求的输入流  
        BufferedReader in = null;     
          
        //输入流的缓冲  
        StringBuffer sb = new StringBuffer();   
          
        try{       
             url = new URL(urlStr);       
               
             in = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8") );   
               
             String str = null;    
              
             //一行一行进行读入  
             while((str = in.readLine()) != null) {      
                sb.append( str );       
             }       
        } catch (Exception ex) {     
                  
        } finally{      
             try{               
                  if(in!=null) {    
                   in.close(); //关闭流      
                  }       
            }catch(IOException ex) {        
              
            }       
        }       
        String result =sb.toString();       
        return result;      
    }    
}
