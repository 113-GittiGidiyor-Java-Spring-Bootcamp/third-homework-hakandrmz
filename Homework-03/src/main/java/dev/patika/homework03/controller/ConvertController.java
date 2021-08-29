package dev.patika.homework03.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.patika.homework03.entity.Balance;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class ConvertController {

    private final static String ENDPOINT = "http://localhost:8081/";

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/convertToUsd/{balance}")
    public ResponseEntity convertToUsd(@PathVariable double balance) throws JsonProcessingException {
        Balance convertedBalance = restTemplate.getForObject(ENDPOINT+"convertToUsd/"+balance,Balance.class);
        return new ResponseEntity<>(convertedBalance, HttpStatus.OK);
    }

    @GetMapping("/convertToTl/{balance}")
    public ResponseEntity convertToTl(@PathVariable double balance) throws JsonProcessingException {
        Balance convertedBalance = restTemplate.getForObject(ENDPOINT+"convertToTl/"+balance,Balance.class);
        return new ResponseEntity<>(convertedBalance, HttpStatus.OK);
    }



}
