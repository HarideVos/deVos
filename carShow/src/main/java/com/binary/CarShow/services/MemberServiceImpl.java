package com.binary.CarShow.services;

import com.binary.CarShow.entities.Member;
import com.binary.CarShow.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member updateMember(int id, Member updateMember) {
        Optional<Member> member = memberRepository.findById(id);
        if (member.isEmpty()) {
            return memberRepository.save(updateMember);
        } else {
            return null;
        }
    }

    @Override
    public Member deleteMember(int id) {
        return null;
    }

    @Override
    public Optional<Member> getMemberById(int id) {
        Optional<Member> member = memberRepository.findById(id);
        if (member.isEmpty()) {
            return memberRepository.findById(id);
        } else {
            return null;
        }
    }

    @Override
    public Member getMemberByEmail(String email) {
        Member member = memberRepository.findByEmail(email);
        if (member != null) {
            return memberRepository.findByEmail(email);
        } else {
            return null;
        }
    }
}
