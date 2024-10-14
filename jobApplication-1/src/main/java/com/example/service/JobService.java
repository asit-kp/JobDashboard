package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.JobPost;
import com.example.repo.JobRepo;


@Service
public class JobService {

	@Autowired
	JobRepo repo;
	
	/*
	 * public void addJob(JobPost job) { repo.addJob(job); }
	 * 
	 * public List<JobPost> getAllJobs(){ return repo.getAllJobs(); }
	 * 
	 * public JobPost getPost(int postId) { // TODO Auto-generated method stub
	 * return repo.getPost(postId); }
	 * 
	 * public void updateJob(JobPost jobPost) { repo.updateJob(jobPost);
	 * 
	 * }
	 * 
	 * public void deleteJob(int postId) { // TODO Auto-generated method stub
	 * repo.deleteJob(postId); }
	 */

	public void addJob(JobPost job) {
		repo.save(job);
	}
	
	public List<JobPost> getAllJobs(){
		return repo.findAll();
	}
	
	public JobPost getPost(int postId) {
		return repo.findById(postId).orElse(new JobPost());
	}
	
	public void updateJob(JobPost jobPost) {
		repo.save(jobPost);
	}
	
	public void deleteJob(int postId) {
		repo.deleteById(postId);
	}

	public List<JobPost> getJob(String keyword) {
		// TODO Auto-generated method stub
		//return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
		return repo.findName(keyword);
	}
	
	
}
