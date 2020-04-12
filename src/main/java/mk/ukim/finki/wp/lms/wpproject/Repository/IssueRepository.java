package mk.ukim.finki.wp.lms.wpproject.Repository;

import mk.ukim.finki.wp.lms.wpproject.Model.Issue;
import mk.ukim.finki.wp.lms.wpproject.Model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {

    public List<Issue> findByReturned(Integer returned);
    public Long countByMemberAndReturned(Member member, Integer returned);
}
