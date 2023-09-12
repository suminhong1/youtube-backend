package com.kh.youtube.controller;

import com.kh.youtube.domain.VideoComment;
import com.kh.youtube.service.VideoCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/*")
public class VideoCommentController {

    @Autowired
    private VideoCommentService service;

    @GetMapping("/videoComment")
    public ResponseEntity<List<VideoComment>> showAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.showAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/videoComment/{id}")
    public ResponseEntity<VideoComment> show(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.show(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PostMapping("/videoComment")
    public ResponseEntity<VideoComment> create(@RequestBody VideoComment videoComment) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.create(videoComment));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/videoComment")
    public ResponseEntity<VideoComment> update(@RequestBody VideoComment videoComment){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.update(videoComment));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/videoComment/{id}")
    public ResponseEntity<VideoComment> delete(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
