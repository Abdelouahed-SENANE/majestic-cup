package ma.youcode.majesticcup.controllers;

import lombok.RequiredArgsConstructor;
import ma.youcode.majesticcup.entities.User;
import ma.youcode.majesticcup.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/")
public class UserController {

    public final UserService userService;
    @PostMapping("user/new")
    public ResponseEntity<User> handleCreate(@RequestBody User user) {
        return ResponseEntity.ok(userService.create(user));
    }
    @GetMapping("user/get")
    public ResponseEntity<User> handleGetUser() {
        User user = new User();
        user.setPassword("helloword");
        user.setUsername("Abdelouahed TEst");
        return ResponseEntity.ok(user);
    }
}
