package employee.manage.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_data", uniqueConstraints = {
        @UniqueConstraint(name = "employee_email_unique", columnNames = "employee_email")})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private long id;

    @Column(name = "first_name", nullable = false)
    @NotEmpty
    @Size(min = 2, message = "first name should have 2 characters")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotEmpty
    @Size(min = 2, message = "last name should have 2 characters")
    private String lastName;

    @Column(name = "employee_email", nullable = false)
    @NotEmpty
    @Email
    private String email;

}
