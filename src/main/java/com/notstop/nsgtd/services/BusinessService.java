package com.notstop.nsgtd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.notstop.nsgtd.mapper.DbMapper;

/**
 * ビジネスロジックを実装するファイルです
 * */

@Service
public class BusinessService{

	// MyBatis
	@Autowired
	private DbMapper dbMapper;

	/**
	 * ユーザーIDよりタスクとユーザー情報のJSONを取得する
	 * @method getUserTasks
	 * @param {uid} ユーザーID
	 * @return {json} タスクとユーザー情報
	 * */
	@Transactional
	public void getUserTasks(String uid) {
		System.out.println("aaaaaaaaaaaa1");
		System.out.println(uid);
		System.out.println("bbbbbbbbbbbb1");
		System.out.println("START");
		//      Todo newTodo = new Todo();
		//      newTodo.setTitle("飲み会");
		//      newTodo.setDetails("銀座 19:00");
		//
		dbMapper.insert2("e1"); // 新しいTodoをインサートする
		//
		//      Todo loadedTodo = todoMapper.select(newTodo.getId()); // インサートしたTodoを取得して標準出力する
		//      System.out.println("ID       : " + loadedTodo.getId());
		//      System.out.println("TITLE    : " + loadedTodo.getTitle());
		//      System.out.println("DETAILS  : " + loadedTodo.getDetails());
		//      System.out.println("FINISHED : " + loadedTodo.isFinished());
		System.out.println("FINISHED");

	}
}
