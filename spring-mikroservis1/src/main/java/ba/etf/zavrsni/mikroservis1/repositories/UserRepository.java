package ba.etf.zavrsni.mikroservis1.repositories;

import ba.etf.zavrsni.mikroservis1.domain.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<RegisteredUser,String> {
}
