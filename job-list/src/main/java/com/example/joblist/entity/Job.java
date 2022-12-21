package com.example.joblist.entity;

import com.example.joblist.constant.Location;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Job {
    private String id;
    private String title;
    private String description;
    private String location;
    private int min_salary;
    private int max_salary;
    private String email_to;

}
