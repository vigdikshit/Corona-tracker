package com.app.corona.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.corona.domain.Video;
import com.app.corona.repository.VideoRepository;

@Service
public class VideoService {

	@Autowired
	private VideoRepository videoRepo;
	
	public String addVideo(Video video) {
		videoRepo.save(video);
		return "Video saved";
	}

	public List<Video> getVideos() {
		List<Video> video = videoRepo.findAll();
		return videoRepo.findAll();
	}

}
