package mk.ukim.finki.wp.lms.wpproject.Service.Impl;

import mk.ukim.finki.wp.lms.wpproject.Model.Issue;
import mk.ukim.finki.wp.lms.wpproject.Model.Member;
import mk.ukim.finki.wp.lms.wpproject.Repository.IssueRepository;
import mk.ukim.finki.wp.lms.wpproject.Service.IssueService;
import mk.ukim.finki.wp.lms.wpproject.common.Constants;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;

    public IssueServiceImpl(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    @Override
    public List<Issue> getAll() {
        return issueRepository.findAll();
    }

    @Override
    public Issue get(Long id) {
        return issueRepository.findById(id).get();
    }

    @Override
    public List<Issue> getAllUnreturned() {
        return issueRepository.findByReturned( Constants.BOOK_NOT_RETURNED );
    }

    @Override
    public Issue addNew(Issue issue) {
        issue.setIssueDate( new Date() );
        issue.setReturned( Constants.BOOK_NOT_RETURNED );
        return issueRepository.save(issue);
    }

    @Override
    public Issue save(Issue issue) {
        return issueRepository.save(issue);
    }

    @Override
    public Long getCountByMember(Member member) {
        return issueRepository.countByMemberAndReturned(member, Constants.BOOK_NOT_RETURNED);
    }
}
