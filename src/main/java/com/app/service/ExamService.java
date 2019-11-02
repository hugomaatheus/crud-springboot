package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.domain.Exam;
import com.app.repository.ExamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamService implements CrudInterface<Exam> {

	@Autowired
	private ExamRepository examRepository;

	@Override
	public List<Exam> findAll() {
		return examRepository.findAll();
	}

	@Override
	public Optional<Exam> save(Exam entity) {
		return Optional.ofNullable(examRepository.save(entity));
	}

	@Override
	public Optional<Exam> findById(long id) {
		return examRepository.findById(id);
	}

	@Override
	public void delete(Exam entity) {
		examRepository.delete(entity);

	}

	public List<Exam> findByT(String teacher) {

		return examRepository.
				findExamByTeacher(teacher);
		
    }
    
    public List<Exam> findByS(String subject) {

		return examRepository.
				findExamBySubject(subject);
		
	}

	public List<Exam> findByTS(String teacher, String subject) {

		return examRepository.
				findExamByTeacherAndSubject(teacher, subject);
		
	}

}
