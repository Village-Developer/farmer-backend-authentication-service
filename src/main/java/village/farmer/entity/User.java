package village.farmer.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Column(name = "email", length = 50)
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    @ToString.Exclude
    private Role role;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credential_id")
    @ToString.Exclude
    private Credential credential;

    @Column(name = "created_at", columnDefinition = "timestamp default current_timestamp()", updatable = false)
    private Instant createdAt = new Date().toInstant();

    @Column(name = "updated_at", columnDefinition = "timestamp default null on update current_timestamp()")
    private Instant updatedAt = new Date().toInstant();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}