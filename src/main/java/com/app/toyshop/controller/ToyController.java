package com.app.toyshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.toyshop.entity.Toy;
import com.app.toyshop.service.ToyService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/toy")
@Slf4j
public class ToyController {

    @Autowired
    private ToyService toyService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createToy(@RequestBody Toy toy) {
        try {
            return ResponseEntity.ok().body(toyService.createToy(toy));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{toyId}/update-price")
    public ResponseEntity<?> updateToyPrice(@PathVariable("toyId") Long toyId, @RequestParam("price") Double price) {
        try {
            toyService.updatePrice(toyId, price);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{toyId}")
    public ResponseEntity<?> deleteToy(@PathVariable("toyId") Long toyId) {
        try {
            toyService.deleteToy(toyId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/{toyId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getToy(@PathVariable("toyId") Long toyId) {
        try {
            return ResponseEntity.ok().body(toyService.getToy(toyId));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllToys() {
        try {
            return ResponseEntity.ok().body(toyService.getAllToys());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
