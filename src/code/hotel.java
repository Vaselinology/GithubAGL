public class hotel {
    private String nom;
    private String adresse;
    private int etoiles;
    private List<Room> rooms;     // Composition
    private List<User> users;     // Aggregation

    public Hotel(String nom, String adresse, int etoiles) {
        this.nom = nom;
        this.adresse = adresse;
        this.etoiles = etoiles;
        this.rooms = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addUser(User user) {
        users.add(user);
    }
}
