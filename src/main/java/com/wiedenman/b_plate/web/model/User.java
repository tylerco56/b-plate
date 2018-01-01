package com.wiedenman.b_plate.web.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *    888                      888          888
 *    888                      888          888
 *    888                      888          888
 *    88888b.         88888b.  888  8888b.  888888 .d88b.
 *    888 "88b        888 "88b 888     "88b 888   d8P  Y8b
 *    888  888 888888 888  888 888 .d888888 888   88888888
 *    888 d88P        888 d88P 888 888  888 Y88b. Y8b.
 *    88888P"         88888P"  888 "Y888888  "Y888 "Y8888
 *                    888
 *                    888
 *                    888
 *
 *
 * @author Landon Wiedenman
 * github.com/landongw/b-plate
 * Usage: or personal non-commercial use only.  Please contact me for commercial uses.
 *
 * Copyright (c) 2017 Landon Wiedenman
 */

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "USERNAME", unique = true)
    @NotBlank(message= "Username may not be blank ")
    private String username;

    @Column(name = "FIRST_NAME")
    @NotBlank(message = "First Name may not be blank ")
    private String firstName;

    @Column(name = "LAST_NAME")
    @NotBlank(message = "Last Name may not be blank ")
    private String lastName;

    @Column(name = "EMAIL", unique = true)
    @NotBlank(message = "Email may not be blank. ")
    @Email(message = "Email format does not match. ")
    private String email;

    @Column( name = "PASSWORD", length = 100)
    @NotBlank(message = "Password may not be blank. ")
    private String password;

    @Column(name = "VERIFY_PASSWORD", length = 100)
    @NotBlank(message="Verify Password may not be blank. ")
    private String verifyPassword;

    @Column(name = "PHONE_NUMBER")
    @NotBlank(message = "Mobile may not be blank ")
    @Pattern(regexp="(^$|[0-9]{10})", message = "Invalid. Use format: 1234567890")
    private String phoneNumber;

    @JoinColumn(name = "ROLE_ID")
    @OneToOne(cascade = CascadeType.ALL)
    private Role role;

    @Column(nullable = false, name = "ENABLED")
    private boolean enabled;

    @Column(name="CREATION_DATE")
    private final LocalDate creationDate;

    @Column(name = "LAST_LOGIN")
    private LocalDate lastLogin;

    @Column(name = "RESET_TOKEN")
    private String resetToken;

    public static LocalDate date = LocalDate.now();

    public User() {
        this.creationDate = date;
        this.enabled = false;
    }

    public User(String email, String password, String verifyPassword) {
        this.creationDate = date;
        this.email = email;
        this.password = password;
        this.verifyPassword = verifyPassword;
    }

    public User(String firstName, String lastName,
                String email, String phoneNumber,
                String password, String verifyPassword,
                LocalDate lastLogin, boolean enabled,
                Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.verifyPassword = verifyPassword;
        this.creationDate = date;
        this.lastLogin = lastLogin;
        this.enabled = enabled;
        this.role = role;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Adds new granted authority
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getName()));
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static LocalDate getDate() {
        return date;
    }

    public static void setDate(LocalDate date) {
        User.date = date;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    // TODO: implement last login
    public LocalDate getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDate lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }
}
