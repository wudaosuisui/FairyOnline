package com.lei.demo;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.AccessController;
import java.security.PrivilegedAction;

import javax.swing.SwingUtilities;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;  

public class PdfToJpgTest {  
	public static int changePdfToImg(String instructiopath,String picturepath) {
		int countpage =0;
		try {
			//instructiopath ="D:/instructio/2015-05-16/Android 4编程入门经典.pdf"
			//picturepath = "D:/instructio/picture/2015-05-16/";
			
			File file = new File(instructiopath);
			RandomAccessFile raf = new RandomAccessFile(file, "r");
			FileChannel channel = raf.getChannel();
			MappedByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY,
					0, channel.size());
			PDFFile pdffile = new PDFFile(buf);
			//创建图片文件夹
			File dirfile = new File(picturepath);
			   if(!dirfile.exists()){
					 dirfile.mkdirs();
				}
			//获得图片页数
			countpage = pdffile.getNumPages();
			for (int i = 1; i <= pdffile.getNumPages(); i++) {
				PDFPage page = pdffile.getPage(i);
				Rectangle rect = new Rectangle(0, 0, ((int) page.getBBox()
						.getWidth()), ((int) page.getBBox().getHeight()));
				int n = 2;
				/** 图片清晰度（n>0且n<7）【pdf放大参数】 */
				Image img = page.getImage(rect.width * n, rect.height * n,
						rect, /** 放大pdf到n倍，创建图片。 */
						null, /** null for the ImageObserver */
						true, /** fill background with white */
						true /** block until drawing is done */
				);
				BufferedImage tag = new BufferedImage(rect.width * n,
						rect.height * n, BufferedImage.TYPE_INT_RGB);
				tag.getGraphics().drawImage(img, 0, 0, rect.width * n,
						rect.height * n, null);
				/**
				 * File imgfile = new File("D:\\work\\mybook\\FilesNew\\img\\" +
				 * i + ".jpg"); if(imgfile.exists()){
				 * if(imgfile.createNewFile()) { System.out.println("创建图片："+
				 * "D:\\work\\mybook\\FilesNew\\img\\" + i + ".jpg"); } else {
				 * System.out.println("创建图片失败！"); } }
				 */
				FileOutputStream out = new FileOutputStream(picturepath+"/" + i
						+ ".png");
				/** 输出到文件流 */
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
				JPEGEncodeParam param2 = encoder.getDefaultJPEGEncodeParam(tag);
				param2.setQuality(1f, true);
				/** 1f~0.01f是提高生成的图片质量 */
				encoder.setJPEGEncodeParam(param2);
				encoder.encode(tag);
				/** JPEG编码 */
				out.close();
			}
			channel.close();
			raf.close();
			unmap(buf);
			/** 如果要在转图片之后删除pdf，就必须要这个关闭流和清空缓冲的方法 */
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return countpage;
		
	}

	@SuppressWarnings("unchecked")
	public static void unmap(final Object buffer) {
		AccessController.doPrivileged(new PrivilegedAction() {
			public Object run() {
				try {
					Method getCleanerMethod = buffer.getClass().getMethod(
							"cleaner", new Class[0]);
					getCleanerMethod.setAccessible(true);
					sun.misc.Cleaner cleaner = (sun.misc.Cleaner) getCleanerMethod
							.invoke(buffer, new Object[0]);
					cleaner.clean();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
		});
	}
	public static void main(final String[] args) {  
     PdfToJpgTest.changePdfToImg("C:\\Users\\mofei\\Desktop\\2.pdf","C:\\Users\\mofei\\Desktop\\");  
     try {  
         // Specify the file name and path  
         File file = new File("C:\\Users\\mofei\\Desktop\\2.pdf");  
         /* the delete() method return true if the file 
         deleted successfully else it return false 
          */  
         if (file.delete()) {  
           System.out.println(file.getName() + " is deleted");  
         } else {  
           System.out.println("Delete failed.");  
         }  
       } catch (Exception e) {  
         System.out.println("Exception occured");  
         e.printStackTrace();  
       }  
	}
}