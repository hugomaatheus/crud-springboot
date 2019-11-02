package com.app.web.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.app.domain.Exam;
import com.app.service.ExamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExamResource {
	
	@Autowired
	private ExamService examService;

	@GetMapping("/avaliacao")
	public List<Exam> getExams() {
		return 	examService.findAll();	
	}
	
	@GetMapping("/avaliacao/{professor}/{disciplina}")
	public List<Exam> getExamTS(@PathVariable String teacher, 
			                          @PathVariable String subject) {
		return examService.findByTS(teacher, subject);
	}

	@GetMapping("/avaliacao/{professor}")
	public List<Exam> getExamT(@PathVariable String teacher) {
		return examService.findByT(teacher);
	}

	@GetMapping("/avaliacao/{disciplina}")
	public List<Exam> getExamS(@PathVariable String subject) {
		return examService.findByS(subject);
	}
	
	@GetMapping("/avaliacao/{id}")
	public ResponseEntity<Exam> getExamById(@PathVariable Long id , 
			      @RequestParam(name = "subject", 
			                    defaultValue = "java", 
			                    required = false) String subject){
		Optional<Exam> response = examService.findById(id);	

		if(response.isPresent()) {
			return ResponseEntity.of(response);
		}
		
		return ResponseEntity.notFound().build();	
	}
	
	
	@PostMapping("/avaliacao")
	public Exam save(@RequestBody @Valid 
			                    Exam exam){
		return 	examService.save(exam).get();	
	}

	@DeleteMapping("/avaliacao")
	public ResponseEntity<Exam> delete(@RequestBody @Valid 
			                    Exam exam){        
            
        examService.delete(exam);
        
        return ResponseEntity.ok().build();
	}
	
}




