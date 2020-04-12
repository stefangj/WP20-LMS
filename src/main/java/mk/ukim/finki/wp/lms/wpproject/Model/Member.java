package mk.ukim.finki.wp.lms.wpproject.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "member")
public class Member implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "Please select member type")
    @NotNull(message = "Please select member type")
    @Column(name = "type")
    private String type;

    @NotEmpty(message = "Please enter first name")
    @NotNull(message = "Please enter first name")
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @NotEmpty(message = "Please select gender")
    @NotNull(message = "Please select gender")
    @Column(name = "gender")
    private String gender;

    @NotNull(message = "Please enter birth date")
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "joining_date")
    private Date joiningDate;

    @Column(name = "contact")
    private String contact;

    @Column(name = "email")
    private String email;

    public Member(@NotEmpty(message = "Please select member type") @NotNull(message = "Please select member type") String type, @NotEmpty(message = "Please enter first name") @NotNull(message = "Please enter first name") String firstName, String lastName, @NotEmpty(message = "Please select gender") @NotNull(message = "Please select gender") String gender, @NotNull(message = "Please enter birth date") Date dateOfBirth, String contact, String email) {
        this.type = type;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.contact = contact;
        this.email = email;
    }
}
