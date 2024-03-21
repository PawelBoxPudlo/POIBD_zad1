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
