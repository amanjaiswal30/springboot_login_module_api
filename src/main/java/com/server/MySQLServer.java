package com.server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author Aman Jaiswal
 * Driver for the SpringBoot Server
 */
@SpringBootApplication
public class MySQLServer {
	public static void main(String[] args) {
		SpringApplication.run(MySQLServer.class, args);
	}
}