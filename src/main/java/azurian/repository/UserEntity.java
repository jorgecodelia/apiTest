package azurian.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user", indexes= @Index(columnList = "userid"))
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @Column(nullable = false)
    private String userid;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
    private String date_of_birth;

    @Column(nullable = false)
    private String phone_number;

    @Column(nullable = false)
    private String phone_country_code;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String email;
}
