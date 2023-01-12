package es.codeurjc.booksmanagementspring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private ERoles name;

    public Role(Integer id, ERoles name) {
        super();
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ERoles getRole() {
        return name;
    }

    public void setRole(ERoles name) {
        this.name = name;
    }
}
