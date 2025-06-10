package user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserUpdateDto {

    private String username;
    private String password;
    private String email;
    private Integer age;
}
