package com.iot.common.util;

import java.util.UUID;

public class IdHelper {

	public static String generateUuid() {
		String id = UUID.randomUUID().toString();
		id = id.replace("-", "");
		return id;
	}
	
	public static String generateGroupRoutingKey(int groupId) {
		return "gp".concat(Integer.toString(groupId));
	}
}
