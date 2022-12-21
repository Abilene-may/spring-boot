package com.example.joblist.service;

import com.example.joblist.entity.Job;
import com.example.joblist.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public List<Job> sapXepDS() {
        return jobRepository.getJobList().stream().sorted((o1, o2) ->
                o1.getLocation().compareTo(o2.getLocation())).collect(Collectors.toList());

    }

    public List<Job> timJobTheoSalary(int salary) {
        return jobRepository.getJobList().stream().filter(job ->
                (salary > job.getMin_salary() && salary < job.getMax_salary())).collect(Collectors.toList());
    }

    public List<Job> timKeyword(String keyword) {
        try {
            List<Job> listContainKeyword = jobRepository.getJobList().stream().filter(job ->
                    (job.getTitle().contains(keyword) || job.getDescription().contains(keyword))).collect(Collectors.toList());
            if (listContainKeyword.isEmpty()) {
                throw new RuntimeException("Không tìm thấy thông tin");
            }
            return listContainKeyword;
        } catch (Exception e) {
            throw new RuntimeException("");
        }
    }

    public List<Job> timKeywordVaLocation(String keyword, String location) {
        return jobRepository.getJobList().stream().filter(job ->
                        (job.getLocation().equals(location) && (job.getTitle().contains(keyword) || job.getDescription().contains(keyword))))
                .collect(Collectors.toList());
    }

}
