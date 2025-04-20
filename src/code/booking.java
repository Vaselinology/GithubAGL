import java.time.LocalDate;

public class booking {
    private int id;
    private User user;
    private Room room;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    public Booking(int id, User user, Room room, LocalDate dateDebut, LocalDate dateFin) {
        this.id = id;
        this.user = user;
        this.room = room;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
}

