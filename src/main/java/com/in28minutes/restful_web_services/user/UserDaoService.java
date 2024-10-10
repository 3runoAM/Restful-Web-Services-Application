package com.in28minutes.restful_web_services.user;

import org.springframework.stereotype.Component;

import javax.swing.plaf.OptionPaneUI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Adam", LocalDate.of(1998, 1, 1)));
        users.add(new User(2, "Eve", LocalDate.of(1999, 1, 1)));
        users.add(new User(3, "Jack", LocalDate.of(2000, 1, 1)));
        users.add(new User(4, "Jill", LocalDate.of(2001, 1, 1)));
        users.add(new User(5, "John", LocalDate.of(2002, 1, 1)));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user){
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        Optional<User> userOp = users.stream()
            .filter(user -> user.getId() == id)
            .findFirst();

        return userOp.orElseGet(() -> new User(0, null, null));
    }
}
