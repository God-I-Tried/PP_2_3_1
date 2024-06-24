package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    List<User> getListOfUsers();

    void deleteUser(long id);

    void editUser(User user);

}
