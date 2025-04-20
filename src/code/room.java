public class room {
    private int roomNumber;
    private int price;
    private String bedType;
    private String description;
    private boolean available;

    public Room(int roomNumber, int price, String bedType, String description) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.bedType = bedType;
        this.description = description;
        this.available = true;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }
}
