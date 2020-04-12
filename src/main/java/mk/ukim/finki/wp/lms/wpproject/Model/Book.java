package mk.ukim.finki.wp.lms.wpproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "book")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Please enter book title")
    @NotBlank(message = "Please enter book title")
    @Column(name = "title")
    private String title;

    @NotNull(message = "Please enter book tag")
    @NotBlank(message = "Please enter book tag")
    @Column(name = "tag")
    private String tag;

    @NotNull(message = "Please enter book authors")
    @NotBlank(message = "Please enter book authors")
    @Column(name = "authors")
    private String authors;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "status")
    private Integer status;

    @Column(name = "create_date")
    private Date createDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull(message = "Please select category")
    @ToString.Exclude
    private Category category;

    public Book(@NotNull(message = "Please enter book title") @NotBlank(message = "Please enter book title") String title, @NotNull(message = "Please enter book tag") @NotBlank(message = "Please enter book tag") String tag, @NotNull(message = "Please enter book authors") @NotBlank(message = "Please enter book authors") String authors, String publisher, String isbn, Category category) {
        this.title = title;
        this.tag = tag;
        this.authors = authors;
        this.publisher = publisher;
        this.isbn = isbn;
        this.category = category;
    }

}
