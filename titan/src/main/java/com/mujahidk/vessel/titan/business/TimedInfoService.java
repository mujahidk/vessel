package com.mujahidk.vessel.titan.business;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mujahidk.vessel.titan.persistence.dao.TimedInfoDao;
import com.mujahidk.vessel.titan.persistence.entity.TimedInfo;

@Service
public class TimedInfoService {

	private final TimedInfoDao dao;

	@Autowired
	public TimedInfoService(final TimedInfoDao dao) {
		this.dao = dao;
	}

	public void createInfo(String information) {
		dao.save(new TimedInfo(information, LocalDateTime.now()));
	}
}
