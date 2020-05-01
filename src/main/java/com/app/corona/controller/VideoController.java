package com.app.corona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.corona.domain.Video;
import com.app.corona.service.SequenceGeneratorService;
import com.app.corona.service.VideoService;

@RestController
@RequestMapping("/videos")
public class VideoController {

	@Autowired
	private VideoService videoService;
	
	@Autowired
	private SequenceGeneratorService sgs;

	@PostMapping("/addVideos")
	public String addVideo(@RequestBody Video video) {
		video.setId(sgs.generateSequence(Video.SEQUENCE_NAME));
		return videoService.addVideo(video);

	}

	@GetMapping("/getVideos")
	public List<Video> getVideos() {
		return videoService.getVideos();
	}
}
