package kata314.service;

import kata314.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User getUserById(Long id);
    User getUserByEmail(String email);
    void deleteUserById(Long id);
    void saveUser(User user, List<Long> roleIds);
    void updateUser(Long id, User userDetails, List<Long> roleIds);
}
