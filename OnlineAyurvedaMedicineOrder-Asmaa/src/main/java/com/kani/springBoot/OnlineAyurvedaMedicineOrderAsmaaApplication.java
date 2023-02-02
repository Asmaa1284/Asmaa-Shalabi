package com.kani.springBoot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineAyurvedaMedicineOrderAsmaaApplication {
	private static final Logger LOGGER=LoggerFactory.getLogger(OnlineAyurvedaMedicineOrderAsmaaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OnlineAyurvedaMedicineOrderAsmaaApplication.class, args);
        System.out.println("Hello Spring!-----------------------------------------------Asmaa-------------------");
	}

}
