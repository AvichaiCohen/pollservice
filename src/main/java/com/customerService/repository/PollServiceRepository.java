package com.customerService.repository;

import com.customerService.model.PollQuestions;

import java.util.List;

public interface PollServiceRepository {
    void createPollAnswersById(Long customerId,PollQuestions pollQuestions) throws Exception;
    void updatePollAnswersById(PollQuestions pollQuestions) throws Exception;
    void deletePollAnswersById(Long customerId);
    PollQuestions getPollAnswersById(Long customerId);
}
