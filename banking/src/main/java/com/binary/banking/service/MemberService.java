package com.binary.banking.service;

import com.binary.banking.entities.Member;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MemberService {

        public List<Member> getAllMembers();
        public Member getMemberById(Long id);
        public Member createMember(Long projectId, Member member);
        public Member updateMember(Long id, Member memberDetails);
        public void deleteMember(Long id);
        public Member getMembersByEmail(String email);

}
