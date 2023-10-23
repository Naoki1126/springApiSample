package com.example.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.model.entity.User;

@Mapper
public interface UserMapper {
	
	/**
	 *全ユーザを取得
	 * 
	 * @return 全ユーザの情報
	 * 
	 * */
	List<User> selectAll();
}
