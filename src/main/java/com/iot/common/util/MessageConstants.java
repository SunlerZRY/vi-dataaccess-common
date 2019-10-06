package com.iot.common.util;

public class MessageConstants {
	
	final static public int SUCCESS = 200;
	final static public String SUCCESS_MES  = "服务执行成功";
	
	final static public int DUPLICATE_SUCCESS = 2000;
	final static public String DUPLICATE_SUCCESS_MES  = "服务重复执行，成功";
	
	final static public int GENERALERROR = 0;
	final static public String GENERALERROR_MES  = "服务执行失败";

	final static public int ADD_SUCCESS = 1;
	final static public String ADD_SUCCESS_MES  = "添加数据成功";
	
	final static public int UPDATE_SUCCESS = 2;
	final static public String UPDATE_SUCCESS_MES  = "数据更新成功";
	
	final static public int ADD_ERROR = -1;
	final static public String ADD_ERROR_MES  = "数据添加失败";
	
	final static public int UPDATE_ERROR = -2;
	final static public String UPDATE_ERROR_MES  = "数据更新失败";
}
