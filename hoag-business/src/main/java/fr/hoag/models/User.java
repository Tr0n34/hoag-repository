package fr.hoag.models;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Builder(builderMethodName = "create")
@ToString
@EqualsAndHashCode(of = "username")
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class User implements UserDetails {

    private String username;
    private String password;
    private String email;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private Collection<? extends GrantedAuthority> authorities;
    private LocalDateTime createdOn;
    private LocalDateTime lastModify;

}
