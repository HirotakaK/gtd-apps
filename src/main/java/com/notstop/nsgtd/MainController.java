package com.notstop.nsgtd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.appengine.api.rdbms.AppEngineDriver;

@RestController
public class MainController {

    @RequestMapping(value="/")
    private String hello() {
    	System.out.println("hello, world");
    	try {
			testsql();
		} catch (ServletException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        return "Helo worl_01d!!";
    }

    private void testsql() throws ServletException {
    	// mygcpproject-146511:us-west1:dev-mysql57
    	// value="jdbc:google:mysql://${INSTANCE_CONNECTION_NAME}/${database}?user=${user}&amp;password=${password}" />
//    	String DB_URL = "jdbc:google:rdbms://mygcpproject-146511:us-west1:dev-mysql57/test1";
    	String DB_URL = "jdbc:mysql://localhost:56492/TEST?characterEncoding=UTF-8&serverTimezone=JST";
    	String user = "adminUser";
    	String password = "Tomyan_76";
    	String INSERT_SQL = "INSERT INTO user (name) VALUES(?)";
    	Connection c = null;

    	try {
    		Class.forName( "com.mysql.jdbc.Driver" ).newInstance();
//    		DriverManager.registerDriver(new AppEngineDriver());
    	      c = DriverManager.getConnection(DB_URL, user, password);
//    	      c = DriverManager.getConnection(DB_URL);
//    	      String name = req.getParameter("name");
    	      String name = "a1";
    	      if (name == "") {
//    	        out.println("<html><head></head><body>You are missing either a message or a name! Try again! Redirecting in 3 seconds...</body></html>");
    	      } else {
    	        String statement = INSERT_SQL;
    	        PreparedStatement stmt = c.prepareStatement(statement);
    	        stmt.setString(1, name);
    	        int success = 2;
    	        success = stmt.executeUpdate();
    	        if (success == 1) {
//    	          out.println("<html><head></head><body>Success! Redirecting in 3 seconds...</body></html>");
    	        } else if (success == 0) {
//    	          out.println("<html><head></head><body>Failure! Please try again! Redirecting in 3 seconds...</body></html>");
    	        }
    	      }
    	    } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
    	      e.printStackTrace();
    	    } finally {
    	      if (c != null)
    	        try {
    	          c.close();
    	        } catch (SQLException ignore) {
    	        }
    	    }
//    	    resp.setHeader("Refresh", "3; url=/mysqltest.jsp");
    	  }
}