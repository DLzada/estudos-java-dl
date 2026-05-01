package br.com.daniel.spring_security_gym.database.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RolesEntity implements GrantedAuthority {

    @Id
    private Integer id;
    private String nome;

    @Override
    public @Nullable String getAuthority() {
        return "nome";
    }
}
