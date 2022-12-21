package com.example.crudtopic.repository;

import com.example.crudtopic.entity.Topic;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Setter
@Getter
@Service
public class TopicRepository {
    private List<Topic> topics = new ArrayList<>(
            Arrays.asList(
                    new Topic("java", "Java FrameWork", "Java Description"),
                    new Topic("spring", "Spring FrameWork", "Spring Description"),
                    new Topic("_spring", "_Spring FrameWork", "_Spring Description")
            )
    );
}
