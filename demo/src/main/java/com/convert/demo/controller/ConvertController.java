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

    @GetMapping("/convert/{balance}")
    public ResponseEntity getConvertedBalance(@PathVariable double balance){
        balance = balance*8.43;
        System.out.println(balance);
        return new ResponseEntity(new Balance(balance),HttpStatus.OK);

    }

}
