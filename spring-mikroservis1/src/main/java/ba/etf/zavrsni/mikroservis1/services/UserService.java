package ba.etf.zavrsni.mikroservis1.services;

import ba.etf.zavrsni.mikroservis1.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
