package com.notstop.nsgtd;


import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notstop.nsgtd.mapper.TestMapper;

@RestController
public class MainController {

    @RequestMapping(value="/")
    private String hello() {
    	System.out.println("hello, world");
    	try {
//    		run2();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        return "Helo worl_02d!!";
    }


    // MyBatis
    private final TestMapper testMapper;

    public MainController(TestMapper testMapper) {
        this.testMapper = testMapper; // Mapperをインジェクションする
    }

    @Transactional
    public void run2() throws Exception {
    	System.out.println("START");
//        Todo newTodo = new Todo();
//        newTodo.setTitle("飲み会");
//        newTodo.setDetails("銀座 19:00");

    	testMapper.insert(); // 新しいTodoをインサートする

//        Todo loadedTodo = todoMapper.select(newTodo.getId()); // インサートしたTodoを取得して標準出力する
//        System.out.println("ID       : " + loadedTodo.getId());
//        System.out.println("TITLE    : " + loadedTodo.getTitle());
//        System.out.println("DETAILS  : " + loadedTodo.getDetails());
//        System.out.println("FINISHED : " + loadedTodo.isFinished());
    	System.out.println("FINISHED");
    }
}