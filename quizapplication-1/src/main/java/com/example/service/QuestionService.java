package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.QuestionDao;
import com.example.model.Question;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questiondao;
	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		return questiondao.findAll();
	}
	public List<Question> searchCatgeory(String keyword) {
		// TODO Auto-generated method stub
		return questiondao.findByCategory(keyword);
	}
	public void addQuestion(Question question) {
		// TODO Auto-generated method stub
		questiondao.save(question);
		
	}
	public void updateQuestion(Question question) {
		// TODO Auto-generated method stub
		
		questiondao.save(question);
	}
	public void deleteQuestion(int id) {
		// TODO Auto-generated method stub
		questiondao.deleteById(id);
	}

}
