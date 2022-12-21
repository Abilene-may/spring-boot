package vn.mcredit.springbootfirstproject.ex1;

import org.springframework.stereotype.Component;

@Component("naked")
//@Qualifier
public class Naked implements Outfit {
    @Override
    public void wear() {
        System.out.println("Không mặc gì ");
    }
}
