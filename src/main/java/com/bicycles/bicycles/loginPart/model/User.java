package com.bicycles.bicycles.loginPart.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "email")
    @Email(message = "*Ievadītā e-pasta adrese nav derīga")
    @NotEmpty(message = "*Lūdzu ievadīt e-pasta adresi")
    private String email;
    @Column(name = "password")
    @Length(min = 5, message = "*Parolei jābūt vismaz 5 sibolu garai")
    private String password;
    @Column(name = "name")
    @NotEmpty(message = "*Lūdzu ievadīt vārdu")
    private String name;
    @Column(name = "last_name")
    @NotEmpty(message = "*Lūdzu ievadīt uzvārdu")
    private String lastName;
    @Column(name = "active")
    private int active;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
