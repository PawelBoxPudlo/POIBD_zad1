package pl.wsb.hotel.hotelClass;

import java.time.LocalDate;
import java.time.Period;

public class Client {

    String id;
    String firstName;
    String lastName;
    LocalDate birthDate;
    String sex;
    String address;
    String education;

    public Client() {
    }

    public Client(String id, LocalDate birthDate){
        this.id = id;
        this.birthDate = birthDate;
    }

    public Client(String id, String firstName, String lastName, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Client(String id, String firstName, String lastName, LocalDate birthDate, String sex, String address, String education) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.sex = sex;
        this.address = address;
        this.education = education;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public int getAge(){
        return calculateAge();
    }

    private int calculateAge(){
        if(this.birthDate == null) return 0;
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(this.birthDate,currentDate);
        return period.getYears();
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", education='" + education + '\'' +
                '}';
    }
}

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

package pl.wsb.hotel.hotelClass;

public class Room {

    String id;
    double area;
    int floor;
    boolean hasKingSizeBed;
    boolean balcony;
    int rating;
    int sizeRoom;

    public Room() {
    }

    public Room(String id, double area, int floor, boolean hasKingSizeBed) {
        this.id = id;
        this.area = area;
        this.floor = floor;
        this.hasKingSizeBed = hasKingSizeBed;
    }

    public Room(String id, double area, int floor, boolean hasKingSizeBed, boolean balcony, int rating, int sizeRoom) {
        this.id = id;
        this.area = area;
        this.floor = floor;
        this.hasKingSizeBed = hasKingSizeBed;
        this.balcony = balcony;
        this.rating = rating;
        this.sizeRoom = sizeRoom;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", area=" + area +
                ", floor=" + floor +
                ", hasKingSizeBed=" + hasKingSizeBed +
                ", balcony=" + balcony +
                ", rating=" + rating +
                ", sizeRoom=" + sizeRoom +
                '}';
    }
}

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

package pl.wsb.hotel.mainClass;

import pl.wsb.hotel.hotelClass.Client;
import pl.wsb.hotel.hotelClass.Room;
import pl.wsb.hotel.hotelClass.RoomReservation;
import pl.wsb.hotel.service.SpecialService;

import java.util.*;

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


package pl.wsb.hotel.other;

import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.TimeZone;

import java.util.Date;


public class Time {

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;
    private int millis;

    public Time() {
        Calendar calendar = Calendar.getInstance();
        Date later = new Date();
        calendar.setTime(later);
        calendar.setTimeZone(TimeZone.getTimeZone("Europe/Warsaw"));

        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH);
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
        this.hour = calendar.get(Calendar.HOUR);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
        this.millis = calendar.get(Calendar.MILLISECOND);
    }

    public String getNowTime(){
        return this.hour + ":" + this.minute + ":" + this.second;
    }


}

package pl.wsb.hotel.service;

public class LuggageService extends SpecialService {

    public LuggageService() {
    }

    @Override
    public void orderService() {
        System.out.println("The hotel stores the customer's luggage in a safe place");
    }
}

package pl.wsb.hotel.service;

public abstract class SpecialService {
    private String name;

    public SpecialService() {
    }

    public SpecialService(String name) {
        this.name = name;
    }

    public abstract void orderService();

    /*
        Trzeba dodać dwie metody abstrakcyjne by wykonać zadanie z gwiazdką
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

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

package pl.wsb.hotel.mainClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.wsb.hotel.hotelClass.Client;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @Test
    void addClient() {

        // given
        Hotel hotel = new Hotel("Cristal Park");
        LocalDate dateBirthClient = LocalDate.of(1998,2,12);
        String name = "Adam";
        String lastName = "Kowalski";


        // when
        String clientId = hotel.addClient(name,lastName,dateBirthClient);

        // then
        Assertions.assertEquals("1",clientId);



    }

    @Test
    void getClientFullName() {

        // given
        Hotel hotel = new Hotel("Cristal Park");
        LocalDate dateBirthClient = LocalDate.of(1998,2,12);
        String name = "Adam";
        String lastName = "Kowalski";


        // when
        hotel.addClient(name,lastName,dateBirthClient);
        String clientFullName = hotel.getClientFullName("1");
        String clientFullName2 = hotel.getClientFullName("3");

        // then
        Assertions.assertEquals("Adam Kowalski",clientFullName);
        Assertions.assertEquals("Don't find user. Check id param",clientFullName2);
        Assertions.assertNotEquals("Julia Żugaj",clientFullName);

    }

    @Test
    void getNumberOfUnderageClients() {

        // given
        Hotel hotel = new Hotel("Cristal Park");
        LocalDate dateBirthClient = LocalDate.of(2010,2,12);
        LocalDate dateBirthClient2 = LocalDate.of(2012,2,12);
        String name = "Adam";
        String lastName = "Kowalski";


        // when
        hotel.addClient(name,lastName,dateBirthClient);
        hotel.addClient(name,lastName,dateBirthClient2);
        int valueUnderAgeClients = hotel.getNumberOfUnderageClients();


        // then
        Assertions.assertEquals(2,valueUnderAgeClients);
        Assertions.assertNotEquals(5,valueUnderAgeClients);


    }

    @Test
    void addRoom() {

        // given
        Hotel hotel = new Hotel("Cristal Park");

        // when
        String idRoom = hotel.addRoom(2.0,2,true,"test");

        // then
        Assertions.assertEquals("1",idRoom);
        Assertions.assertNotEquals("7",idRoom);

    }

    @Test
    void getRoomArea() {

        // given
        Hotel hotel = new Hotel("Cristal Park");

        // when
        String idRoom = hotel.addRoom(2.0,2,true,"test");
        double area = hotel.getRoomArea("1");

        // then
        Assertions.assertEquals(2.0,area);
        Assertions.assertNotEquals(7.5,area);

    }

    @Test
    void getNumberOfRoomsWithKingSizeBed() {
        // given
        Hotel hotel = new Hotel("Cristal Park");

        // when
        String idRoom = hotel.addRoom(2.0,2,true,"test");
        int bigSizeBed = hotel.getNumberOfRoomsWithKingSizeBed(2);

        // then
        Assertions.assertEquals(1,bigSizeBed);
        Assertions.assertNotEquals(0,bigSizeBed);
    }

    @Test
    void addNewReservation() {

        try{
            // given
            Hotel hotel = new Hotel("Cristal Park");
            LocalDate dateReservation = LocalDate.of(2024,5,4);


            // when
            hotel.addClient("test","test",dateReservation);
            hotel.addRoom(5.0,2,true,"test");
            String reservation = hotel.addNewReservation("1","1",dateReservation);

            // then
            Assertions.assertEquals("Reservation is complete",reservation);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    void confirmReservation() {
        try{
            // given
            Hotel hotel = new Hotel("Cristal Park");
            LocalDate dateReservation = LocalDate.of(2024,5,4);


            // when
            hotel.addClient("test","test",dateReservation);
            hotel.addRoom(5.0,2,true,"test");
            hotel.addNewReservation("1","1",dateReservation);
            String reservation = hotel.confirmReservation("1");

            // then
            Assertions.assertEquals("Reservation is confirm",reservation);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    @Test
    void isRoomReserved() {
        try{
            // given
            Hotel hotel = new Hotel("Cristal Park");
            LocalDate dateReservation = LocalDate.of(2024,5,4);


            // when
            hotel.addClient("test","test",dateReservation);
            hotel.addRoom(5.0,2,true,"test");
            hotel.addNewReservation("1","1",dateReservation);
            boolean isReserved = hotel.isRoomReserved("1",dateReservation);
            boolean isReserved2 = hotel.isRoomReserved("2",dateReservation);

            // then
            Assertions.assertEquals(true,isReserved);
            Assertions.assertNotEquals(false,isReserved2);

        }catch (Exception e){
        }
    }

    @Test
    void getNumberOfUnconfirmedReservation() {

        try{
            // given
            Hotel hotel = new Hotel("Cristal Park");
            LocalDate dateReservation = LocalDate.of(2024,5,4);


            // when
            hotel.addClient("test","test",dateReservation);
            hotel.addRoom(5.0,2,true,"test");
            hotel.addNewReservation("1","1",dateReservation);
            hotel.confirmReservation("1");

            hotel.addClient("test2","test2",dateReservation);
            hotel.addRoom(7.0,3,true,"test2");
            hotel.addNewReservation("2","2",dateReservation);
            hotel.confirmReservation("2");

            // then
            Assertions.assertNotEquals(false,hotel.confirmReservation("2"));
            Assertions.assertEquals(true,hotel.confirmReservation("2"));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    void getRoomIdsReservedByClient() {

        try{
            // given
            Hotel hotel = new Hotel("Cristal Park");
            LocalDate dateReservation = LocalDate.of(2024,5,4);
            LocalDate dateReservation2 = LocalDate.of(2024,2,4);
            List<String> listIdRoom = new LinkedList<String>();


            // when
            hotel.addClient("test","test",dateReservation);
            hotel.addRoom(5.0,2,true,"test");
            hotel.addNewReservation("1","1",dateReservation);

            hotel.addRoom(7.0,3,true,"test2");

            hotel.addNewReservation("1","2",dateReservation2);
            listIdRoom.add("1");
            listIdRoom.add("2");

            // then
            Assertions.assertEquals(listIdRoom,hotel.getRoomIdsReservedByClient("1"));
            listIdRoom.add("5");
            Assertions.assertNotEquals(listIdRoom,hotel.getRoomIdsReservedByClient("1"));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
