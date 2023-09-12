package com.kh.youtube.controller;

import com.kh.youtube.domain.Subscribe;
import com.kh.youtube.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/*")
public class SubscribeController {

    @Autowired
    private SubscribeService service;

    @GetMapping("/subscribe")
    public ResponseEntity<List<Subscribe>> showAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.showAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/subscribe/{id}")
    public ResponseEntity<Subscribe> show(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.show(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PostMapping("/subscribe")
    public ResponseEntity<Subscribe> create(@RequestBody Subscribe subscribe) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.create(subscribe));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/subscribe")
    public ResponseEntity<Subscribe> update(@RequestBody Subscribe subscribe){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.update(subscribe));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/subscribe/{id}")
    public ResponseEntity<Subscribe> delete(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
