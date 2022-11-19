package com.customerService.service;

import com.customerService.model.PollQuestions;

public interface PollService {
    PollQuestions getQuestionsById(Long id);

    void createAnswersById(Long id, PollQuestions pollQuestions) throws Exception;

    void updateAnswersById(Long pollServiceId, PollQuestions pollQuestions) throws Exception;
    void deleteAnswersById(Long id) throws Exception;

}
