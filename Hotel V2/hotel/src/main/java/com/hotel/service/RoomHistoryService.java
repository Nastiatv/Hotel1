package com.hotel.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hotel.api.service.IRoomHistoryService;
import com.hotel.dao.RoomHistoryDao;
import com.hotel.dao.ServiceDao;
import com.hotel.entity.Guest;
import com.hotel.entity.Room;
import com.hotel.entity.RoomHistory;
import com.hotel.entity.Service;
import com.hotel.enums.Status;

public class RoomHistoryService implements IRoomHistoryService {

	private static final Logger logger = LoggerFactory.getLogger(RoomHistoryService.class);

	@Override
	public void addRoomHistory(RoomHistory roomHistory) {
		if (!getAllHistoryId().contains(roomHistory.getId())) {
			RoomHistoryDao.getInstance().addRoomHistory(roomHistory);
		} else {
			logger.info("Such a history already exists");
		}
	}

	@Override
	public RoomHistory getRoomHistory(int id) {
		if (getAllHistoryId().contains(id)) {
			return RoomHistoryDao.getInstance().getRoomHistory(id);
		} else {
			logger.info("There are no such history");
			return null;
		}
	}

	@Override
	public void deleteRoomHistory(int id) {
		if (getAllHistoryId().contains(id)) {
			RoomHistoryDao.getInstance().deleteRoomHistory(id);
		} else {
			logger.info("There are no such history");
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
		String info = "The room ";
		int gid = room.getId();
		String info2 = " is occupied by the client ";
		int rid = guest.getId();
		logger.info(info, gid);
		logger.info(info2, rid);
	}

	public void checkOut(int idHistory, LocalDate checkOutDate) {
		RoomHistory rh = RoomHistoryDao.getInstance().getRoomHistory(idHistory);
		rh.setCheckOutDate(checkOutDate);
		rh.setStatus(Status.FREE);
		rh.getRoom().setStatus(Status.FREE);
		String info = "The client ";
		int gid = rh.getGuest().getId();
		String info2 = "has left the room ";
		int rid = rh.getRoom().getId();
		logger.info(info, gid);
		logger.info(info2, rid);
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
		String info = "Pay for accommodation: ";
		int roomFee = countRoomFee(idRoomHistory);
		String info2 = " and for service: ";
		int servieFee = RoomHistoryDao.getInstance().getRoomHistory(idRoomHistory).getServiceFee();
		logger.info(info, roomFee);
		logger.info(info2, servieFee);
	}

	private void updateServiceFee(int idService, int idRoomHistory, LocalDate start, LocalDate end) {
		RoomHistory rh = RoomHistoryDao.getInstance().getRoomHistory(idRoomHistory);
		if (rh.getServiceFee() == 0) {
			int serviceFee = getDaysBetweenDates(start, end)
					* ServiceDao.getInstance().getServicefromList(idService).getDailyPrice();
			rh.setServiceFee(serviceFee);
		} else {
			int extraServiceFee = getDaysBetweenDates(start, end)
					* ServiceDao.getInstance().getServicefromList(idService).getDailyPrice();
			rh.setServiceFee(rh.getServiceFee() + extraServiceFee);
		}
	}

	private int countRoomFee(int idRoomHistory) {
		return RoomHistoryDao.getInstance().getRoomHistory(idRoomHistory).getRoom().getDailyPrice()
				* getDaysOfStay(idRoomHistory);
	}

	private List<Integer> getAllHistoryId() {
		return RoomHistoryDao.getInstance().getAllRoomHistories().stream().map(RoomHistory::getId)
				.collect(Collectors.toList());
	}

	private int getDaysBetweenDates(LocalDate start, LocalDate end) {
		Period period = Period.between(start, end);
		return period.getDays();
	}

	private int getDaysOfStay(int idRoomHistory) {
		RoomHistory rh = RoomHistoryDao.getInstance().getRoomHistory(idRoomHistory);
		return getDaysBetweenDates(rh.getCheckInDate(), rh.getCheckOutDate());
	}
}
