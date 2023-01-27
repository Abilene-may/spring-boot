package com.example.quanlysieuthi;

import com.example.quanlysieuthi.service.producttype.ProductTypeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuanLySieuThiApplicationTests {

    @Autowired private ProductTypeService productTypeService;
    @Test
    void contextLoads() {
    }

    @Test
    void testGetList(){
        var a = productTypeService.getListManufacturerByNameProductType("Bột giặt");
        Assertions.assertNotNull(a);
    }

}
