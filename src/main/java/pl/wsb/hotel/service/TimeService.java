package pl.wsb.hotel.service;

import pl.wsb.hotel.other.Time;

public class TimeService extends SpecialService {

    private Time time;

    public TimeService() {
        this.time = new Time();
    }

    @Override
    public void orderService() {
        System.out.println(time.getNowTime());
    }
}
