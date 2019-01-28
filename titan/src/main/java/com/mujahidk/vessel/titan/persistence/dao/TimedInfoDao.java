package com.mujahidk.vessel.titan.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mujahidk.vessel.titan.persistence.entity.TimedInfo;

public interface TimedInfoDao extends JpaRepository<TimedInfo, String>  {

}
