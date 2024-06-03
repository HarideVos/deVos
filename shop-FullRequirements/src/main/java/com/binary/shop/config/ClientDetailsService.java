package com.binary.shop.config;

import com.binary.shop.entities.Client;
import com.binary.shop.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientDetailsService implements UserDetailsService {
    @Autowired
   private ClientService clientService;

    //Email is used as a username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String memberUserEmail = null;
        String memberUserPassword= null;
        List<GrantedAuthority> authority = null;
        Client client = clientService.getClientByEmail(username);
        if(client ==null){
            throw new UsernameNotFoundException("Client not found with email: " + username);
        }else{
            memberUserEmail = client.getEmail();
            memberUserPassword = client.getPassword();
            authority = new ArrayList<>();
            authority.add(new SimpleGrantedAuthority(client.getRole()));
        }
        return new User(memberUserEmail, memberUserPassword, authority);
    }

}
