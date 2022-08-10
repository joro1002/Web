package project.model.binding;

import org.hibernate.validator.constraints.Length;

public class UserLoginBindingModel {
    private String username;
    private String password;

    public UserLoginBindingModel() {
    }

    @Length(min = 4, max = 10, message = "Username must be more than 4 characters")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Length(min = 10, max = 15, message = "Password must be more than 10 characters")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
