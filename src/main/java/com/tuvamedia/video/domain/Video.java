/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuvamedia.video.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author kbuty
 */
@Entity
@Data
@NoArgsConstructor
public class Video {
    
    @Id
    String name;
    
    @Lob
    @Column(length = 100000)
    private byte[] data;

    public Video(String name, byte[] data) {
        this.name = name;
        this.data = data;
    }
    
    
    
}
