package pl.wsb.hotel.mainClass;

import pl.wsb.hotel.hotelClass.Client;
import pl.wsb.hotel.hotelClass.Room;
import pl.wsb.hotel.hotelClass.RoomReservation;
import pl.wsb.hotel.service.SpecialService;

import java.util.*;

public class Hotel {

    private String name;
    private List<SpecialService> specialServices;
    private List<Client> clients;
    private List<Room> rooms;
    private List<RoomReservation> reservations;

    public Hotel() {
    }

    public Hotel(String name) {
        this.name = name;
        this.specialServices = new LinkedList<SpecialService>();
        this.clients = new LinkedList<Client>();
        this.rooms = new LinkedList<Room>();
        this.reservations = new LinkedList<RoomReservation>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SpecialService> getSpecialServices() {
        return specialServices;
    }

    public void setSpecialServices(List<SpecialService> specialServices) {
        this.specialServices = specialServices;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<RoomReservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<RoomReservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", specialServices=" + specialServices +
                ", clients=" + clients +
                ", rooms=" + rooms +
                ", reservations=" + reservations +
                '}';
    }
}
