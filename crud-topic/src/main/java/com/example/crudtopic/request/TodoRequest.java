package com.example.crudtopic.request;

import lombok.*;

@RequiredArgsConstructor
@Setter
@Getter
@ToString
public class TodoRequest {
    private String id;
    private String name;
    private String description;
}
