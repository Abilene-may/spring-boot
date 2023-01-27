package com.example.quanlysieuthi.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductTypeRequest {
    private Long idProductType;
    private String nameProductType;
}
