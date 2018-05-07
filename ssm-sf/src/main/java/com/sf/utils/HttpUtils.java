package com.sf.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

/**
*	FileName: HttpUtils.java
* 	@author zqq
*   @Version V1.0
*   create 2017��11��5�� ����3:20:43
*   @Description ()
*/
public class HttpUtils {
	private static Logger logger = Logger.getLogger(HttpUtils.class.getName());

	public static String post(String url, Map<String, String> params, String encoding){
		URL u = null;
		HttpURLConnection con = null;
		String sendData = null;
		StringBuffer sb = new StringBuffer();
		if(params != null && params.size() > 0){
			for(Entry<String,String> e : params.entrySet()){
				sb.append(e.getKey());
				sb.append("=");
				sb.append(e.getValue());
				sb.append("&");
			}
		}
		//���Է�������
		sendData = sb.substring(0,sb.length()-1);
		try{
			u = new URL(url);
			con = (HttpURLConnection)u.openConnection();
			con.setRequestMethod("POST");
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setUseCaches(false);
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded);charset=" + encoding);
			con.setConnectTimeout(60 * 1000);
			con.setReadTimeout(60 * 1000);
		}catch(Exception e){
			logger.error("Exception: " + e.getMessage());
		}
		try{
			OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(),encoding);
			osw.write(sendData);
			osw.flush();
			osw.close();
		}catch(Exception e){
			logger.error("Exception: " +e.getMessage());
		}finally{
			if(con != null){
				con.disconnect();
				con = null;
			}
		}
		//��ȡ���ص�����
		StringBuffer buffer = new StringBuffer();
		try{
			int code = con.getResponseCode();
			String message = con.getResponseMessage();
			if(code == 200){
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),encoding));
				String temp;
				while((temp = br.readLine()) != null){
					buffer.append(temp);
					buffer.append("\n");
				}
			}else{
				buffer.append(code + " " + message);
			}
		}catch(Exception e){
			logger.error("Exception: " + e.getMessage(), e);
		}
		return buffer.toString();
	}
	
	public static void main(String[]args){
		
	}
}
