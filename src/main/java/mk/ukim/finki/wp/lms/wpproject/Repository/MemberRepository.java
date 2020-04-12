package mk.ukim.finki.wp.lms.wpproject.Repository;

import mk.ukim.finki.wp.lms.wpproject.Model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    public List<Member> findAllByOrderByFirstNameAscLastNameAsc();
    public Long countByType(String type);
}
