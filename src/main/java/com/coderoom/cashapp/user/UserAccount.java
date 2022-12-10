package com.coderoom.cashapp.user;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity(name = "USER_ACCOUNT")
@Data
public class UserAccount implements UserDetails {

    @Id
    @SequenceGenerator(name = "user_sequence" , sequenceName = "user_sequence" , initialValue = 1000 , allocationSize = 1)
    @GeneratedValue(generator = "user_sequence" , strategy = GenerationType.SEQUENCE)
    public Long id;
    public String userName;
    public String password;
    public String email;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return this.userName;
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
        return true;
    }
}
