package com.joe.jsf.dao;

import com.joe.jsf.model.Product;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProductMapper {

  /**
   * 添加操作，返回新增元素的 ID
   *
   * @param product
   */
  @Insert("insert into product(depCity,arrCity,depDate) values(#{depCity},#{arrCity},#{depDate})")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insert(Product product);

  /**
   * 查询所有
   *
   * @return
   */
  @Select("select id,depCity,arrCity,depDate from product")
  List<Product> selectAll();
}
