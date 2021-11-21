package service;

import dao.UserDao;
import dao.UserDaoImplement;
import domain.User;

import java.util.List;

public class UserServiceImplement implements UserService{
    public UserDao dao = new UserDaoImplement();

    public List<User> findAll(){
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void delUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findUserId(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public void delSelectedUser(String[] uids) {
        if(uids != null && uids.length > 0){
            for(String id:uids){
                dao.delete(Integer.parseInt(id));
            }
        }
    }
}
