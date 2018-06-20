package com.fairyonline.statics;

import java.util.HashMap;
import java.util.Map;

public class Result {
	private HashMap re = new HashMap<String,Object>(3);
	
	private String statusCode = "000000";
	private String desc = "Ö´ÐÐ³É¹¦" ;
	private Map result= new HashMap<String,Object>(1); ;
	
	public Result() {	}
	
	public Result(HashMap re, String statusCode, String desc, Map result) {
		this.re = re;
		this.statusCode = statusCode;
		this.desc = desc;
		this.result = result;
	}

	public HashMap getRe() {
		re.put("statusCode", statusCode);
        re.put("desc", desc);
        re.put("result", result);
		return re;
	}

	public void setRe(HashMap re) {
		this.re = re;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Map getResult() {
		return result;
	}

	public void setResult(Map result) {
		this.result = result;
	}
	
	
	
	
	
}
