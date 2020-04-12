package mk.ukim.finki.wp.lms.wpproject.Service.Impl;

import mk.ukim.finki.wp.lms.wpproject.Model.User;
import mk.ukim.finki.wp.lms.wpproject.Repository.UserRepository;
import mk.ukim.finki.wp.lms.wpproject.Service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAllByOrderByDisplayNameAsc();
    }

    @Override
    public List<User> getAllActiveUsers() {
       return userRepository.findAllByActiveOrderByDisplayNameAsc(1);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User addNew(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedDate( new Date() );
        user.setLastModifiedDate( user.getCreatedDate() );
        user.setActive(1);
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        user.setLastModifiedDate( new Date() );
        return userRepository.save( user );
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
