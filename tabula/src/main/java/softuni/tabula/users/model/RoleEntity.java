package softuni.tabula.users.model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class RoleEntity {
    private long id;
    private String role;

    public RoleEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "role", nullable = false)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
