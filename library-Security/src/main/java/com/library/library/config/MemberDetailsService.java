package com.library.library.config;


import com.library.library.entities.Member;
import com.library.library.services.MemberService;
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
public class MemberDetailsService implements UserDetailsService {
    @Autowired
   private MemberService memberService;

    //Email is used as a username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String memberUserEmail = null;
        String memberUserPassword= null;
        List<GrantedAuthority> authority = null;
        Member member = memberService.getMemberByEmail(username);
        if(member==null){
            throw new UsernameNotFoundException("Member not found with email: " + username);
        }else{
            memberUserEmail = member.getEmail();
            memberUserPassword = member.getPassword();
            authority = new ArrayList<>();
            authority.add(new SimpleGrantedAuthority(member.getRole()));
        }
        return new User(memberUserEmail, memberUserPassword, authority);
    }

}
