package pl.wsb.hotel.hotelClass;

import pl.wsb.hotel.hotelClass.Client;

public class PremiumClient extends Client {

    enum premiumAccountType {
        PREMIUM,
        PREMIUM_PLUS
    }

    public String getFullName(){
        return "[premium] " + this.firstName + " " + this.lastName;
    }
}
