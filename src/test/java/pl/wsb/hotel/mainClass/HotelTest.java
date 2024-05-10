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
