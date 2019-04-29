package com.notstop.nsgtd;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.web.bind.annotation.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.notstop.nsgtd.mapper.TestMapper;

//@SpringBootApplication
//public class NsGtdApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(NsGtdApplication.class, args);
//	}
//
//}

@SpringBootApplication
public class NsGtdApplication implements CommandLineRunner { // CommandLineRunnerを実装する

    public static void main(String[] args) {
        SpringApplication.run(NsGtdApplication.class, args);
    }

    private final TestMapper testMapper;

    public NsGtdApplication(TestMapper testMapper) {
        this.testMapper = testMapper; // Mapperをインジェクションする
    }

    // Spring Boot起動時にCommandLineRunner#runメソッドが呼び出される
    @Transactional
    @Override
    public void run(String... args) throws Exception {
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