/**
 * Copyright 2017-2025 IBM.
 */
package com.iot.common.controller.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.iot.common.mapper.entity.base.BaseEntity;
import com.iot.common.service.base.BaseService;
import com.iot.common.util.ResultMsg;


/**
 * BaseWebController
 * @author 
 * @since 2019.April.17
 */
public class BaseWebController <T extends BaseEntity> extends BaseController {

	@InitBinder
	protected void initBaseBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateEditor());
		binder.registerCustomEditor(Boolean.class, new CustomBooleanEditor(
				"true", "false", true));
	}
	
	protected ResultMsg insert(BaseService baseService, BaseEntity baseEntity) {
		BaseEntity insertObject = (BaseEntity) baseService.add(baseEntity);
		ResultMsg msg = new ResultMsg();
		msg.setData(insertObject);
		return msg;
	}

	protected ResultMsg update(BaseService baseService, BaseEntity baseEntity) {
		int updateObject = baseService.modify(baseEntity);
		ResultMsg msg = new ResultMsg();
		msg.setData(updateObject);
		return msg;
	}

	protected ResultMsg delete(BaseService baseService, BaseEntity baseEntity, String primaryKey) {
		int deleteObject = baseService.delete(baseEntity,primaryKey);
		ResultMsg msg = new ResultMsg();
		msg.setData(deleteObject);
		return msg;
	}
	
   protected ResultMsg insert(BaseService baseService, List<T> baseEntities) {
		
		List<BaseEntity> insertObjects = new ArrayList<BaseEntity>();
		BaseEntity curObject= null;
		if(baseEntities != null && baseEntities.size() > 0) {
			for (BaseEntity curEntity : baseEntities) {
				curObject = (BaseEntity) baseService.add(curEntity);
				insertObjects.add(curObject);
			}
		}
		ResultMsg msg = new ResultMsg();
		msg.setData(insertObjects);
		return msg;
	}
}
