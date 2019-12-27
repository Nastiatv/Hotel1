package com.hotel;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hotel.api.service.IAdministrator;
import com.hotel.enums.Status;
import com.hotel.service.Administrator;

@SpringBootApplication
public class HotelApplicationMain {

	public static void main(String[] args) {
		SpringApplication.run(HotelApplicationMain.class, args);
		
	}
}
