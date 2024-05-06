package pl.wsb.hotel.hotelClass;

public class Room {

    String id;
    double area;
    int floor;
    boolean hasKingSizeBed;
    boolean balcony;
    String description;
    int sizeRoom;

    public Room() {
    }

    public Room(String id, double area, int floor, boolean hasKingSizeBed) {
        this.id = id;
        this.area = area;
        this.floor = floor;
        this.hasKingSizeBed = hasKingSizeBed;
    }

    public Room(String id, double area, int floor, boolean hasKingSizeBed, String description) {
        this.id = id;
        this.area = area;
        this.floor = floor;
        this.hasKingSizeBed = hasKingSizeBed;
        this.description = description;
    }

    public Room(String id, double area, int floor, boolean hasKingSizeBed, boolean balcony, String description, int sizeRoom) {
        this.id = id;
        this.area = area;
        this.floor = floor;
        this.hasKingSizeBed = hasKingSizeBed;
        this.balcony = balcony;
        this.description = description;
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
                ", rating=" + description +
                ", sizeRoom=" + sizeRoom +
                '}';
    }

    public String getId() {
        return id;
    }

    public double getArea() {
        return area;
    }

    public int getFloor() {
        return floor;
    }

    public boolean isHasKingSizeBed() {
        return hasKingSizeBed;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public String getDescription() {
        return description;
    }

    public int getSizeRoom() {
        return sizeRoom;
    }
}
