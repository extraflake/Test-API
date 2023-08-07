package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Region;
import com.example.demo.services.RegionService;

import com.example.demo.handler.Response;

@RestController
@RequestMapping("api")
public class RegionRestController {
    @Autowired
    private RegionService regionService;

    @GetMapping("region") // http://localhost:8088/api/region
    public ResponseEntity<Object> get() {
        return Response.generate(HttpStatus.OK, "data has been succesfully retrieved", regionService.Get());
    }

    @GetMapping("region/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id) {
        return Response.generate(HttpStatus.OK, "data has been succesfully retrieved", regionService.Get(id));
    }

    @PostMapping("region") // http://localhost:8088/api/region
    public ResponseEntity<Object> save(@RequestBody Region region) {
        regionService.Save(region);
        return Response.generate(HttpStatus.OK, "data has been saved");
    }

    @DeleteMapping("region/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) Integer id) {
        regionService.Delete(id);
        return Response.generate(HttpStatus.OK, "data has been deleted");
    }
}