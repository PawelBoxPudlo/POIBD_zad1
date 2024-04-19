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
