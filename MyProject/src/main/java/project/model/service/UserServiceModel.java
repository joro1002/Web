package project.model.service;

import project.model.entity.Role;

public class UserServiceModel extends BaseServiceModel{
    private String username;
    private String password;
    private String email;
    private RoleServiceModel role;

    public UserServiceModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RoleServiceModel getRole() {
        return role;
    }

    public void setRole(RoleServiceModel role) {
        this.role = role;
    }
}
