package com.isoft.security.user;

import com.isoft.security.config.UniqueColumn;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Password can not be blank")
    @Size(min = 6, message = "Weak password! Must be 6 characters or more")
    private String password;

    @UniqueColumn() //Custom Unique Column Validator
    @NotBlank(message = "Username can not be blank")
    private String username;

    private String role = UserRole.getEnumList().get(0);

    private Integer active = 1;

    private Date dateCreated = new Date();

//    @UniqueColumn() //Custom Unique Column Validator
//    @NotBlank(message = "Username can not be blank")
//    List<User> userList;

    public User() {
    }

//    public User(List<User> userList) {
//        this.userList = userList;
//    }

    public User(String username, String password, String role, Date dateCreated) {
        this.password = password;
        this.username = username;
        this.role = role;
        this.dateCreated = dateCreated;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String userRole) {
        this.role = userRole;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", role=" + role +
                ", active=" + active +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
