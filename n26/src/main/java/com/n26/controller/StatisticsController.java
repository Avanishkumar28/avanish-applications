package com.n26.controller;


import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n26.pojo.Statistics;
import com.n26.service.StatisticsService;

@RestController
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/statistics")
    public ResponseEntity<Statistics> getTransactions() {
        return new ResponseEntity<>(statisticsService.getStatistics(), OK);
    }
}