package mk.ukim.finki.wp.lms.wpproject.Service;

import mk.ukim.finki.wp.lms.wpproject.Model.Issue;
import mk.ukim.finki.wp.lms.wpproject.Model.Member;

import java.util.List;

public interface IssueService {
    List<Issue> getAll();
    Issue get(Long id);
    List<Issue> getAllUnreturned();
    Issue addNew(Issue issue);
    Issue save(Issue issue);
    Long getCountByMember(Member member);
}
