package spring_pr.com.day21.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import spring_pr.com.day21.model.User;
import spring_pr.com.day21.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository Repository;

    public UserService(UserRepository Repository) {
        this.Repository = Repository;
    }

    public Long countUsers() {
        return Repository.countUsers();
    }

    public User authenticate(String email, String password) {
        User user = Repository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
            
        }
        return null;
    }

    public List<User> getAllUsers() {
        return Repository.findAll();
    }

    public List<String> getAllEmails(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return Repository.findAllEmails(pageable);
    }

    public User createUser(String email, String password) {
        User user = new User(email, password);
        return Repository.save(user);
    }

    public User updateUser(int id, User user) {
        user.setId(id);
        return Repository.save(user);
    }

    public void deleteUser(int id) {
        Repository.deleteById(id);
    }

}
