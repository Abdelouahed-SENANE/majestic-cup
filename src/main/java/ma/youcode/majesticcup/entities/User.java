package ma.youcode.majesticcup.entities;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Set;

@Document(collection = "users")
@RequiredArgsConstructor
@Data
public class User {

    @Id
    private String id;

    @Column(unique = true , nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    @Column(updatable = false , name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private Set<Role> roles;

}
