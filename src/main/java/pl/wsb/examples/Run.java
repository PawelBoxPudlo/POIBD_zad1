package pl.wsb.examples;

import pl.wsb.hotel.Client;
import pl.wsb.hotel.Room;
import pl.wsb.hotel.RoomReservation;

import java.time.LocalDate;

public class Run {

    public static void main(String[] args){
        LocalDate dateClient = LocalDate.of(1998,2,12);
        Client client = new Client("1","Adam","Kowalski",dateClient);
        System.out.println(client.toString());

        client = new Client("1","Adam","Kowalski",dateClient,"male","Radom 7","Primary school");
        System.out.println(client.toString());
        System.out.println(client.getAge());
        System.out.println(client.getFullName());

        Room room = new Room("1",10,5,true);
        System.out.println(room.toString());

        room = new Room("1"
                ,10
                ,5
                ,true
                ,true
                , 5
                ,25);
        System.out.println(room.toString());

        LocalDate dateReservation = LocalDate.of(2024,3,21);
        RoomReservation roomReservation = new RoomReservation(dateReservation,client,room);
        System.out.println(roomReservation.toString());
        System.out.println(roomReservation.getIsConfirmed());
        roomReservation.confirmReservation();
        System.out.println(roomReservation.getIsConfirmed());



    }
}
