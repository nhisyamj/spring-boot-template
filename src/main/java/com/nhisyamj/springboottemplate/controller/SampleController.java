package com.nhisyamj.springboottemplate.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

    @GetMapping("/sample")
    public ResponseEntity get() {
        return ResponseEntity.ok().build();
    }
}
