package com.app.web.rest;

import java.util.List;

import javax.validation.Valid;

import com.app.domain.Teacher;
import com.app.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TeacherResource {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/professor")
    public List<Teacher> getUsers() {
        return teacherService.findAll();
    }

    @PostMapping("/professor")
    public ResponseEntity<Teacher>
    save(@Valid @RequestBody Teacher teacher) {
        teacherService.save(teacher);
        return ResponseEntity.ok(teacher);
    }


    @PutMapping("/professor")
    public ResponseEntity update(@Valid @RequestBody Teacher teacher) {
        teacherService.save(teacher);
        return ResponseEntity.ok().body(teacher);
    }


    @DeleteMapping("/professor")
    public ResponseEntity<String> delete(@Valid @RequestBody Teacher teacher) {
        teacherService.delete(teacher);
       return  ResponseEntity.ok().body("Professor deletado ID: " + teacher.getId());
    }   

}
