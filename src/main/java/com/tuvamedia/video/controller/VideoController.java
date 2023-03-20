/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuvamedia.video.controller;

import com.tuvamedia.video.domain.Video;
import com.tuvamedia.video.repo.VideoRepo;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kbuty
 */
@RestController
public class VideoController {
    
    @Autowired
    VideoRepo videoRepo;
    
    @GetMapping("video/all")
    public List<String> getAllNames(){
        return videoRepo.findAllNames();
    }
    
    @GetMapping("video/{name}")
    public Resource getName(@RequestParam("name") String name){
        return new ByteArrayResource(videoRepo.findById(name).get().getData());
    }
    
    @PostMapping()
    public ResponseEntity<String> saveVideo(@RequestParam("file") MultipartFile file, @RequestParam("name") String name) throws IOException {
        Video v = new Video(name, file.getBytes());
        videoRepo.save(v);
        return ResponseEntity.ok("Video saved successfully.");

    }
    
}
