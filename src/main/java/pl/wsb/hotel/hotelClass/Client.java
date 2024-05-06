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

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getSex() {
        return sex;
    }

    public String getAddress() {
        return address;
    }

    public String getEducation() {
        return education;
    }
}
