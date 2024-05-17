package dev.be.moduleapi.service;

import org.springframework.beans.factory.annotation.Value;
import dev.be.moduleapi.exception.CustomException;
import dev.be.modulecommon.domain.Member;
import dev.be.modulecommon.enums.CodeEnum;
import dev.be.modulecommon.repositories.MemberRepository;
import dev.be.modulecommon.service.CommonDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {

    @Value("${profile-name}")
    private String name;

    private final CommonDemoService commonDemoService;

    private final MemberRepository memberRepository;

    public String save() {
        System.out.println("env profile : " + name);
        Member newMember = memberRepository.save(Member.builder()
                .name(Thread.currentThread().getName())
                .build());

        return newMember.getName();
    }

    public String find() {

        return String.valueOf(memberRepository.findAll().size());
    }

    public String exception() {
        if (true) {
            throw new CustomException(CodeEnum.UNKNOWN_ERROR);
        }
        return "exception";
    }
}
