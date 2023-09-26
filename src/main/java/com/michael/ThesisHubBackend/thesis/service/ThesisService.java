package com.michael.ThesisHubBackend.thesis.service;

import com.michael.ThesisHubBackend.thesis.dto.ThesisDTO;
import com.michael.ThesisHubBackend.user.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ThesisService {
    List<ThesisDTO> findAll();

    ThesisDTO save(ThesisDTO thesisDTO);

    ThesisDTO assignToUser(ThesisDTO thesisDTO,UserDTO userDTO);
}
