package com.fairyonline.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

/**
 * 与连接相关的Util�?
 */
public class ConnUtil {

    /**
     * UrlEncode�? UTF-8 编码
     *
     * @param str 原始字符�?
     * @return
     */
    public static String urlEncode(String str) {
        String result = null;
        try {
            result = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 从HttpURLConnection 获取返回的字符串
     *
     * @param conn
     * @return
     * @throws IOException
     * @throws DemoException
     */
    public static String getResponseString(HttpURLConnection conn) throws IOException, DemoException {
        return new String(getResponseBytes(conn));
    }

    /**
     * 从HttpURLConnection 获取返回的bytes
     * 注意 HttpURLConnection自身问题�? 400类错误，会直接抛出异常�?�不能获取conn.getInputStream();
     *
     * @param conn
     * @return
     * @throws IOException   http请求错误
     * @throws DemoException http 的状态码不是 200
     */
    public static byte[] getResponseBytes(HttpURLConnection conn) throws IOException, DemoException {
        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            System.err.println("http 请求返回的状态码错误，期�?200�? 当前�? " + responseCode);
            if (responseCode == 401) {
                System.err.println("可能是appkey appSecret 填错");
            }
            throw new DemoException("http response code is" + responseCode);
        }

        InputStream inputStream = conn.getInputStream();
        byte[] result = getInputStreamContent(inputStream);
        return result;
    }

    /**
     * 将InputStream内的内容全部读取，作为bytes返回
     *
     * @param is
     * @return
     * @throws IOException @see InputStream.read()
     */
    public static byte[] getInputStreamContent(InputStream is) throws IOException {
        byte[] b = new byte[1024];
        // 定义�?个输出流存储接收到的数据
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // �?始接收数�?
        int len = 0;
        while (true) {
            len = is.read(b);
            if (len == -1) {
                // 数据读完
                break;
            }
            byteArrayOutputStream.write(b, 0, len);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
