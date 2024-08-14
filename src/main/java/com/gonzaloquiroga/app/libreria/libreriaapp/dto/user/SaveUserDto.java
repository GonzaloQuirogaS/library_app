package com.gonzaloquiroga.app.libreria.libreriaapp.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveUserDto implements Serializable {

    @NotBlank
    @Min(3)
    private String username;
    @NotBlank
    @Min(3)
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
