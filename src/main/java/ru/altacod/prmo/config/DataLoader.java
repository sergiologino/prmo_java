package ru.altacod.prmo.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.altacod.prmo.model.User;
import ru.altacod.prmo.repository.UserRepository;

public class DataLoader implements ApplicationRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(userRepository.count()==0){
            User admin = new User();
            admin.setUsername("admin");
            admin.setRole("ADMIN");
            admin.setPassword(passwordEncoder.encode("1714"));
            userRepository.save(admin);
        }
    }
}
