package com.iot.common.util;

import java.util.List;

public class BoundaryHelper {

	public static boolean isInvalidateId(Long id) {
		if(id < 0)
			return true;
		else
			return false;
	}
	
	public static boolean isBlankContent(String content) {
		if(content == null || content.trim().equals(""))
			return true;
		else
			return false;
	}

	public static boolean isNotBlankContent(String content) {
		return content!=null && !content.trim().equals("");
	}
	
	public static boolean isEmpty(List contents) {
		if(contents == null || contents.size() <= 0)
			return true;
		else
			return false;
	}
}
