package com.binary.banking.service;

import com.binary.banking.entities.Account;
import com.binary.banking.entities.Member;
import com.binary.banking.exceptions.MemberNotFoundException;
import com.binary.banking.repository.AccountRepository;
import com.binary.banking.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private AccountRepository accountRepository;

    public List<Member> getAllMembers() {
        List<Member> allMembers = memberRepository.findAll();
        if(allMembers.isEmpty()){
            throw new MemberNotFoundException("Member not found");
        }else{
            return allMembers;
        }
    }

    public Member getMemberById(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        if(member.isEmpty()){
            throw new MemberNotFoundException("Member not found");
        }else{
            return member.get();
        }
    }

    public Member createMember(Long accountId, Member member) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new MemberNotFoundException("Member not found"));
        member.setAccount(account);
        return memberRepository.save(member);
    }

    public Member updateMember(Long id, Member memberDetails) {
        Optional<Member> member = memberRepository.findById(id);
        if(member.isEmpty()){
            throw new MemberNotFoundException("Member not found");
        }else{
            member.get().setName(memberDetails.getName());
            member.get().setBalance(memberDetails.getBalance());
            return memberRepository.save(member.get());
        }
    }

    public void deleteMember(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        if(member.isEmpty()){
            throw new MemberNotFoundException("Member not found");
        }else{
            memberRepository.delete(member.get());
        }

    }


    @Override
    public Member getMembersByEmail(String email) {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);
        if(optionalMember.isPresent()){
            return  optionalMember.get();
        }
        return null;
    }
}
