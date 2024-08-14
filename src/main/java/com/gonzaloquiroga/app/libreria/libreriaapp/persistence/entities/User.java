package com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gonzaloquiroga.app.libreria.libreriaapp.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String username;
    private String usersurname;
    private String email;
    private String password;
    private String phone;
    private String country;
    private String district;
    private String adress;
    private String pcode;
    private LocalDateTime registeredAt;

    @Transient
    private boolean isAdmin;
    private boolean enabled;
    @Enumerated(EnumType.STRING)
    private Role role;


    @OneToMany(mappedBy = "user", orphanRemoval=true)
    private List<Order> orders;

    @PrePersist
    public void prePersist() {
        enabled = true;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((role.name())));
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


