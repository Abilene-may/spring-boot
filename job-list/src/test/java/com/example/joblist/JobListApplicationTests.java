package com.example.joblist;

import com.example.joblist.entity.Job;
import com.example.joblist.request.TodoRequest;
import com.example.joblist.service.JobService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JobListApplicationTests {

    @Autowired
    private JobService jobService;

    @Test
    void contextLoads() {
    }

    @Test
    void testCompare(){
        List<Job> a = jobService.sapXepDS();
        Assertions.assertNotNull(a);
    }

}
