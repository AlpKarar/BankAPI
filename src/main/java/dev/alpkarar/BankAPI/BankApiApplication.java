package dev.alpkarar.BankAPI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankApiApplication implements CommandLineRunner {

	@Value("${server.port}")
	private String PORT;

	public static void main(String[] args) {
		SpringApplication.run(BankApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server started running on port " + PORT + "...");
	}
}
