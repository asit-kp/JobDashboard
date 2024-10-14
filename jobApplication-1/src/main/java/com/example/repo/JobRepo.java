package com.example.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.JobPost;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {
	
	/*
	 * List<JobPost> jobs = new ArrayList<>(Arrays.asList( new JobPost(1,
	 * "Java Developer", "Must have good experience in core Java and advanced Java",
	 * 2, List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")), new JobPost(2,
	 * "Frontend Developer",
	 * "Experience in building responsive web applications using React", 3,
	 * List.of("HTML", "CSS", "JavaScript", "React")) ));
	 * 
	 * public List<JobPost> getAllJobs(){ return jobs; }
	 * 
	 * public void addJob(JobPost job) { jobs.add(job); }
	 * 
	 * public JobPost getPost(int postId) { // TODO Auto-generated method stub for
	 * (JobPost jobPost : jobs) { if(jobPost.getPostId() == postId) return jobPost;
	 * } return null; }
	 * 
	 * public void updateJob(JobPost post) { // TODO Auto-generated method stub for
	 * (JobPost jobPost : jobs) { if(jobPost.getPostId() == post.getPostId()) {
	 * jobPost.setPostDesc(post.getPostDesc());
	 * jobPost.setPostProfile(post.getPostProfile());
	 * jobPost.setPostTechStack(post.getPostTechStack());
	 * jobPost.setReqExperience(post.getReqExperience()); } } }
	 * 
	 * public void deleteJob(int postId) { // TODO Auto-generated method stub for
	 * (JobPost jobPost : jobs) { if(jobPost.getPostId() == postId)
	 * jobs.remove(jobPost); } }
	 */

//	List<JobPost> findByPostProfileContainingOrPostDescContaining(String keyword,String keyword1);
	
	@Query("from JobPost s where postDesc like :keyword%")
	List<JobPost> findName(@Param("keyword") String keyword);
	
}
