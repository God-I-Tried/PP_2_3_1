package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> getListOfUsers();

    public void deleteUser(long id);

    void editUser(User user);
}
