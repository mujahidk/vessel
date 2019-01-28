package com.mujahidk.vessel.titan.scheduler;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(SchedulerConfiguration.class);

	@Bean
	public JobDetail timedInfoEventJob() {
		logger.info("Creating TimedInfoEventJob job.");
		return JobBuilder.newJob(TimedInfoEventJob.class)
				.withIdentity("timedInfoEventJob")
				.storeDurably()
				.build();
	}

	@Bean
	public Trigger sampleJobTrigger() {
		logger.info("Creating TimedInfoEventJobTrigger trigger.");
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder
				.simpleSchedule()
				.withIntervalInSeconds(10)
				.repeatForever();

		return TriggerBuilder.newTrigger().forJob(timedInfoEventJob())
				.withIdentity("timedInfoEventJobTrigger").withSchedule(scheduleBuilder).build();
	}
}
