package com.michael.ThesisHubBackend.user.service.impl;

import com.michael.ThesisHubBackend.thesis.entity.Thesis;
import com.michael.ThesisHubBackend.thesis.repository.ThesisRepository;
import com.michael.ThesisHubBackend.user.repository.UserRepository;
import com.michael.ThesisHubBackend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ThesisRepository thesisRepository;
    @Override
    public void requestAssignmentOfThesis() {
        Optional<Thesis> myThesis = thesisRepository.findById(1);
    }
}
