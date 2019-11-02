package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.domain.Teacher;
import com.app.repository.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService implements CrudInterface<Teacher> {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Override
	public List<Teacher> findAll() {
		return teacherRepository.findAll();
	}

	@Override
	public Optional<Teacher> save(Teacher entity) {
		
		return Optional.ofNullable(teacherRepository.save(entity));
	}

	@Override
	public Optional<Teacher> findById(long id) {
			return teacherRepository.findById(id);
	}

	@Override
	public void delete(Teacher entity) {
			teacherRepository.delete(entity);
	}
 
}
