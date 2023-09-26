package com.michael.ThesisHubBackend.thesis.dto;

import com.michael.ThesisHubBackend.thesis.entity.Thesis;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ThesisDTO {
    private Integer thesisId;
    private String title;
    private String description;
    private Boolean isAssigned;
    private Date creation_date;

    public ThesisDTO(Thesis thesis){
        this.thesisId = thesis.getThesisId();
        this.title = thesis.getTitle();
        this.description = thesis.getDescription();
        this.isAssigned = thesis.getIsAssigned();
        this.creation_date = thesis.getCreation_date();
    }
}
