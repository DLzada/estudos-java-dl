package br.com.daniel.spring_security_gym.service;

import br.com.daniel.spring_security_gym.database.repository.IAlunosRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final IAlunosRespository alunosRespository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return alunosRespository.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("Usuário nao encontrado"));
    }
}
