package com.spring_life_cycle;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring_life_cycle/beans.xml");
		StudentDao dao = context.getBean("studentDao",StudentDao.class);
		dao.selectAllRows();
	}
}
