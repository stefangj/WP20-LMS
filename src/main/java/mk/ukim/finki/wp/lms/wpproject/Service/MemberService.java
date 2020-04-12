package mk.ukim.finki.wp.lms.wpproject.Service;

import mk.ukim.finki.wp.lms.wpproject.Model.Member;

import java.util.List;

public interface MemberService {
    Long getTotalCount();
    Long getParentsCount();
    Long getStudentsCount();
    List<Member> getAll();
    Member get(Long id);
    Member addNew(Member member);
    Member save(Member member);
    void delete(Member member);
    void delete(Long id);
    boolean hasUsage(Member member);
}
