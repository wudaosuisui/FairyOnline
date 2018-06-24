package com.fairyonline.statics;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fairyonline.common.*;

public class TtsMain {

//    public static void main(String[] args) throws IOException, DemoException {
//        (new TtsMain()).run();
//    }

	public TtsMain(String text) {
		this.text = text;
	};
	
    //  填写网页上申请的appkey 如 $apiKey="g8eBUMSokVB1BHGmgxxxxxx"
    private final String appKey = "8kFTjef6WSNXGKHkzUDC2FG2";

    // 填写网页上申请的APP SECRET 如 $secretKey="94dc99566550d87f8fa8ece112xxxxx"
    private final String secretKey = "a2b4e2509f6ea6d5eaad6c006234815f";


    // text 的内容为"欢迎使用百度语音合成"的urlencode,utf-8 编码
    // 可以百度搜索"urlencode"
    private /*final*/ String text = "欢迎使用百度语音";

    // 发音人选择, 0为普通女声，1为普通男生，3为情感合成-度逍遥，4为情感合成-度丫丫，默认为普通女声
    private final int per = 4;
    // 语速，取值0-9，默认为5中语速
    private final int spd = 5;
    // 音调，取值0-9，默认为5中语调
    private final int pit = 5;
    // 音量，取值0-9，默认为5中音量
    private final int vol = 5;

    public final String url = "http://tsn.baidu.com/text2audio"; // 可以使用https

    private String cuid = "1234567JAVA";

    private String savUrl =  "E:\\Program Files\\JavaEE\\eclipseWork\\FairyOnline\\mps\\";
    
    public String run(String name) throws IOException, DemoException {
        TokenHolder holder = new TokenHolder(appKey, secretKey, TokenHolder.ASR_SCOPE);
        holder.resfresh();
        String token = holder.getToken();

        String url2 = url + "?tex=" + ConnUtil.urlEncode(text);
        url2 += "&per=" + per;
        url2 += "&spd=" + spd;
        url2 += "&pit=" + pit;
        url2 += "&vol=" + vol;
        url2 += "&cuid=" + cuid;
        url2 += "&tok=" + token;
        url2 += "&lan=zh&ctp=1";
         System.out.println(url2); // 反馈请带上此url，浏览器上可以测试
        HttpURLConnection conn = (HttpURLConnection) new URL(url2).openConnection();
        conn.setConnectTimeout(5000);
        String contentType = conn.getContentType();
        if (contentType.contains("mp3")) {
            byte[] bytes = ConnUtil.getResponseBytes(conn);
            File file = new File(savUrl+name+".mp3"); // 打开mp3文件即可播放
            // System.out.println( file.getAbsolutePath());
            FileOutputStream os = new FileOutputStream(file);
            os.write(bytes);
            os.close();
            System.out.println("mp3 file write to " + file.getAbsolutePath());
            return file.getAbsolutePath();
        } else {
            System.err.println("ERROR: content-type= " + contentType);
            String res  = ConnUtil.getResponseString(conn);
            System.err.println(res);
        }
        return null;
    }
}
