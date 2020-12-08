package com.sfl.simplecafemanager.domain.entity.user;

import com.sfl.simplecafemanager.domain.entity.table.Table;
import com.sfl.simplecafemanager.util.PostgreSQLEnumType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Set;

@Entity
@javax.persistence.Table (name = "user", schema = "public")
@TypeDef(
        name = "user_type",
        typeClass = PostgreSQLEnumType.class
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "field username is required")
    @Column(name = "username")
    private String username;
    @NotEmpty(message = "field password is required")
    @Column(name = "password")
    private String password;
    @Type(type = "user_type")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    private LocalDate dob;

    @OneToMany(mappedBy = "waiter",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Table> tables;

    public User() {
    }

    public User(String username, String password, UserType userType, Set<Table> tables, LocalDate dob) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.tables = tables;
        this.dob = dob;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String firstName) {
        this.username = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String lastName) {
        this.password = lastName;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Set<com.sfl.simplecafemanager.domain.entity.table.Table> getTables() {
        return tables;
    }

    public void setTables(Set<Table> tables) {
        this.tables = tables;
    }
}
