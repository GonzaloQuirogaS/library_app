package com.gonzaloquiroga.app.libreria.libreriaapp.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String usersurname;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Min(5)
    private String password;
    @NotBlank
    private String phone;
    @NotBlank
    private String country;
    @NotBlank
    private String district;
    @NotBlank
    private String adress;
    @NotBlank
    private String pcode;
}
