package mk.ukim.finki.wp.lms.wpproject.Service.Impl;

import mk.ukim.finki.wp.lms.wpproject.Model.Member;
import mk.ukim.finki.wp.lms.wpproject.Repository.MemberRepository;
import mk.ukim.finki.wp.lms.wpproject.Service.IssueService;
import mk.ukim.finki.wp.lms.wpproject.Service.MemberService;
import mk.ukim.finki.wp.lms.wpproject.common.Constants;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final IssueService issueService;

    public MemberServiceImpl(MemberRepository memberRepository, IssueService issueService) {
        this.memberRepository = memberRepository;
        this.issueService = issueService;
    }

    @Override
    public Long getTotalCount() {
        return memberRepository.count();
    }

    @Override
    public Long getParentsCount() {
        return memberRepository.countByType(Constants.MEMBER_PARENT);
    }

    @Override
    public Long getStudentsCount() {
        return memberRepository.countByType(Constants.MEMBER_PARENT);
    }

    @Override
    public List<Member> getAll() {
        return memberRepository.findAllByOrderByFirstNameAscLastNameAsc();
    }

    @Override
    public Member get(Long id) {
        return memberRepository.findById(id).get();
    }

    @Override
    public Member addNew(Member member) {
        member.setJoiningDate( new Date() );
        return memberRepository.save( member );
    }

    @Override
    public Member save(Member member) {
        return memberRepository.save( member );
    }

    @Override
    public void delete(Member member) {
        memberRepository.delete(member);
    }

    @Override
    public void delete(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public boolean hasUsage(Member member) {
        return issueService.getCountByMember(member) > 0;
    }
}
