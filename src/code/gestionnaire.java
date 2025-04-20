public class gestionnaire {
    private Hotel hotel;
    private List<Booking> bookings;

    public Gestionnaire(Hotel hotel) {
        this.hotel = hotel;
        this.bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void addRoom(Room room) {
        hotel.addRoom(room);
    }

    public void addUser(User user) {
        hotel.addUser(user);
    }
}
