package sesame.gestion_freelances.models.Enumeration;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public enum Role {

    ENTREPRISE,
    FREELANCER
/*
    USER(Collections.emptySet()),
    FREELANCER(
            Set.of(
                    FREELANCER_READ,
                    FREELANCER_UPDATE,
                    FREELANCER_DELETE,
                    FREELANCER_CREATE,
                    ENTREPRISE_READ,
                    ENTREPRISE_UPDATE,
                    ENTREPRISE_DELETE,
                    ENTREPRISE_CREATE
            )
    ),
    ENTREPRISE(
            Set.of(
                    ENTREPRISE_READ,
                    ENTREPRISE_UPDATE,
                    ENTREPRISE_DELETE,
                    ENTREPRISE_CREATE
            )
    )

    ;

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }

 */
}