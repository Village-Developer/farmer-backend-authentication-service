package village.farmer.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "api_documents")
public class ApiDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "api_id", nullable = false)
    private Integer id;

    @Column(name = "credential_id")
    private Integer credentialId;

    @Column(name = "api_list_id")
    private Integer apiListId;

    @Column(name = "api_method")
    private String apiMethod;

    @Column(name = "api_path")
    private String apiPath;

    @Column(name = "api_description")
    private String apiDescription;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ApiDocument that = (ApiDocument) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
