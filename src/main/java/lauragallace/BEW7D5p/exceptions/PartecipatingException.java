package lauragallace.BEW7D5p.exceptions;

import lauragallace.BEW7D5p.entities.Event;
import lauragallace.BEW7D5p.entities.User;


public class PartecipatingException extends RuntimeException {
    public PartecipatingException(String message) {
        super(message);
    }

    public PartecipatingException(Event event, User user) {
        super("User " + user.getName() + " is already partecipating in event " + event.getTitle());
    }
}