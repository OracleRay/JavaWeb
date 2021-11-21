package service;

import domain.User;

import java.util.List;

public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();

    /**
     * 登录方法
     * @param user
     * @return
     */
    User login(User user);

    void addUser(User user);

    void delUser(String id);

    User findUserById(String id);

    void updateUser(User user);

    void delSelectedUser(String[] uids);
}
