package com.sf.utils;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
*	FileName: GsonUtil.java
*   @Description TODO
* 	@author zqq
*   @Version V1.0
*   create 2017��10��14�� ����8:29:23
*/

public class GsonUtil {

	private GsonUtil(){
		
	}
	private static class SingleContainer{
		private static GsonUtil instance = new GsonUtil();
	}
	public static GsonUtil getGsonUtilInstance(){
		return SingleContainer.instance;
	}
	
	public static Object getJSONByObject(Object object){
		Gson son = new Gson();
		return son.toJson(object);
	}
	
	public static <T> T getObjectByJSON(String json, Class<T> clazz){
		Gson son = new Gson();
		return son.fromJson(json, clazz);
	}
	
	public static void main(String[]args){
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("1", "ab");
//		map.put("2", "b");
//		map.put("3", "c");
//		System.out.println(getJSONByObject(map));
//		Person p = new Person();
//		p.setName("zqq");
//		p.setAge(123);
//		Object obj = getJSONByObject(p);
//		System.out.println(obj);
//		JSONObject.fromObject(obj);
//		Person p1 = (Person)getObjectByJSON(obj.toString(),Person.class);
//		System.out.println(p1.getName()+"::"+p1.getAge());
//		
//		String str = "[{name:'a',value:'aa'},{name:'b',value:'bb'},{name:'c',value:'cc'},{name:'d',value:'dd'}]" ;  // һ��δת�����ַ���
//		JSONArray jsonArray = JSONArray.fromObject(str);
//		for(int i =0; i < jsonArray.length(); i ++){
//			System.out.println(jsonArray.get(i));
//		}
	}
}
