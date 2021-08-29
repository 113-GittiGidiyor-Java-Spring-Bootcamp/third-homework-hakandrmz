package com.convert.demo.controller;

import com.convert.demo.entity.Balance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertController {

    @GetMapping("/convertToTl/{balance}")
    public ResponseEntity convertToTl(@PathVariable double balance){
        balance = balance*8.43;
        return new ResponseEntity(new Balance(balance),HttpStatus.OK);

    }

    @GetMapping("/convertToUsd/{balance}")
    public ResponseEntity convertToUsd(@PathVariable double balance){
        balance = balance/8.43;
        return new ResponseEntity(new Balance(balance),HttpStatus.OK);

    }

}
