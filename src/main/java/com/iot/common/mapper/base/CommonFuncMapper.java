package com.iot.common.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CommonFuncMapper<E, C, K> {
  long countByExample(C example);

  int deleteByExample(C example);

  int deleteByPrimaryKey(K key);

  int insert(E record);

  int insertSelective(E record);

  List<E> selectByExampleWithRowbounds(C example, RowBounds rowBounds);

  List<E> selectByExample(C example);

  E selectByPrimaryKey(K key);

  int updateByExampleSelective(@Param("record") E record, @Param("example") C example);

  int updateByExample(@Param("record") E record, @Param("example") C example);

  int updateByPrimaryKeySelective(E record);

  int updateByPrimaryKey(E record);
}
