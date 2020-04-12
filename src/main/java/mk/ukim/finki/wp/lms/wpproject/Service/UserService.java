package mk.ukim.finki.wp.lms.wpproject.Service;

import mk.ukim.finki.wp.lms.wpproject.Model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    List<User> getAllActiveUsers();
    User getByUsername(String username);
    User getById(Long id);
    User addNew(User user);
    User update(User user);
    void delete(User user);
    void delete(Long id);
}
