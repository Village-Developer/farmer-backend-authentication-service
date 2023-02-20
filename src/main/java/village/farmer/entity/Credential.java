package village.farmer.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "credentials")
public class Credential {
    @Id
    @Type(type = "uuid-char")
    @Column(name = "credential_id", nullable = false)
    private UUID id = UUID.randomUUID();;

    @Column(name = "username", length = 15, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 120, nullable = false)
    private String password;

    @Column(name = "created_at", columnDefinition = "timestamp default current_timestamp()", updatable = false)
    private Instant createdAt = new Date().toInstant();

    @Column(name = "updated_at", columnDefinition = "timestamp default null on update current_timestamp()")
    private Instant updatedAt = new Date().toInstant();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Credential that = (Credential) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}