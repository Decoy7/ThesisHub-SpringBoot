package com.michael.ThesisHubBackend.thesis.service.impl;

import com.michael.ThesisHubBackend.thesis.dto.ThesisDTO;
import com.michael.ThesisHubBackend.thesis.entity.Thesis;
import com.michael.ThesisHubBackend.thesis.repository.ThesisRepository;
import com.michael.ThesisHubBackend.thesis.service.ThesisService;
import com.michael.ThesisHubBackend.user.dto.UserDTO;
import com.michael.ThesisHubBackend.user.entity.User;
import com.michael.ThesisHubBackend.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThesisServiceImpl implements ThesisService {

    @Autowired
    private ThesisRepository thesisRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ThesisDTO> findAll() {
        List<Thesis> myThesis = thesisRepository.findAll();
        return thesisRepository.findAll().stream()
                .map(ThesisDTO::new)
                .toList();
    }

    @Override
    public ThesisDTO save(ThesisDTO thesisDTO) {
        return new ThesisDTO(thesisRepository.save(new Thesis(thesisDTO)));
    }

    @Override
    public ThesisDTO assignToUser(ThesisDTO thesisDTO,UserDTO userDTO) {
        Optional<Thesis> myThesis = thesisRepository.findByThesisId(thesisDTO.getThesisId());
        if(myThesis.isPresent()){
            myThesis.get().setIsAssigned(true);
            myThesis.get().setUser(new User(userDTO));
            return new ThesisDTO(myThesis.get());
        }
        throw new RuntimeException("Didn't find thesis with id " + thesisDTO.getThesisId());
    }


}
