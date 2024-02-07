package hexlet.code.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;


import jakarta.validation.constraints.Email;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User implements BaseEntity, UserDetails {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    @Email
    private String email;
    private String passwordDigest;

    @CreatedDate
    private LocalDate createdAt;

    @LastModifiedDate
    private LocalDate  updatedAt;

    @Override
    public String getPassword() {
        return passwordDigest;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<GrantedAuthority>();
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
}
