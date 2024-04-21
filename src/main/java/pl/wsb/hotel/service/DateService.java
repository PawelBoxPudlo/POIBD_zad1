package pl.wsb.hotel.service;

import pl.wsb.hotel.other.Time;

public class DateService extends SpecialService{

    Time time;

    public DateService() {
        this.time = new Time();
    }

    @Override
    public void orderService() {
        System.out.println(this.time.getDateNow());
    }
}
