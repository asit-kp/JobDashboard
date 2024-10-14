package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.example.model.JobPost;
import com.example.model.User;
import com.example.service.JobService;
import com.example.service.UserService;

//@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {
	
	@Autowired
	JobService serv;
	
	@Autowired
	UserService userv;
	
	/*
	 * @GetMapping({"/","home"}) public String home() { return "home"; }
	 * 
	 * @GetMapping({"addjob"}) public String addJob() { return "addjob"; }
	 * 
	 * @PostMapping("handleForm") public String handleForm(JobPost jobPost) {
	 * serv.addJob(jobPost); return "success"; }
	 * 
	 * @GetMapping("viewalljobs") public String viewjobs(Model m) { List<JobPost>
	 * jobs = serv.getAllJobs(); m.addAttribute("jobPosts", jobs); return
	 * "viewalljobs"; }
	 */
	
	@GetMapping("jobPosts")
	//@ResponseBody
	public List<JobPost> getAllJobs(){
		return serv.getAllJobs();
	}
	
	@GetMapping("jobPost/{PostId}")
	public JobPost getPost(@PathVariable("PostId") int PostId) {
		return serv.getPost(PostId);
	}
	
	@PostMapping("jobPost")
	public JobPost addJob(@RequestBody JobPost jobPost) {
		serv.addJob(jobPost);
		return serv.getPost(jobPost.getPostId());
	}
	
	@PutMapping("jobPost")
	public JobPost updateJob(@RequestBody JobPost jobPost) {
		serv.updateJob(jobPost);
		return serv.getPost(jobPost.getPostId());
	}

	@DeleteMapping("jobPost/{PostId}")
	public String deleteJob(@PathVariable int PostId) {
		serv.deleteJob(PostId);
		return "Deleted";
	}
	
	@GetMapping("jobPosts/keyword/{keyword}")
	public List<JobPost> getJob(@PathVariable String keyword){
		return serv.getJob(keyword);
	}
	
	@PostMapping("register")
	public User register(@RequestBody User user) {
	  return userv.saveUser(user);
	}
}
