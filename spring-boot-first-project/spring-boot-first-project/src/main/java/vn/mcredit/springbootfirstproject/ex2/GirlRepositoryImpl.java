package vn.mcredit.springbootfirstproject.ex2;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public class GirlRepositoryImpl implements GirlRepository{
    @Override
    public Girl getGirlByName(String name) {
        return new Girl(name);
    }
}
