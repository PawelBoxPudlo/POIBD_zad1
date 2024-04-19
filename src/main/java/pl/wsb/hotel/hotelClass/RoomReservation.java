package pl.wsb.hotel.hotelClass;

import pl.wsb.hotel.hotelClass.Client;
import pl.wsb.hotel.hotelClass.Room;

import java.time.LocalDate;

public class RoomReservation {

    LocalDate date;
    boolean isConfirmed;
    Client client;
    Room room;

    public RoomReservation() {
    }

    public RoomReservation(LocalDate date,Client client, Room room) {
        this.date = date;
        this.isConfirmed = false;
        this.client = client;
        this.room = room;
    }

    public void confirmReservation(){
        this.isConfirmed = true;
    }

    @Override
    public String toString() {
        return "RoomReservation{" +
                "date=" + date +
                ", isConfirmed=" + isConfirmed +
                ", client=" + client +
                ", room=" + room +
                '}';
    }

    public boolean getIsConfirmed() {
        return isConfirmed;
    }
}
