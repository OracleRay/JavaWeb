package dao;

import domain.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();
    User findUserByUsernameAndPassword(String username, String password);

    void add(User user);

    void delete(int parseInt);

    User findUserId(int id);

    void update(User user);
}
