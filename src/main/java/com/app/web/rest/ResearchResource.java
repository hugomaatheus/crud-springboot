package com.app.web.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.app.domain.Research;
import com.app.service.ResearchService;

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
public class ResearchResource {

    @Autowired
    private ResearchService researchService;

    @GetMapping("/pesquisa")
	public List<Research> getResearches() {
		return 	researchService.findAll();	
	}
	
	@GetMapping("/pesquisa/{professor}/{disciplina}")
	public List<Research> getResearcheTS(@PathVariable String teacher, 
			                          @PathVariable String subject) {
		return researchService.findByTS(teacher, subject);
    }
    
    @GetMapping("/pesquisa/{professor}")
	public List<Research> getResearcheT(@PathVariable String teacher) {
		return researchService.findByT(teacher);
    }
    
    @GetMapping("/pesquisa/{disciplina}")
	public List<Research> getResearcheS(@PathVariable String subject) {
		return researchService.findByS(subject);
	}
	
	@GetMapping("/pesquisa/{id}")
	public ResponseEntity<Research> getResearchById(@PathVariable Long id , 
			      @RequestParam(name = "subject", 
			                    defaultValue = "java", 
			                    required = false) String subject){
		Optional<Research> response = researchService.findById(id);	

		if(response.isPresent()) {
			return ResponseEntity.of(response);
		}
		
		return ResponseEntity.notFound().build();	
	}
		
	@PostMapping("/pesquisa")
	public Research save(@RequestBody @Valid 
			                    Research research){
		return 	researchService.save(research).get();	
    }
    
    @DeleteMapping("/pesquisa")
	public ResponseEntity<Research> delete(@RequestBody @Valid 
			                    Research research){        
            
        researchService.delete(research);
        
        return ResponseEntity.ok().build();
	}
}