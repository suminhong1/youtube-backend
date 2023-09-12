package com.kh.youtube.controller;

import com.kh.youtube.domain.VideoLike;
import com.kh.youtube.service.VideoLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/*")
public class VideoLikeController {

    @Autowired
    private VideoLikeService service;

    @GetMapping("/videoLike")
    public ResponseEntity<List<VideoLike>> showAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.showAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/videoLike/{id}")
    public ResponseEntity<VideoLike> show(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.show(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PostMapping("/videoLike")
    public ResponseEntity<VideoLike> create(@RequestBody VideoLike videoLike) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.create(videoLike));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/videoLike")
    public ResponseEntity<VideoLike> update(@RequestBody VideoLike videoLike){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.update(videoLike));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/videoLike/{id}")
    public ResponseEntity<VideoLike> delete(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
