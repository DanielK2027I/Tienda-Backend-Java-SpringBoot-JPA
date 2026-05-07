package com.tienda.service.TiendaBackend.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String nameRole;

    @ElementCollection (fetch = FetchType.EAGER)
    @CollectionTable(name = "role_permissions", joinColumns = @JoinColumn(name = "role_id"))
    @Column(name = "permission")
    private List<String> permissions;

    public Role (){

    }

    public Role(String nameRole, Long id) {
        this.nameRole = nameRole;
        this.id = id;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public List<String> getPermissions() {
        return permissions;
    }
}
