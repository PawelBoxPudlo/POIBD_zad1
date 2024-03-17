package pl.wsb.examples;

import pl.wsb.hotel.Client;

import java.time.LocalDate;
import java.time.Month;

public class Run {

    public static void main(String[] args){
        LocalDate date = LocalDate.of(1998,2,12);
        Client client = new Client("1","Adam","Kowalski",date);
        System.out.println(client.getAge());

    }
}
