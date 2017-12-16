package com.wiedenman.foundry_0_1.model;

import com.wiedenman.foundry_0_1.exception.WrongVerificationCodeException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Entity
public class User implements UserDetails {

    private static final int MAX_VERIFICATION_CODE = 100000;
    private static final int MIN_VERIFICATION_CODE = 999999;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "USERNAME")
    @NotBlank(message= "Username may not be blank ")
    private String username;

    @Column(name = "FIRST_NAME")
//    @NotBlank(message = "First Name may not be blank ")
    private String firstName;

    @Column(name = "LAST_NAME")
//    @NotBlank(message = "Last Name may not be blank ")
    private String lastName;

    @Column(name = "EMAIL", unique = true)
    @NotBlank(message = "Email may not be blank ")
    @Email(message = "Email format does not match ")
    private String email;

    @NotBlank(message = "Password may not be blank ")
    @Column(length = 100, name = "PASSWORD")
    private String password;  // TODO: Hash this before storage

    @NotNull(message="Passwords do not match. ")
    @Column(length = 100)
    @Size(min=6, message="Passwords do not match. ")
    private String verifyPassword;  // TODO: Hash before storage

//    @NotBlank(message = "Phone Number may not be blank ")
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "VERIFICATION_CODE")
    private String verificationCode;

    @Column(name = "CONFIRMED")
    private boolean confirmed;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ROLE_ID")
    private Role role;

    @Column(nullable = false, name = "ENABLED")
    private boolean enabled;

    @Column(name="CREATION_DATE")
    private final LocalDate creationDate;

    @Column(name = "last_login")
    private LocalDate lastLogin;

    @Column(name = "reset_token")
    private String resetToken;

    public static LocalDate date = LocalDate.now();

    // required by orm
    public User() {
        this.creationDate = date;
//        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
//        this.verifyPassword = BCrypt.hashpw(verifyPassword, BCrypt.gensalt());
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
                LocalDate lastLogin, boolean enabled) {
//        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.confirmed = false;
        this.password = password;
        this.verifyPassword = verifyPassword;
        this.verificationCode = generateVerificationCode();
        this.creationDate = date;
        this.lastLogin = lastLogin;
        this.enabled = enabled;

    }

    static String generateVerificationCode() {
        Random rand = new Random();
        Integer code = rand.nextInt(MIN_VERIFICATION_CODE
                - MAX_VERIFICATION_CODE + 1) + MAX_VERIFICATION_CODE;
        return code.toString();
    }

    public void confirm(final String verificationCode) {
        if (!this.verificationCode.equals(verificationCode)) {
            throw new WrongVerificationCodeException(verificationCode);
        }
        confirmed = true;
    }

    public void generateNewVerificationCode() {
        this.verificationCode = generateVerificationCode();
    }

    public boolean authenticate(final String password) {
        return BCrypt.checkpw(password, this.password);
    }

    public long getId() {
        return id;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public static int getMaxVerificationCode() {
        return MAX_VERIFICATION_CODE;
    }

    public static int getMinVerificationCode() {
        return MIN_VERIFICATION_CODE;
    }

//    public void setId(String id) {
//        this.id = id;
//    }

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

    public void setEmail(String email) {
        this.email = email;
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

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public static LocalDate getDate() {
        return date;
    }

    public static void setDate(LocalDate date) {
        User.date = date;
    }

    private void checkPassword() {
        /**If password and verifyPassword are not null and they do not match, reset verifyPassword to null.*/

        if (password != null && verifyPassword != null && !password.equals(verifyPassword)) {
            verifyPassword = null;
        }
    }

    public void setId(long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

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
