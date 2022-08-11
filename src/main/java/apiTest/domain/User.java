package apiTest.domain;

import lombok.Builder;
import lombok.Data;

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
