package lauragallace.BEW7D5p.repositories;

import lauragallace.BEW7D5p.entities.Event;
import lauragallace.BEW7D5p.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {

    public Optional<Event> findById(long id);

    public Page<Event> findByTitle(String title, Pageable pageable);

    public int countUsersById(Event event);

    public Page<Event> findByUsers(User user, Pageable pageable);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u JOIN u.events e WHERE u = :user AND e = :event")
    public boolean isParticipating(Event event, User user);
}