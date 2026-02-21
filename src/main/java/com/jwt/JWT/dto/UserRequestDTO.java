package com.jwt.JWT.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDTO {

    @NotBlank(message="UserName is Required")
    @Size(min = 5,max=20,message = "userName must between 5 to 20 characters")
    private String userName;

    @Email(message="Email should be valid")
    @NotBlank(message="Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min=6,message="Password should be atleast 6 characters")
    private String password;
}
