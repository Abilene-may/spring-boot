package com.example.crudtopic.controller;

import com.example.crudtopic.entity.Topic;
import com.example.crudtopic.repository.TopicRepository;
import com.example.crudtopic.request.TodoRequest;
import com.example.crudtopic.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    private TopicRepository topicRepository;
    private TopicService topicService;

    @GetMapping("/get-topics")
    public ResponseEntity<Object> getTopic(@RequestBody Topic topic ){
        List<Topic> topicList = topicRepository.getTopics();
        return new ResponseEntity<>(topicRepository.getTopics(), HttpStatus.OK);
    }

    @GetMapping ("/get-topics/{id}")
    public ResponseEntity<Object> getTopic(@PathVariable("id") String id){
        return new ResponseEntity<>(topicRepository.getTopics().stream().filter(
                topic -> topic.getId().equals(id)).collect(Collectors.toList()), HttpStatus.OK);

    }

    @PostMapping(value = "/post-topics",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> postTopic(@RequestBody TodoRequest todoRequest){

        return new ResponseEntity<>(topicService.createTopic(todoRequest), HttpStatus.OK) ;
    }

    @PutMapping(value = "/put-topics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateTopicByid(@RequestBody TodoRequest todoRequest){
        return new ResponseEntity<>(topicService.updateTopic(todoRequest), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-topics", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Object> deleteTopic(@RequestBody TodoRequest todoRequest){
        return ResponseEntity.status(HttpStatus.OK).body("Xóa thành công");
    }



}
