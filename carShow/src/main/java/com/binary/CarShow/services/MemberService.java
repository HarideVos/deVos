package com.binary.CarShow.services;

import com.binary.CarShow.entities.Member;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public interface MemberService {
    List<Member> getAllMembers();
    Member createMember(Member member);
    Member updateMember(int id, Member updateMember);
    Member deleteMember(int id);
    Optional<Member> getMemberById(int id);
    Member getMemberByEmail(String email);


}
