package com.village.farmer;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class FarmerApplication {

	public static void main(String[] args)  {
		SpringApplication.run(FarmerApplication.class, args);
//		openHomePage();
	}
	
//	private static void openHomePage() throws IOException {
//       Runtime rt = Runtime.getRuntime();
//       rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:9000/swagger-ui-custom.html");
//	}

}
/*

 */