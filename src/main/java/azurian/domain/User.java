package azurian.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@Builder
public class User {
    private String userId;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String phoneNumber;
    private String phoneCountryCode;
    private String country;
    private String email;
}
