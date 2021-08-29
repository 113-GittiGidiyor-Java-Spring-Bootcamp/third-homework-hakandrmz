package dev.patika.homework02.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.patika.homework02.entity.Balance;
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

    private final static String ENDPOINT = "http://localhost:8081/convert/";

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/convert/{balance}")
    public ResponseEntity getConvertedBalance(@PathVariable double balance) throws JsonProcessingException {
        Balance convertedBalance = restTemplate.getForObject(ENDPOINT+balance,Balance.class);
        return new ResponseEntity<>(convertedBalance, HttpStatus.OK);
    }

}
