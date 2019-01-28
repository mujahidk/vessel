package com.mujahidk.vessel.titan.scheduler;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.mujahidk.vessel.titan.business.TimedInfoService;

public class TimedInfoEventJob extends QuartzJobBean {

	private static final Logger logger = LoggerFactory.getLogger(TimedInfoEventJob.class);
	private final TimedInfoService service;

	@Autowired
	public TimedInfoEventJob(TimedInfoService service) {
		logger.info("Creating new job instance.");
		this.service = service;
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("Executing internal job.");
		service.createInfo("Creating service through job.");
	}

}
