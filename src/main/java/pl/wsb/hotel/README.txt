Dodałem metode toString() dla szybszego sprawdzania zmiennych w klasie

package pl.wsb.hotel;

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


package pl.wsb.hotel;

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


package pl.wsb.hotel;

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
