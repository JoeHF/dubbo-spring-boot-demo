package com.joe.consumer.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {
  @Select("SELECT * FROM tbl_student WHERE id = #{id}")
  Student findById(@Param("id") int id);
}
