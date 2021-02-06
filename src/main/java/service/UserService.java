package service;

import entity.User;

import java.util.List;

public interface UserService  {

    User findById(Long id);
    void update(User user);
    void save (User user);
    void delete(User user);
    User findByLogin(String login);
    List<User> getAllUsers();
}
