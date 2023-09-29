package com.michael.ThesisHubBackend.user.entity;


import com.michael.ThesisHubBackend.user.dto.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "APM")
    private Integer APM;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    public User(UserDTO userDTO){
        this.APM = userDTO.getAPM();
        this.name = userDTO.getName();
        this.surname = userDTO.getSurname();
    }
}
