package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> getListUsers() {
        return userDao.getListUsers();
    }

    @Override
    public void saveUser(User user) {
         userDao.saveUser(user);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public void updateUserById(int id,User user) {
         userDao.updateUserById(id,user);
    }

    @Override
    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }
}