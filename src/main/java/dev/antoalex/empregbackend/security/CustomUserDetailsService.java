package dev.antoalex.empregbackend.security;

import dev.antoalex.empregbackend.model.Role;
import dev.antoalex.empregbackend.model.UserEntity;
import dev.antoalex.empregbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(userName).orElseThrow(() ->
                new UsernameNotFoundException("User Name not Found"));

        return new User(user.getUserName(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles){
        return roles.stream().map(role ->
                new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}