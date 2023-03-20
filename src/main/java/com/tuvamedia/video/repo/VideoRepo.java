/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tuvamedia.video.repo;

import com.tuvamedia.video.domain.Video;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author kbuty
 */
public interface VideoRepo extends JpaRepository<Video, String>{
    
    @Query(nativeQuery = true, value="SELECT name FROM video")
    List<String> findAllNames();
    
    
}
