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
		
		
		IAdministrator admin=new Administrator();

		admin.createRoom(0, 1, 50, Status.FREE);
		admin.createRoom(1, 1, 50, Status.FREE);
		admin.createRoom(2, 2, 70, Status.FREE);
		admin.createRoom(3, 2, 70, Status.FREE);
		admin.createRoom(4, 3, 80, Status.FREE);
		admin.createRoom(5, 4, 80, Status.FREE);
		

		admin.createService(0, 20, Status.FREE, "Laundry");
		admin.createService(1, 100, Status.FREE, "Restaurant");
		admin.createService(2, 10, Status.FREE, "Wifi");
		admin.createService(3, 5, Status.FREE, "Parking");
		
		
		admin.createGuest(0);
		admin.createGuest(1);
		admin.createGuest(2);
		admin.createGuest(3);
		admin.createGuest(4);
		admin.createGuest(5);
		
		
		admin.checkIn(0, admin.getRoom(0), admin.getGuest(0), LocalDate.of(2019, 12, 31));
		admin.checkIn(1, admin.getRoom(1), admin.getGuest(1), LocalDate.of(2019, 12, 31));
		admin.checkIn(2, admin.getRoom(2), admin.getGuest(2), LocalDate.of(2019, 12, 31));
		admin.checkIn(3, admin.getRoom(3), admin.getGuest(3), LocalDate.of(2019, 12, 31));
		admin.checkIn(4, admin.getRoom(4), admin.getGuest(4), LocalDate.of(2019, 12, 31));
		admin.checkIn(5, admin.getRoom(5), admin.getGuest(5), LocalDate.of(2019, 12, 31));


		admin.orderService(0, 0, LocalDate.of(2019, 12, 31), LocalDate.of(2020, 1, 2));
		admin.orderService(1, 1, LocalDate.of(2019, 12, 31), LocalDate.of(2020, 1, 2));
		admin.orderService(2, 2, LocalDate.of(2019, 12, 31), LocalDate.of(2020, 1, 2));
		admin.orderService(3, 3, LocalDate.of(2019, 12, 31), LocalDate.of(2020, 1, 2));
		admin.orderService(2, 4, LocalDate.of(2019, 12, 31), LocalDate.of(2020, 1, 2));
		admin.orderService(2, 5, LocalDate.of(2019, 12, 31), LocalDate.of(2020, 1, 2));

		admin.checkOut(0, LocalDate.of(2020, 1, 2));
		admin.checkOut(1, LocalDate.of(2020, 1, 2));
		admin.checkOut(2, LocalDate.of(2020, 1, 2));
		admin.checkOut(3, LocalDate.of(2020, 1, 2));
		admin.checkOut(4, LocalDate.of(2020, 1, 2));
		admin.checkOut(5, LocalDate.of(2020, 1, 2));

	}

}