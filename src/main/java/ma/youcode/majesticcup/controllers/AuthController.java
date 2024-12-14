package ma.youcode.majesticcup.controllers;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import ma.senane.utilities.dtos.SuccessDTO;
import ma.youcode.majesticcup.dtos.request.LoginRequestDTO;
import ma.youcode.majesticcup.dtos.request.UserRequestDTO;
import ma.youcode.majesticcup.dtos.response.LoginResponseDTO;
import ma.youcode.majesticcup.services.AuthService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static ma.senane.utilities.response.Response.success;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth")
public class AuthController {

    private static final Logger log = LogManager.getLogger(AuthController.class);
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<SuccessDTO> handleRegister(@RequestBody UserRequestDTO registerDTO) {
        log.info("Received request to register user {}" , registerDTO.toString());
        LoginResponseDTO resDTO = authService.signup(registerDTO);
        return success(HttpServletResponse.SC_CREATED, "Registered successfully." , "jwt" , resDTO);
    }

    @GetMapping("/hello")
    public String handleHello() {
        return "Hello World!";
    }
    @PostMapping("/login")
    public ResponseEntity<SuccessDTO> handleLogin(@RequestBody LoginRequestDTO loginDTO) {
        LoginResponseDTO resDTO = authService.authenticate(loginDTO);
        return success(HttpServletResponse.SC_CREATED, "Logged successfully." , "jwt" , resDTO);
    }

    @PostMapping("/logout")
    public ResponseEntity<SuccessDTO> handleLogout(@RequestBody String jwtToken) {
        authService.logout(jwtToken);
        return success(HttpServletResponse.SC_CREATED, "Logout successfully.");
    }
}
