package com.rakib.officemanagement.model;

import com.rakib.officemanagement.service.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserInfo extends BaseEntity implements UserDetails {

    private String name;
    @UniqueElements
    private String email;
    private String password;
    private Roles userRole;
    private boolean userIsActive;


    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.userIsActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.userIsActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.userIsActive;
    }

    @Override
    public boolean isEnabled() {
        return this.userIsActive;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of (new SimpleGrantedAuthority (this.userRole.toString ()));
    }
}
