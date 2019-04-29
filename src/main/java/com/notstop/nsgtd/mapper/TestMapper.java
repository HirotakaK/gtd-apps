package com.notstop.nsgtd.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface TestMapper {
//	 @Insert("INSERT INTO todo (title, details, finished) VALUES (#{title}, #{details}, #{finished})")
	@Insert("INSERT INTO user (name) VALUES('b2')")
	    @Options(useGeneratedKeys = true)
	    void insert();

}
