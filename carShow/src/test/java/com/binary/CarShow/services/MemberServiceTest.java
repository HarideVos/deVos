package com.binary.CarShow.services;

import static org.junit.jupiter.api.Assertions.assertEquals; import static org.junit.jupiter.api.Assertions.assertTrue;

import com.binary.CarShow.entities.Member; import com.binary.CarShow.repositories.MemberRepository; import com.binary.CarShow.services.MemberServiceImpl; import org.junit.jupiter.api.Test; import org.junit.jupiter.api.extension.ExtendWith; import org.mockito.InjectMocks; import org.mockito.Mock; import org.mockito.Mockito; import org.mockito.junit.jupiter.MockitoExtension; import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList; import java.util.List; import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberServiceImpl memberService;

    @Test
    public void getAllMembersTest() {
        // given
        List<Member> members = new ArrayList<>();
        members.add(new Member("John", "Doe", "john.doe@example.com", "1234567890"));
        members.add(new Member("Jane", "Doe", "jane.doe@example.com", "1234567890"));

        Mockito.when(memberRepository.findAll()).thenReturn(members);

        // when
        List<Member> actualMembers = memberService.getAllMembers();

        // then
        assertEquals(2, actualMembers.size());
        assertEquals("John", actualMembers.get(0).getName());
        assertEquals("Jane", actualMembers.get(1).getName());
    }

    @Test
    public void createMemberTest() {
        // given
        Member member = new Member("John", "Doe", "john.doe@example.com", "1234567890");

        Mockito.when(memberRepository.save(member)).thenReturn(member);

        // when
        Member createdMember = memberService.createMember(member);

        // then
        assertEquals(member, createdMember);
        assertEquals("John", createdMember.getName());
    }

    @Test
    public void updateMemberTest() {
        // given
        int id = 1;
        Member existingMember = new Member("John", "Doe", "john.doe@example.com", "1234567890");
        Member updatedMember = new Member("John", "Smith", "john.smith@example.com", "9876543210");

        Mockito.when(memberRepository.findById(id)).thenReturn(Optional.of(existingMember));
        Mockito.when(memberRepository.save(updatedMember)).thenReturn(updatedMember);

        // when
        Member actualUpdatedMember = memberService.updateMember(id, updatedMember);

        // then
        assertEquals(updatedMember, actualUpdatedMember);
        assertEquals("John", actualUpdatedMember.getName());
    }

    @Test
    public void deleteMemberTest() {}

    @Test
    public void getMemberByIdTest() {
        // given
        int id = 1;
        Member member = new Member("John", "Doe", "john.doe@example.com", "1234567890");

        Mockito.when(memberRepository.findById(id)).thenReturn(Optional.of(member));

        // when
        Optional<Member> actualMember = memberService.getMemberById(id);

        // then
        assertTrue(actualMember.isPresent());
        assertEquals(member, actualMember.get());
    }

    @Test
    public void getMemberByEmailTest() {
        // given
        String email = "john.doe@example.com";
        Member member = new Member("John", "Doe", "john.doe@example.com", "1234567890");

        Mockito.when(memberRepository.findByEmail(email)).thenReturn(member);

        // when
        Member actualMember = memberService.getMemberByEmail(email);

        // then
        assertEquals(member, actualMember);
        assertEquals("John", actualMember.getName());
    }
}