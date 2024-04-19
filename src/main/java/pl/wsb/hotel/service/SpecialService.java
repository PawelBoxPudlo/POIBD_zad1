package pl.wsb.hotel.service;

public abstract class SpecialService {
    private String name;

    public SpecialService() {
    }

    public SpecialService(String name) {
        this.name = name;
    }

    public abstract void orderService();

    /*
        Trzeba dodać dwie metody abstrakcyjne by wykonać zadanie z gwiazdką
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
