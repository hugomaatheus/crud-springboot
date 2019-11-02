package com.app.repository;

import java.util.List;

import com.app.domain.Research;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearchRepository extends JpaRepository<Research, Long> {

    public List<Research> findResearchByTeacher(String teacher);
	public List<Research> findResearchByTeacherAndSubject(String teacher, String subject);
	public List<Research> findResearchBySubject(String subject);
}