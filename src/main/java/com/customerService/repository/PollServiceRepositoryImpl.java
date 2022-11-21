package com.customerService.repository;

import com.customerService.model.PollQuestions;
import com.customerService.repository.mapper.PollServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PollServiceRepositoryImpl implements PollServiceRepository {

    private static final String POLL_SERVICE_TABLE_NAME = "poll_service";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createPollAnswersById(Long customerId,PollQuestions pollQuestions) throws Exception {
        String sql = "INSERT INTO " + POLL_SERVICE_TABLE_NAME + " (customer_id, first_question, second_question, third_question,fourth_question) VALUES (?,?, ?, ?, ?)";
        jdbcTemplate.update(sql, pollQuestions.getCustomerId(), pollQuestions.getFirstQuestion(), pollQuestions.getSecondQuestion(), pollQuestions.getThirdQuestion(),pollQuestions.getFourthQuestion());
    }

    @Override
    public void updatePollAnswersById(PollQuestions pollQuestions) throws Exception {
        String sql = "UPDATE " + POLL_SERVICE_TABLE_NAME + " SET first_question=?, second_question=?, third_question=?, fourth_question=?" +
                "WHERE customer_id=?";
        jdbcTemplate.update(sql, pollQuestions.getFirstQuestion(), pollQuestions.getSecondQuestion(), pollQuestions.getThirdQuestion(),pollQuestions.getFourthQuestion(), pollQuestions.getCustomerId());
    }

    @Override
    public void deletePollAnswersById(Long customer_id) {
        String sql = "DELETE FROM " + POLL_SERVICE_TABLE_NAME + " WHERE customer_id=?";
        jdbcTemplate.update(sql, customer_id);
    }

    @Override
    public PollQuestions getPollAnswersById(Long customer_id) {
        String sql = "SELECT * FROM " + POLL_SERVICE_TABLE_NAME + " WHERE customer_id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new PollServiceMapper(), customer_id);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }

}
