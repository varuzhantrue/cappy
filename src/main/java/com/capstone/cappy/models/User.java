package com.capstone.cappy.models;

import com.capstone.cappy.enums.ROLES;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity//for hibernate
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//generates unical id each time
    private Long id;

    @Column(unique = true)
    private String email;
    private String password;
    @Transient
    private ROLES role;
    private String roleName;

    private String firstName;
    private String lastName;
    private String number;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")//corrects the date format
    private LocalDate dateOfBirth;
    @Transient//no need to be "age" column in db coz it can be calculated real time
    private Integer age;
    @Transient
    private History history = new History();

    public User(String email,
                String password,
                String roleName,
                String firstName,
                String lastName,
                String number,
                LocalDate dateOfBirth,
                History history) {
        this.email = email;
        this.password = password;
        this.roleName = roleName;
//        role = roleName.equals("ADMIN") ? ROLES.ADMIN : ROLES.USER;

        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.dateOfBirth = dateOfBirth;
    }

    @Transient
    public Integer getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    @Transient
    public void setAge(Integer age) {
        this.age = age;
    }

    public History getHistory() {
        return history;
    }

    @Transient
    public void setRole() {
        role = this.roleName.equals("ADMIN") ? ROLES.ADMIN : ROLES.USER;
    }

}