package com.iot.common.service.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.iot.common.dao.base.EnhancedBaseDao;
import com.iot.common.mapper.entity.base.BaseEntity;

@Component
public abstract class BaseService {

	private static final Logger logger = LoggerFactory.getLogger(BaseService.class);

	protected Map<String, EnhancedBaseDao> dtoMaps = null;
	
	public BaseService() {
		dtoMaps = new HashMap<String, EnhancedBaseDao>();
	}
	
	/*
	 * entity的getClass().getName()作为key，对应的dto作为value
	 */
	@PostConstruct
	abstract protected void setDtoToMap();
	
	public Object add(Object record) {
		EnhancedBaseDao curDto = dtoMaps.get(record.getClass().getName());
        return (BaseEntity)curDto.insert(record);
	}
	
	public int modify(Object record) {
		EnhancedBaseDao curDto = dtoMaps.get(record.getClass().getName());
        return curDto.updateByPrimaryKey(record);
	}

	public int delete(Object record, String key) {
		EnhancedBaseDao curDto = dtoMaps.get(record.getClass().getName());
		return curDto.delete(key);
	}
}
