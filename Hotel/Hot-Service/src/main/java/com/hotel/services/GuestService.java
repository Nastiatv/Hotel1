package com.hotel.services;

import java.util.List;
import java.util.stream.Collectors;

import com.hotel.api.dao.IGuestDao;
import com.hotel.api.service.IGuestService;
import com.hotel.dao.GuestDao;
import com.hotel.entities.Guest;


public class GuestService implements IGuestService {

	IGuestDao daoGuests = new GuestDao();

	@Override
	public void addGuest(Guest guest) {
		if (!getAllGuestId().contains(guest.getId())) {
			daoGuests.addGuestToList(guest);
		} else {
			System.out.println("Such a guest already exists");
		}
	}

	@Override
	public Guest getGuest(int id) {
		if (getAllGuestId().contains(id)) {
			return daoGuests.getGuestFromList(id);
		} else {
			System.out.println("There are no such guest");
			return null;
		}
	}

	@Override
	public void deleteGuest(int id) {
		if (getAllGuestId().contains(id)) {
			daoGuests.deleteGuestFromList(id);
		} else {
			System.out.println("There are no such guest");
		}
	}

	@Override
	public List<Guest> getAll() {
		return daoGuests.getAllListGuests();
	}

	@Override
	public void printGuests(List<Guest> guests) {
		System.out.println("Here's the information about needed guests in our hotel:");
		for (Guest guest : guests) {
			StringBuilder sb = new StringBuilder();
			sb.append("Guest Pasport Number: ");
			sb.append(guest.getId());
			sb.append("; Number Of Guests: ");
			sb.append(guest.getNumberOfGuests());
			sb.append("; Room : ");
			sb.append(guest.getIdRoom());
			sb.append("; Is NonSmoking: ");
			sb.append(guest.isNonSmoking());
			sb.append("; Arrival Date : ");
			sb.append(guest.getArrivalDate());
			sb.append("; Departure Date : ");
			sb.append(guest.getDepartureDate());
			sb.append("; Services : ");
			sb.append(guest.getService().toString());
			System.out.println(sb);
		}
	}
	
	private List<Integer> getAllGuestId() {
		List<Integer> getAllGuestId = daoGuests.getAllListGuests().stream().map(y -> y.getId())
				.collect(Collectors.toList());
		return getAllGuestId;
	}
}