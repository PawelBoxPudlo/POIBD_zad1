package pl.wsb.hotel.hotelClass;

import pl.wsb.hotel.hotelClass.Client;
import pl.wsb.hotel.hotelClass.Room;

import java.time.LocalDate;

public class RoomReservation {

    int idReservation;
    LocalDate date;
    boolean isConfirmed;
    Client client;
    Room room;

    public RoomReservation() {
    }

    public RoomReservation(int id,LocalDate date,Client client, Room room) {
        this.idReservation = id;
        this.date = date;
        this.isConfirmed = false;
        this.client = client;
        this.room = room;
    }

    public RoomReservation(int i, LocalDate date, boolean b, Client client, Room room) {
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

    public LocalDate getDate() {
        return date;
    }

    public Client getClient() {
        return client;
    }

    public Room getRoom() {
        return room;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }
}
