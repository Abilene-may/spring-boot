package com.example.crudtopic.service;

import com.example.crudtopic.entity.Topic;
import com.example.crudtopic.repository.TopicRepository;
import com.example.crudtopic.request.TodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
    public Topic createTopic(TodoRequest todoRequest){
        Topic topic = new Topic();
        topic.setId(todoRequest.getId());
        topic.setName(todoRequest.getName());
        topic.setDescription(todoRequest.getDescription());
        topicRepository.getTopics().add(topic);
        return topic;
    }

    public Topic updateTopic(TodoRequest todoRequest){
        try{
            Optional<Topic> topic = topicRepository.getTopics().stream().filter(topic1 ->
                                    topic1.getId().equals(todoRequest.getId())).findFirst();
            if(topic.isEmpty()){
                throw new RuntimeException("Không tìm thấy id");
            }
            Topic newTopic = topic.get();
            newTopic.setName(todoRequest.getName());
            newTopic.setDescription(todoRequest.getDescription());
            return newTopic;
        }catch(Exception e){
            throw new RuntimeException("Không tìm thấy id");
        }
    }
    public void deleteTopic(TodoRequest todoRequest){
        try{
            Optional<Topic> topic = topicRepository.getTopics().stream().filter(
                            o -> o.getId().equals(todoRequest.getId())).findFirst();
            if(topic.isEmpty()) throw new RuntimeException("Không tìm thấy dữ liệu");
            topicRepository.getTopics().remove(topic.get());
        }catch (Exception e){
            throw new RuntimeException("Không tìm thấy id để xóa");
        }
    }


}
