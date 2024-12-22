package ma.youcode.majesticcup.controllers;

import lombok.RequiredArgsConstructor;
import ma.senane.utilities.dtos.SuccessDTO;
import ma.youcode.majesticcup.entities.User;
import ma.youcode.majesticcup.services.UserService;
import ma.youcode.majesticcup.utils.enums.RoleName;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

import static ma.senane.utilities.response.Response.success;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/admin/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<SuccessDTO> getMe() {
        return success(200 , "Authenticated user." , "me" , userService.getMe());
    }
    @GetMapping("/all")
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok("All Users.");
    }

    @PostMapping("edit/{username}/roles")
    public ResponseEntity<SuccessDTO> handleEditRole(@PathVariable String username, @RequestBody Set<RoleName> roles) {
        userService.editRoles(username, roles);
        return success(200 , "Roles updated successfully.");
    }

}
