package com.iot.common.dao.base;

import java.lang.reflect.ParameterizedType;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.RowBounds;

import com.iot.common.mapper.base.CommonFuncMapper;
import com.iot.common.mapper.entity.base.BaseEntity;
import com.iot.common.mapper.entity.base.CommonEntity;
import com.iot.common.paging.PageInfo;

/**
 * @Class Name BaseExtDao
 * @since 2019.April.17
 * @param <M> 实体对应的数据库表对象的操作
 * @param <E> 实体对应的数据库表对象的entity
 * @param <C> entity对象对应的数据库查询条件封装
 * @param <K> entity对象对应的数据库表对象中的主键值
 * @see 调用mapper中的数据库操作方法实现entity增加，修改，删除和查询操作。
 */
public abstract class EnhancedBaseDao<M extends CommonFuncMapper<E, C, K>, E, C, K> extends BaseDao<M, M, E> {

	@SuppressWarnings("unchecked")
	@Override
	protected void setMapperClass() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		Class<M> clazz = (Class<M>) type.getActualTypeArguments()[0];
		this.setMapperClass(clazz);
		this.setExtMapperClass(clazz);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void setEntityClass() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.setEntityClass((Class<E>) type.getActualTypeArguments()[1]);
	}
	
	protected String generateUuid() {
		String id = UUID.randomUUID().toString();
		id = id.replace("-", "");
		return id;
	}

	public E insert(final E record) {
		if (record == null) {
			logger.info("输入数据记录为空，插入失败！");
			return null;
		}
		if (record instanceof BaseEntity) {
			BaseEntity curRecord = (BaseEntity) record;
			curRecord.setCreateTime(new Timestamp(System.currentTimeMillis()));
			if (curRecord instanceof CommonEntity) {
				CommonEntity newRecord = (CommonEntity) record;
				newRecord.setId(generateUuid());
			}
		}
		int result = this.getMapper().insertSelective(record);
		if (result <= 0) {
			logger.info("insert: 插入记录失败！");
			return null;
		} else
			return record;
	}

	public int update(final E record) {
		return this.getMapper().updateByPrimaryKeySelective(record);
	}
	
	public int updateByPrimaryKey(final E record) {
		return this.getMapper().updateByPrimaryKey(record);
	}

	public int delete(final K key) {
		return this.getMapper().deleteByPrimaryKey(key);
	}

	public int batchDelete(final C example) {
		return this.getMapper().deleteByExample(example);
	}

	public E get(final K key) {
		return this.getMapper().selectByPrimaryKey(key);
	}

	public List<E> select(final C example) {
		return this.getMapper().selectByExample(example);
	}

	public PageInfo<E> select(final C example, final int page, final int size) {
		M mapper = this.getMapper();
		long total = mapper.countByExample(example);
		PageInfo<E> pageInfo = new PageInfo<>();
		pageInfo.setPageSize(size);
		pageInfo.setCurrentPage(page);
		pageInfo.setCount(total);
		if (total > 0) {
			RowBounds rowBounds = new RowBounds(pageInfo.getStart() - 1, size);
			pageInfo.setRows(mapper.selectByExampleWithRowbounds(example, rowBounds));
		} else {
			pageInfo.setRows(new ArrayList<E>(0));
		}
		return pageInfo;
	}
}
