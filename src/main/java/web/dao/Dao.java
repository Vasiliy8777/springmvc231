package web.dao;

import web.model.User;

import java.util.List;

public interface Dao {
List<User> getAllUsers();

void addUser(User user);

void updateUser(User updatedUser);

User getUserById(int id);

void deleteUser(int id);
}