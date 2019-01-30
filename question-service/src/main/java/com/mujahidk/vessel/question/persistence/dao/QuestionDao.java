package com.mujahidk.vessel.question.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mujahidk.vessel.question.persistence.entity.Question;

@Repository
interface QuestionDao extends JpaRepository<Question, String> {

}
