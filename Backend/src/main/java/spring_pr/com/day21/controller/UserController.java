package spring_pr.com.day21.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import spring_pr.com.day21.DTO.JsonResponse;
import spring_pr.com.day21.DTO.UserCreateRequest;
import spring_pr.com.day21.model.User;
import spring_pr.com.day21.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserCreateRequest request) {
        User createdUser = userService.createUser(request.getEmail(), request.getPassword());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/users/count")
    public ResponseEntity<JsonResponse<Long>> countUsers() {
        Long count = userService.countUsers();
        return ResponseEntity.ok(new JsonResponse<>(true, count, null));
    }
    @GetMapping("/users/emails")
    public ResponseEntity<List<String>> getAllEmails(int page,int size) {
        List<String> emails = userService.getAllEmails(page, size);
        return ResponseEntity.ok(emails);
    }


    @PutMapping("/users/{id}")
    public ResponseEntity<JsonResponse<User>> updateUser(@PathVariable int id, @RequestBody User request) {
        User updatedUser = userService.updateUser(id, request);
        return ResponseEntity.ok(new JsonResponse<>(true, updatedUser, null));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<JsonResponse<String>> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(new JsonResponse<>(true, "User with id " + id + " has been deleted.", null));
    }
}
