package service;

import entity.User;

public interface UserService  {

    User findById(Long id);
    void update(User user);
    void save (User user);
    void delete(User user);
    User findByLogin(String login);
}
