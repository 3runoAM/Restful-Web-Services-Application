//package com.in28minutes.restful_web_services.user;
//
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class UserDaoService {
//    private static List<User> users = new ArrayList<>();
//
//    private static Integer userCount = 0;
//
//    static {
//        users.add(new User(userCount++, "Adam", LocalDate.of(1998, 1, 1)));
//        users.add(new User(userCount++, "Eve", LocalDate.of(1999, 1, 1)));
//        users.add(new User(userCount++, "Jack", LocalDate.of(2000, 1, 1)));
//        users.add(new User(userCount++, "Jill", LocalDate.of(2001, 1, 1)));
//        users.add(new User(userCount++, "John", LocalDate.of(2002, 1, 1)));
//    }
//
//    public List<User> findAll() {
//        return users;
//    }
//
//    public User save(User user){
//        user.setId(++userCount);
//        users.add(user);
//        return user;
//    }
//
//    public User findById(long id) {
//        return users.stream()
//            .filter(user -> user.getId() == id)
//            .findFirst()
//            .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
//    }
//
//    public void deleteById(long id) {
//        boolean removed = users.removeIf(user -> user.getId() == id);
//
//        if (!removed) {
//            throw new UserNotFoundException("User with id " + id + " not found");
//        }
//    }
//}