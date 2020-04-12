package mk.ukim.finki.wp.lms.wpproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "issue")
public class Issue {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "issue_date")
    private Date issueDate;

    @Column(name = "notes")
    private String notes;

    @Column(name = "expected_return_date")
    private Date expectedReturnDate;

    @Column(name = "returned")
    private Integer returned;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @JsonIgnore
    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL)
    private List<IssuedBook> issuedBooks;
}
