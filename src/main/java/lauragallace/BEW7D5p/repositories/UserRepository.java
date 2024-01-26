package lauragallace.BEW7D5p.repositories;

import lauragallace.BEW7D5p.entities.Event;
import lauragallace.BEW7D5p.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findById(long id);

    public Optional<User> findByEmail(String email);

    public Page<User> findByEvents(Event event, Pageable pageable);


}