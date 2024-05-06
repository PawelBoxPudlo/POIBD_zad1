package pl.wsb.examples;

import pl.wsb.hotel.hotelClass.Client;
import pl.wsb.hotel.hotelClass.Room;
import pl.wsb.hotel.hotelClass.RoomReservation;
import pl.wsb.hotel.mainClass.Hotel;
import pl.wsb.hotel.service.*;

import java.time.LocalDate;

public class Run {

    public static void main(String[] args){
        LocalDate dateClient = LocalDate.of(1998,2,12);
        Client client = new Client("1","Adam","Kowalski",dateClient);
        //System.out.println(client.toString());

        client = new Client("1","Adam","Kowalski",dateClient,"male","Radom 7","Primary school");
        /*Wyłączone z użytku na potrzeby sprawdzenia zadania nr 2
        System.out.println(client.toString());
        System.out.println(client.getAge());
        System.out.println(client.getFullName());
        */

        Room room = new Room("1",10,5,true);
        //System.out.println(room.toString());

        room = new Room("1"
                ,10
                ,5
                ,true
                ,true
                , "-"
                ,25);
        //System.out.println(room.toString());

        LocalDate dateReservation = LocalDate.of(2024,3,21);
        RoomReservation roomReservation = new RoomReservation(1,dateReservation,client,room);
        /* Wyłączone z użytku na potrzeby sprawdzenia zadania nr 2
        System.out.println(roomReservation.toString());
        System.out.println(roomReservation.getIsConfirmed());
        roomReservation.confirmReservation();
        System.out.println(roomReservation.getIsConfirmed());
        */

        Hotel hotelHilton = new Hotel("Hilton");
        System.out.println(hotelHilton.toString());

        LuggageService luggageService = new LuggageService();
        TimeService timeService = new TimeService();
        DateService dateService = new DateService();
        InfoHotel infoHotel = new InfoHotel();

        luggageService.orderService();
        timeService.orderService();
        dateService.orderService();
        infoHotel.orderService();



    }
}
