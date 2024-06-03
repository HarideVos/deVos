package com.binary.banking.config;

import com.binary.banking.entities.Member;
import com.binary.banking.service.MemberServiceImpl;
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
public class CreditDetailsServices implements UserDetailsService {

    @Autowired
    private MemberServiceImpl memberService;

    // member email is used as a username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String memberuserEmail = null;
        String memberuserPassword = null;
        List<GrantedAuthority> authorities = null;

        Member member = memberService.getMembersByEmail(username);
        if(member == null){
            throw new UsernameNotFoundException("Member not found with email : " + username );
        }else{
            memberuserEmail = member.getEmail();
            memberuserPassword = member.getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(member.getRole()));
        }
        return new User(memberuserEmail, memberuserPassword, authorities);
    }
}