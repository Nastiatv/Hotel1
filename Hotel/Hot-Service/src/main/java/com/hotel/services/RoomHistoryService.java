package com.hotel.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.hotel.api.service.IRoomHistoryService;
import com.hotel.dao.RoomHistoryDao;
import com.hotel.dao.ServiceDao;
import com.hotel.entities.Guest;
import com.hotel.entities.Room;
import com.hotel.entities.RoomHistory;
import com.hotel.entities.Service;
import com.hotel.enums.Status;

public class RoomHistoryService implements IRoomHistoryService {

	@Override
	public void addRoomHistory(RoomHistory roomHistory) {
		if (!getAllHistoryId().contains(roomHistory.getId())) {
			RoomHistoryDao.getInstance().addRoomHistory(roomHistory);
		} else {
			System.out.println("Such a history already exists");
		}
	}

	@Override
	public RoomHistory getRoomHistory(int id) {
		if (getAllHistoryId().contains(id)) {
			return RoomHistoryDao.getInstance().getRoomHistory(id);
		} else {
			System.out.println("There are no such history");
			return null;
		}
	}

	@Override
	public void deleteRoomHistory(int id) {
		if (getAllHistoryId().contains(id)) {
			RoomHistoryDao.getInstance().deleteRoomHistory(id);
			;
		} else {
			System.out.println("There are no such history");
		}
	}

	@Override
	public List<RoomHistory> getAll() {
		return RoomHistoryDao.getInstance().getAllRoomHistories();
	}

	public void checkIn(int idHistory, Room room, Guest guest, LocalDate checkInDate) {
		RoomHistoryDao.getInstance().addRoomHistory(new RoomHistory(idHistory, room, guest, checkInDate));
		RoomHistoryDao.getInstance().getRoomHistory(idHistory).setStatus(Status.OCCUPIED);
		room.setStatus(Status.OCCUPIED);
		System.out.println("The room "+room.getId()+" is occupied by the client "+guest.getId());
	}

	public void checkOut(int idHistory, LocalDate checkOutDate) {
		RoomHistory rh = RoomHistoryDao.getInstance().getRoomHistory(idHistory);
		rh.setCheckOutDate(checkOutDate);
		rh.setStatus(Status.FREE);
		rh.getRoom().setStatus(Status.FREE);
		System.out.println("The client "+rh.getGuest().getId()+" has left the room "+rh.getRoom().getId());
		printFee(idHistory);
	}

	public void orderService(int idService, int idHistory, LocalDate start, LocalDate end) {
		if (RoomHistoryDao.getInstance().getRoomHistory(idHistory).getServices() == null) {
			List<Service> listserv = new ArrayList<>();
			listserv.add(ServiceDao.getInstance().getServicefromList(idService));
			RoomHistoryDao.getInstance().getRoomHistory(idHistory).setServices(listserv);
		} else {
			List<Service> listserv = RoomHistoryDao.getInstance().getRoomHistory(idHistory).getServices();
			listserv.add(ServiceDao.getInstance().getServicefromList(idService));
			RoomHistoryDao.getInstance().getRoomHistory(idHistory).setServices(listserv);
		}
		updateServiceFee(idService, idHistory, start, end);
	}

	public void printFee(int idRoomHistory) {
		System.out.println("Pay for accommodation: " + countRoomFee(idRoomHistory) + " and for service: "
				+ RoomHistoryDao.getInstance().getRoomHistory(idRoomHistory).getServiceFee());
	}

	private void updateServiceFee(int idService, int idRoomHistory, LocalDate start, LocalDate end) {
		RoomHistory rh = RoomHistoryDao.getInstance().getRoomHistory(idRoomHistory);
		if (rh.getServiceFee() == 0) {
			int serviceFee = getDaysBetweenDates(start, end) * ServiceDao.getInstance().getServicefromList(idService).getDailyPrice();
			rh.setServiceFee(serviceFee);
		} else {
			int extraServiceFee = getDaysBetweenDates(start, end)
					* ServiceDao.getInstance().getServicefromList(idService).getDailyPrice();
			rh.setServiceFee(rh.getServiceFee() + extraServiceFee);
		}
	}

	private int countRoomFee(int idRoomHistory) {
		return RoomHistoryDao.getInstance().getRoomHistory(idRoomHistory).getRoom().getDailyPrice() * getDaysOfStay(idRoomHistory);
	}

	private List<Integer> getAllHistoryId() {
		return RoomHistoryDao.getInstance().getAllRoomHistories().stream().map(y -> y.getId()).collect(Collectors.toList());
	}

	private int getDaysBetweenDates(LocalDate start, LocalDate end) {
		Period period = Period.between(start, end);
		return period.getDays();
	}

	private int getDaysOfStay(int IdRoomHistory) {
		RoomHistory rh = RoomHistoryDao.getInstance().getRoomHistory(IdRoomHistory);
		return getDaysBetweenDates(rh.getCheckInDate(), rh.getCheckOutDate());
	}
}
