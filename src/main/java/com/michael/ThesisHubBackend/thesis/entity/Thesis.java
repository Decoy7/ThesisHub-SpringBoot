package com.michael.ThesisHubBackend.thesis.entity;

import com.michael.ThesisHubBackend.thesis.dto.ThesisDTO;
import com.michael.ThesisHubBackend.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "thesis")
public class Thesis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "thesis_id")
    private Integer thesisId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "assigned")
    private Boolean isAssigned;

    @Column(name = "creation_date")
    private Date creation_date;

    @OneToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "assigned_user", referencedColumnName = "id")
    private User user;

    public Thesis(ThesisDTO thesisDTO){
        this.thesisId = thesisDTO.getThesisId();
        this.title = thesisDTO.getTitle();
        this.description = thesisDTO.getDescription();
        this.isAssigned = thesisDTO.getIsAssigned();
        this.creation_date = thesisDTO.getCreation_date();
    }
}
