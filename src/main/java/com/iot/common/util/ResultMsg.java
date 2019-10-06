package com.iot.common.util;

public class ResultMsg {

	private int status = 200; // http status code, 200 for ok, 400 for client side issue, 500 for server side
								// issue
	private String error; // for specific error code
	private String message; // for specific error message
	private Object data; // for biz data payload

	public ResultMsg() {

	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ResultMsg(Object data) {
		this.data = data;
	}

	public ResultMsg(int status, String error, String message) {
		this.status = status;
		this.error = error;
		this.message = message;
	}

	public static ResultMsg constructSuccessMsg() {
		ResultMsg result = new ResultMsg();
		result.status = MessageConstants.SUCCESS;
		result.message = MessageConstants.SUCCESS_MES;
		return result;
	}

	public static ResultMsg constructSuccessMsg(Object data) {
		ResultMsg result = new ResultMsg();
		result.status = MessageConstants.SUCCESS;
		result.message = MessageConstants.SUCCESS_MES;
		result.setData(data);
		return result;
	}

	public static ResultMsg constructErrorMsg() {
		ResultMsg result = new ResultMsg();
		result.status = MessageConstants.GENERALERROR;
		result.message = MessageConstants.GENERALERROR_MES;
		return result;
	}

	public static ResultMsg constructAddSuccessMsg() {
		ResultMsg result = new ResultMsg();
		result.status = MessageConstants.ADD_SUCCESS;
		result.message = MessageConstants.ADD_SUCCESS_MES;
		return result;
	}

	public static ResultMsg constructUpdateSuccessMsg() {
		ResultMsg result = new ResultMsg();
		result.status = MessageConstants.UPDATE_SUCCESS;
		result.message = MessageConstants.UPDATE_SUCCESS_MES;
		return result;
	}

	public static ResultMsg constructAddErrorMsg() {
		ResultMsg result = new ResultMsg();
		result.status = MessageConstants.ADD_ERROR;
		result.message = MessageConstants.ADD_ERROR_MES;
		return result;
	}

	public static ResultMsg constructUpdateErrorMsg() {
		ResultMsg result = new ResultMsg();
		result.status = MessageConstants.UPDATE_ERROR;
		result.message = MessageConstants.UPDATE_ERROR_MES;
		return result;
	}

	public static ResultMsg constructResult(int code, String message) {
		ResultMsg result = new ResultMsg();
		result.setStatus(code);
		result.setMessage(message);
		return result;
	}
}
