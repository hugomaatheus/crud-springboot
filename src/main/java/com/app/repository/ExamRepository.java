package com.app.repository;


import java.util.List;

import com.app.domain.Exam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
	
	public List<Exam> findExamByTeacher(String teacher);
	public List<Exam> findExamByTeacherAndSubject(String teacher, String subject);
	public List<Exam> findExamBySubject(String subject);
	
}
