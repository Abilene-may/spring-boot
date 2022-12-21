package vn.mcredit.springbootfirstproject.ex2;

public interface GirlRepository {
    /*
    Tìm kiếm một cô gái trong Database theo tên
    @param name
    @return
     */

    Girl getGirlByName(String name);
}
