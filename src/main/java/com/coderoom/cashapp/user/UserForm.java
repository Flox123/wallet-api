package com.coderoom.cashapp.user;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@Data
public class UserForm {
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    @Email
    private String email;

}
