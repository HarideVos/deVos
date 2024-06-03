package com.library.library.services;


import com.library.library.entities.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    List<Member> getAllMembers();
    Member createMember(Member member);
    Member updateMember(int id, Member updateMember);
    Member deleteMember(int id);
    Optional<Member> getMemberById(int id);
    Member getMemberByEmail(String email);


}
