package com.michael.ThesisHubBackend.thesis.controller;

import com.michael.ThesisHubBackend.thesis.dto.ThesisDTO;
import com.michael.ThesisHubBackend.thesis.service.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/thesis")
public class ThesisController {
    @Autowired
    private ThesisService thesisService;

    @GetMapping("")
    @PreAuthorize("hasRole('Admin') OR hasRole('Lecturer') OR hasRole('Student')")
    public List<ThesisDTO> findAll(){
        return thesisService.findAll();
    }

    @PostMapping("")
    @PreAuthorize("hasRole('Admin') OR hasRole('Lecturer')")
    public ThesisDTO create(@RequestBody ThesisDTO thesisDTO){
        return thesisService.save(thesisDTO);
    }
}
