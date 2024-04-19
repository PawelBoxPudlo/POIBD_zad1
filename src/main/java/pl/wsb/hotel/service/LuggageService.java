package pl.wsb.hotel.service;

public class LuggageService extends SpecialService {

    public LuggageService() {
    }

    @Override
    public void orderService() {
        System.out.println("The hotel stores the customer's luggage in a safe place");
    }
}
