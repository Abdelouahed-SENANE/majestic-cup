package ma.youcode.majesticcup.controllers;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import ma.senane.utilities.dtos.SuccessDTO;
import ma.youcode.majesticcup.dtos.request.UserRequestDTO;
import ma.youcode.majesticcup.dtos.response.UserResponseDTO;
import ma.youcode.majesticcup.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static ma.senane.utilities.response.Response.success;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth")
public class AuthController {

    private final AuthService authService;

    @GetMapping("/me")
    public ResponseEntity<SuccessDTO> handleMe() {
        UserResponseDTO me = authService.getMe();
        return success(HttpServletResponse.SC_OK , "success." , "me" , me);
    }
    @PostMapping("/register")
    public ResponseEntity<SuccessDTO> handleRegister(@RequestBody UserRequestDTO userDTO) {
        String jwtToken = authService.register(userDTO);
        return success(HttpServletResponse.SC_CREATED, jwtToken);
    }

    @PostMapping("/login")
    public ResponseEntity<SuccessDTO> handleLogin(@RequestBody UserRequestDTO userDTO) {
        String jwtToken = authService.login(userDTO);
        return success(HttpServletResponse.SC_CREATED, jwtToken);
    }

    @PostMapping("/logout")
    public ResponseEntity<SuccessDTO> handleLogout(@RequestBody String jwtToken) {
        authService.logout(jwtToken);
        return success(HttpServletResponse.SC_CREATED, "success.");
    }
}
