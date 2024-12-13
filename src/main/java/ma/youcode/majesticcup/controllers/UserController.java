package ma.youcode.majesticcup.controllers;

import lombok.RequiredArgsConstructor;
import ma.youcode.majesticcup.entities.User;
import ma.youcode.majesticcup.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;



}
