package com.michael.ThesisHubBackend.user.dto;

import com.michael.ThesisHubBackend.user.entity.User;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Integer APM;
    private String name;
    private String surname;

    public UserDTO(User user){
        this.APM = user.getAPM();
        this.name = user.getName();
        this.surname = user.getSurname();
    }
}
