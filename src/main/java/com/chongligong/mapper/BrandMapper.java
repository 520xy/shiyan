package com.chongligong.mapper;

import com.chongligong.pojo.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;

public interface BrandMapper {
   List<Brand> selectAll();
   void add(Brand brand);
   @Update("update tb_brand set brand_name=#{brandName},company_name=#{companyName},ordered=#{ordered},description=#{description},status=#{status} where id=#{id}")
   @ResultMap("brandResultMap")
   void update(Brand brand);
   Brand  selectById(Integer id);
   @Delete("delete from tb_brand where id=#{id}")
   void deleteById(Integer id);

}
