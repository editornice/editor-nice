package com.editornice.member.repository;

import com.editornice.member.domain.Level;
import com.editornice.member.domain.Member;
import com.editornice.member.domain.SnsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

    Optional<Member> findByNicknameAndSnsType(String nickname, SnsType snsType);

    Optional<Member> findById(Long id);
}
