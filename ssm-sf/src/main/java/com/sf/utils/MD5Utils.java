package com.sf.utils;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.*;

/**
* @Title MD5.java
* @package cn.zqq.main.domain
* @description TODO
* @date 2017��9��2�� ����10:15:55
* @author zqq
*/
import org.apache.log4j.Logger;
public class MD5Utils {

	private static Logger logger = Logger.getLogger(MD5Utils.class);
	
	public final static String MD5(String pwd){
		return MD5(pwd,"UTF-8");
	}

	private static String MD5(String pwd, String encoding) {
		// TODO Auto-generated method stub
		//���ڼ��ܵ��ַ�
		char md5String[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		//ʹ��ƽ̨��Ĭ���ַ�����String����Ϊbyte���У���������洢��һ���µ�byte������
		byte[]btInput = pwd.getBytes();
		//���ָ��ժҪ�㷨MessageDigest���󣬴˴�ΪMD5
		//MessageDigest��ΪӦ�ó����ṩ��ϢժҪ�㷨�Ĺ��ܣ���MD5 �� SHA �㷨
		//��ϢժҪ�ǰ�ȫ�ĵ����ϣ�����������������С�����ݣ�������̶����ȵĹ�ϣֵ��
		try{
			MessageDigest mdIns = MessageDigest.getInstance("MD5");
			mdIns.update(btInput);
			//ժҪ���º�ͨ������digestִ�й�ϣ���㣬���������
			byte[]md = mdIns.digest();
			
			//������ת��Ϊ16�����ַ�����ʽ
			int j = md.length;
			char []str = new char[j*2];
			int k = 0;
			for(int i = 0; i < j; i ++){
				byte byte0 = md[i];
				str[k++] = md5String[byte0 >>> 4 & 0xf];
				str[k++] = md5String[byte0 & 0xf];
			}
			return new String(str);
		}catch(Exception e){
			logger.error("Exception: "+e.getMessage(), e);
			return null;
		}
	}
	
	public static String digest(String toVerfyText){
		String base64str = null;
		MessageDigest md5 = null;
		try{
			md5 = MessageDigest.getInstance("MD5");
			md5.update(toVerfyText.getBytes());
			byte[] md = md5.digest();
			base64str = new String(org.apache.commons.codec.binary.Base64.encodeBase64(md));
		}catch(Exception e){
			logger.error("Execption: "+e.getMessage(),e);
			return null;
		}
		return base64str;
	}
	
	public static String getURLEncoder(String urlCode, String encode){
		try{
			urlCode = URLEncoder.encode(urlCode,encode);
		}catch(Exception e){
			logger.error("Exception: " +e.getMessage(),e);
		}
		return urlCode;
	}
	
	public static String getURLDecoder(String urlCode, String encode){
		try{
			urlCode = URLDecoder.decode(urlCode,encode);
			
		}catch(Exception e){
			logger.error("Exception: "+e.getMessage(), e);
		}
		return urlCode;
	}
	
	public static void main(String[]args){
		System.out.println(MD5Utils.MD5("EO0000002@SF@aaaa","UTF-8"));
		
		System.out.println(MD5Utils.MD5("E123455@SF@aaaa","UTF-8"));
		
		System.out.println(MD5Utils.digest("E123455@SF@a88aa"));
		String encodeStr = MD5Utils.getURLEncoder("http://www.baidu.com", "UTF-8");
		System.out.println(encodeStr);
		System.out.println(MD5Utils.getURLDecoder(encodeStr,"UTF-8"));
	}
}


