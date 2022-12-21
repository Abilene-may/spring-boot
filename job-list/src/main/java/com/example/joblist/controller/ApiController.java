package com.example.joblist.controller;

import com.example.joblist.service.JobService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job")
public class ApiController {
//    @Autowired
//    private JobRepository jobRepository;
    @Autowired
    private JobService jobService;

    @GetMapping("/sortbylocation")
    public ResponseEntity<Object> getListJob(){
        return new ResponseEntity<>(jobService.sapXepDS(), HttpStatus.OK);
    }

    @GetMapping("/salary/{salary}")
    public ResponseEntity<Object> getListSalary(@PathVariable("salary") int salary){
        return new ResponseEntity<>(jobService.timJobTheoSalary(salary), HttpStatus.OK);
    }
    @GetMapping("/keyword/{keyword}")
    public ResponseEntity<Object> getListContainKeyword(@PathVariable("keyword") String keyword){
        return new ResponseEntity<>(jobService.timKeyword(keyword), HttpStatus.OK);
    }

    @GetMapping("/query")
    public ResponseEntity<Object> getByKeywordAndLocation(@RequestParam("keyWord") String keyWords, @RequestParam("location") String location ){
        return new ResponseEntity<>(jobService.timKeywordVaLocation(keyWords, location), HttpStatus.OK);
    }


}
