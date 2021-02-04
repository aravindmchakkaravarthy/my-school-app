package com.myschool.myschoolapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyschoolAppApplication {

	public static void main(String[] args) {
try{
	SpringApplication.run(MyschoolAppApplication.class, args);
}catch(Exception E){
	E.printStackTrace();
}

	}

}
