package vn.mcredit.springbootfirstproject.ex1;

import org.springframework.stereotype.Component;

@Component("dress")
//@Qualifier("dress")
public class Dress implements Outfit {
    @Override
    public void wear() {
        System.out.println("Mặc váy");
    }
}
