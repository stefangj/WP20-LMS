package mk.ukim.finki.wp.lms.wpproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "category")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Please enter category name")
    @NotBlank(message = "Please enter category name")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Please enter category short name")
    @NotBlank(message = "Please enter category short name")
    @Length(max = 4, message = "Must not exceed 4 characters.")
    @Column(name = "short_name")
    private String shortName;

    @Column(name = "notes")
    @Length(max = 1000, message = "Must not exceed 1000 characters.")
    private String notes;

    @Column(name = "create_date")
    private Date createDate;

    @JsonIgnore
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Book> books;

    public Category(String name, String shortName, String notes, Date createDate){
        this.name = name;
        this.shortName = shortName;
        this.notes = notes;
        this.createDate = createDate;
    }
}
