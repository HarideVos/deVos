package com.binary.library.config;

import com.binary.library.entities.Visitor;
import com.binary.library.services.VisitorService;
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
public class VisitorDetailsService implements UserDetailsService {
    @Autowired
   private VisitorService visitorService;

    //Email is used as a username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String visitorUserEmail = null;
        String visitorUserPassword= null;
        List<GrantedAuthority> authority = null;
        Visitor visitor = visitorService.getVisitorByEmail(username);
        if(visitor ==null){
            throw new UsernameNotFoundException("Visitor not found with email: " + username);
        }else{
            visitorUserEmail = visitor.getEmail();
            visitorUserPassword = visitor.getPassword();
            authority = new ArrayList<>();
            authority.add(new SimpleGrantedAuthority(visitor.getRole()));
        }
        return new User(visitorUserEmail, visitorUserPassword, authority);
    }

}
