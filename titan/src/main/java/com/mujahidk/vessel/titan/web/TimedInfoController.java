package com.mujahidk.vessel.titan.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mujahidk.vessel.titan.persistence.dao.TimedInfoDao;
import com.mujahidk.vessel.titan.persistence.entity.TimedInfo;

@Controller
@RequestMapping(value = "/events")
public class TimedInfoController {

	private final TimedInfoDao dao;

	@Autowired
	public TimedInfoController(TimedInfoDao dao) {
		this.dao = dao;
	}

	@GetMapping
	public ResponseEntity<Page<TimedInfo>> events() {
		return ResponseEntity.ok(dao.findAll(PageRequest.of(0, 50)));
	}
}
