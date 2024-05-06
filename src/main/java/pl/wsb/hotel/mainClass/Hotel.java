package pl.wsb.hotel.mainClass;

import com.ibm.icu.impl.coll.Collation;
import pl.wsb.hotel.exceptions.ClientNotFoundException;
import pl.wsb.hotel.exceptions.ReservationNotFoundException;
import pl.wsb.hotel.exceptions.RoomNotFoundException;
import pl.wsb.hotel.exceptions.RoomReservedException;
import pl.wsb.hotel.hotelClass.Client;
import pl.wsb.hotel.hotelClass.Room;
import pl.wsb.hotel.hotelClass.RoomReservation;
import pl.wsb.hotel.interfaces.HotelCapability;
import pl.wsb.hotel.service.SpecialService;

import java.time.LocalDate;
import java.util.*;

public class Hotel implements HotelCapability {

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

    @Override
    public String addClient(String firstName, String lastName, LocalDate birthDate) {

        int id = this.clients.size() + 1;

        String clientId = String.valueOf(id);

        try{
            this.clients.add(new Client(
                    clientId,
                    firstName,
                    lastName,
                    birthDate
            ));

            return clientId;

        }catch (Exception e){
            return e.getMessage();
        }

    }

    @Override
    public String getClientFullName(String clientId) {

        try{
            int searchId = Integer.parseInt(clientId);

            for (Client x : this.clients) {
                if(searchId == Integer.parseInt(x.getId())){
                    return x.getFullName();
                }else{
                    return "Don't find user. Check id param";
                }
            }

        }catch (Exception e){
            return "Don't find user \n" + e.getMessage();
        }

        return "Don't find user. Check id param";

    }

    @Override
    public int getNumberOfUnderageClients() {

        int valueUnderAgeClients = 0;

        for (Client x : this.clients) {
            if(x.getAge() < 18){
                valueUnderAgeClients++;
            }
        }

        return valueUnderAgeClients;
    }

    @Override
    public String addRoom(double area, int floor, boolean hasKingSizeBed, String description) {
        int id = this.rooms.size() + 1;

        String roomId = String.valueOf(id);

        try{
            this.rooms.add(new Room(
                    roomId,
                    area,
                    floor,
                    hasKingSizeBed,
                    description
            ));

            return roomId;

        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public double getRoomArea(String roomId) {
        try{
            int searchId = Integer.parseInt(roomId);

            for (Room x : this.rooms) {
                if(searchId == Integer.parseInt(x.getId())){
                    return x.getArea();
                }else{
                    return 0;
                }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return 0;
    }

    @Override
    public int getNumberOfRoomsWithKingSizeBed(int floor) {

        int roomsWithBigBed = 0;

        try{
            for (Room x : this.rooms) {
                if(x.getFloor() == floor){
                    if(x.isHasKingSizeBed()){
                        roomsWithBigBed++;
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return roomsWithBigBed;
    }

    @Override
    public String addNewReservation(String clientId, String roomId, LocalDate date) throws ClientNotFoundException, RoomNotFoundException, RoomReservedException {



            boolean checkExistElementClientId = false;
            boolean checkExistElementRoomId = false;
            Client client = null;
            Room room = null;


            int searchClientId = Integer.parseInt(clientId);

            for (Client x : this.clients) {
                if(searchClientId == Integer.parseInt(x.getId())){
                    checkExistElementClientId = true;
                    client = x;
                }
            }

            if(!checkExistElementClientId)
                throw new ClientNotFoundException("Not find client with search ID");

            int searchRoomId = Integer.parseInt(roomId);

            for (Room x : this.rooms) {
                if(searchRoomId == Integer.parseInt(x.getId())){
                    checkExistElementRoomId = true;
                    room = x;
                }
            }

            if(!checkExistElementRoomId)
                throw new RoomNotFoundException("Not find room with search ID");

            for(RoomReservation x: this.reservations){
                if (date == x.getDate()) {
                    throw new
                            RoomReservedException(roomId,date);

                }
            }

            try{
                this.reservations.add(new RoomReservation(
                        this.reservations.size()+1,
                        date,
                        client,
                        room));
            }catch (Exception e){
                return e.getMessage();
            }

            return "Reservation is complete";
    }

    @Override
    public String confirmReservation(String reservationId) throws ReservationNotFoundException {

        boolean checkReservation = false;
        int id = Integer.parseInt(reservationId);

        for(RoomReservation x:reservations){
            if (x.getIdReservation() == id) {
                checkReservation = true;
                break;
            }
        }

        if(!checkReservation)
            throw new ReservationNotFoundException("Reservation not find");

        return "Reservation is confirm";
    }

    @Override
    public boolean isRoomReserved(String roomId, LocalDate date) throws RoomNotFoundException {
        boolean checkExistElementRoomId = false;

        int searchRoomId = Integer.parseInt(roomId);

        for (Room x : this.rooms) {
            if(searchRoomId == Integer.parseInt(x.getId())){
                checkExistElementRoomId = true;
            }
        }

        if(!checkExistElementRoomId)
            throw new RoomNotFoundException("Not find room with search ID");

        for(RoomReservation x:reservations){
            if(x.getDate() == date) return true;
        }

        return false;
    }

    @Override
    public int getNumberOfUnconfirmedReservation(LocalDate date) {
        int valueNotConfirmed = 0;

        for(RoomReservation x:reservations){
            if(x.getDate() == date){
                if(!x.isConfirmed()){
                    valueNotConfirmed++;
                }
            }
        }

        return valueNotConfirmed;
    }

    @Override
    public Collection<String> getRoomIdsReservedByClient(String clientId) throws ClientNotFoundException {
        List<String> listIdRoom = new LinkedList<String>();

        for(RoomReservation x:reservations){
            if(x.getClient().getId().equals(clientId)){
                listIdRoom.add(x.getRoom().getId());
            }
        }

        return listIdRoom;

    }
}
