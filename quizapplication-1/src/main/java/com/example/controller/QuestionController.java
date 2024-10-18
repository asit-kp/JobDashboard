package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Question;
import com.example.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService quizService;
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return new ResponseEntity(quizService.getAllQuestions(),HttpStatus.OK);
	}
	
	@GetMapping("allQuestions/category/{keyword}")
	public List<Question> searchCategory(@PathVariable String keyword) {
		return quizService.searchCatgeory(keyword);
	}
	
	@PostMapping("addQuestion")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		quizService.addQuestion(question);
		return new ResponseEntity("Success",HttpStatus.CREATED);
	}
	
	@PutMapping("updateQuestion")
	public String updateQuestion(@RequestBody Question question) {
		quizService.updateQuestion(question);
		return "Success";
	}
	
	@DeleteMapping("deleteQuestion/{id}")
	public String deleteQuestion(@PathVariable Integer id) {
		quizService.deleteQuestion(id);
		return "Success";
	}

}
