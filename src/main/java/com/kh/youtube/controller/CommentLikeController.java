package com.kh.youtube.controller;

import com.kh.youtube.domain.CommentLike;
import com.kh.youtube.service.CommetLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/*")
public class CommentLikeController {

    @Autowired
    private CommetLikeService service;

    @GetMapping("/commentlike")
    public ResponseEntity<List<CommentLike>> showAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.showAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/commentlike/{id}")
    public ResponseEntity<CommentLike> show(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.show(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PostMapping("/commentlike")
    public ResponseEntity<CommentLike> create(@RequestBody CommentLike commentlike) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.create(commentlike));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/commentlike")
    public ResponseEntity<CommentLike> update(@RequestBody CommentLike commentlike){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.update(commentlike));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/commentlike/{id}")
    public ResponseEntity<CommentLike> delete(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
