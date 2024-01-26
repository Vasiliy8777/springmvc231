package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.Dao;
import web.model.User;

import javax.validation.Valid;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final Dao dao;

    @Autowired
    public UserServiceImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void updateUser(User updatedUser) {
        dao.updateUser(updatedUser);
    }

    @Override
    public User getUserById(int id) {
        return dao.getUserById(id);
    }

    @Override
    public void deleteUser(int id) {
        dao.deleteUser(id);
    }
}