package ma.youcode.majesticcup.utils.initializer;

import lombok.RequiredArgsConstructor;
import ma.youcode.majesticcup.entities.Role;
import ma.youcode.majesticcup.entities.User;
import ma.youcode.majesticcup.repositories.RoleRepository;
import ma.youcode.majesticcup.repositories.UserRepository;
import ma.youcode.majesticcup.utils.enums.RoleName;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DatabaseInitializer implements CommandLineRunner {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {
            Role moderator = new Role();
            moderator.setName(RoleName.ROLE_MODERATOR);
            Role admin = new Role();
            admin.setName(RoleName.ROLE_ADMIN);
            Role user = new Role();
            user.setName(RoleName.ROLE_USER);
            List<Role> roles = List.of(moderator, admin, user);
            roleRepository.saveAll(roles);
            User adminUser = new User();
            adminUser.setUsername("admin");
            adminUser.setPassword(passwordEncoder.encode("admin"));
            adminUser.getRoles().add(admin);
            userRepository.save(adminUser);
        }
    }
}
