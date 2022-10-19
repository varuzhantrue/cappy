package com.capstone.cappy.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotNull
    @NotEmpty(message = "Password should not be empty")
    private String email;
    @NotNull
    @NotEmpty(message = "Password should not be empty")
    private String password;
    @NotNull
    @NotEmpty
    private String roleName="USER";
    @NotNull
    @NotEmpty
    private String firstName;
    @NotNull
    @NotEmpty
    private String lastName;
    @NotNull
    @NotEmpty
    private String number;

    @NotEmpty
    private String dateOfBirth;

    @Override
    public String toString() {
        return super.toString();
    }
}
