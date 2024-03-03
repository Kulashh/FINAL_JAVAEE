package model;

import javax.management.relation.Role;

public class User {
    private Long id;
    private String email;
    private String password;
    private String fulName;
    private String roleId;

    public User() {
    }

    public User(Long id, String email, String password, String fulName, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fulName = fulName;
        this.roleId = String.valueOf(role);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFulName() {
        return fulName;
    }

    public void setFulName(String fullName) {
        this.fulName = fullName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}