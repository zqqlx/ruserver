package com.sf.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
*	FileName: MDBManager.java
*   @Description TODO
* 	@author zqq
*   @Version V1.0
*   create 2017��10��14�� ����9:07:37
*/
public class MDBManager {
	
	private static Logger log = Logger.getLogger(MDBManager.class);
	//���ݿ����ӵ��û���
	private static String user = "";
	//���ݿ����ӵ�����
	private static String password = "";
	//���ݿ����ӵ�url
	private static String url = "";
	//���ݿ����ӵ�����
	private static String driver = "";
	private static final MDBManager instance = new MDBManager();
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	//˽�л����캯��
	private MDBManager(){
		
	}
	//�ṩ���еķ���
	public  Connection getConnection() throws SQLException{
		
		return this.dataSource.getConnection();
	}
	
	public void config(File filePath){
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(filePath);
			config(fis);
		}catch(Exception e){
			log.error("Exception: "+e.getMessage(), e);
		}
	}
	public void config(InputStream ins){
		Properties prop = null;
		try{
			try{
				prop.load(ins);
			}catch(IOException e){
				log.error("Exception: "+e.getMessage(), e);
			}
		}catch(Exception e){
			log.error("Exception: " + e.getMessage(), e);
		}
		try{
			if(prop != null){
				user = prop.getProperty("db.user");
				password = prop.getProperty("db.password");
				driver = prop.getProperty("db.driver");
				url = prop.getProperty("db.url");
				dataSource.setUser(user);
				dataSource.setPassword(password);
				dataSource.setJdbcUrl(url);
				dataSource.setMinPoolSize(5);
				dataSource.setMaxStatements(100);
				dataSource.setMaxIdleTime(20);
			}
		}catch(Exception e){
			log.error("Exception:"+e.getMessage(), e);
		}
	}
	
}
