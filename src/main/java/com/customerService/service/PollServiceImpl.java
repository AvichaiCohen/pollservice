package com.customerService.service;

import com.customerService.model.PollQuestions;
import com.customerService.repository.PollServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PollServiceImpl implements PollService {

    @Autowired
    PollServiceRepository pollServiceRepository;

    @Override
    public void createAnswersById(Long id, PollQuestions pollQuestions) throws Exception{
        try {

        }
            catch
         (Exception e) {
        throw new Exception(e);
        }
        pollServiceRepository.createPollAnswersById(pollQuestions.getCustomerId(),pollQuestions);

    }

    @Override
    public void updateAnswersById(Long pollServiceId, PollQuestions pollQuestions) throws Exception {
        pollServiceRepository.updatePollAnswersById(pollQuestions);
    }

    @Override
    public void deleteAnswersById(Long id) throws Exception {
        pollServiceRepository.deletePollAnswersById(id);

    }

    @Override
    public PollQuestions getQuestionsById(Long id) {
        return pollServiceRepository.getPollAnswersById(id);
    }
}
