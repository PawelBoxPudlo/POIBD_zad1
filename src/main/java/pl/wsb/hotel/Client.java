package pl.wsb.hotel;

import java.time.LocalDate;
import java.time.Period;

public class Client {

    String id;
    String firstName;
    String lastName;
    LocalDate birthDate;
    String address;
    String work;
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

}
