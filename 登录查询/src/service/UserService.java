package service;

import domain.User;

import java.util.List;

public interface UserService {
    /**
     * ��ѯ�����û���Ϣ
     * @return
     */
    public List<User> findAll();

    /**
     * ��¼����
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
