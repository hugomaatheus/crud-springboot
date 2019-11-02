package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.domain.Research;
import com.app.repository.ResearchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResearchService implements CrudInterface<Research> {

    @Autowired
    private ResearchRepository researchRepository;

    @Override
	public List<Research> findAll() {
		return researchRepository.findAll();
	}

	@Override
	public Optional<Research> save(Research entity) {
		return Optional.ofNullable(researchRepository.save(entity));
	}

	@Override
	public Optional<Research> findById(long id) {
		return researchRepository.findById(id);
	}

	@Override
	public void delete(Research entity) {
		researchRepository.delete(entity);

	}

    public List<Research> findByT(String teacher) {

		return researchRepository.
				findResearchByTeacher(teacher);
		
    }
    
    public List<Research> findByS(String subject) {

		return researchRepository.
				findResearchBySubject(subject);
		
	}

	public List<Research> findByTS(String teacher, String subject) {

		return researchRepository.
				findResearchByTeacherAndSubject(teacher, subject);
		
	}
}