package com.example.joblist.request;

import lombok.*;

@RequiredArgsConstructor
@Setter
@Getter

public class TodoRequest {
    private String id;
    private String title;
    private String description;
    private String location;
    private int min_salary;
    private int max_salary;
    private String email_to;
}
