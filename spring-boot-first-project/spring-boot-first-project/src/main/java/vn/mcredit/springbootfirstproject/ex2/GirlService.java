package vn.mcredit.springbootfirstproject.ex2;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;
    public Girl getRandomGirl(){
        String name = randomGirlName(10);
        return girlRepository.getGirlByName(name);
    }

    public String randomGirlName(int length){
        //Tạo 1 chuỗi ngẫu nhiên có độ dài = length
        //Sử dụng thư viện Apche Common Lang
        return RandomStringUtils.randomAlphabetic(length).toLowerCase();
    }
}
