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

    private static final String POLL_SERVICE_TABLE_NAME = "customer_order";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createPollAnswersById(Long customerId,PollQuestions pollQuestions) throws Exception {
        String sql = "INSERT INTO " + POLL_SERVICE_TABLE_NAME + " (customer_id, first_question, second_question, third_question,fourth_question) VALUES (?,?, ?, ?, ?)";
        jdbcTemplate.update(sql, pollQuestions.getCustomerId(), pollQuestions.getFirstQuestion(), pollQuestions.getSecondQuestion(), pollQuestions.getThirdQuestion(),pollQuestions.getFourthQuestion());
    }

    @Override
    public void updatePollAnswersById(PollQuestions pollQuestions) throws Exception {
        String sql = "UPDATE " + POLL_SERVICE_TABLE_NAME + " SET customer_id=?, first_question=?, second_question=?, third_question=?, fourth_question=?" +
                "WHERE id=?";
        jdbcTemplate.update(sql, pollQuestions.getFirstQuestion(), pollQuestions.getSecondQuestion(), pollQuestions.getThirdQuestion(),pollQuestions.getFourthQuestion(), pollQuestions.getCustomerId());
    }

    @Override
    public void deletePollAnswersById(Long id) throws Exception {
        String sql = "DELETE FROM " + POLL_SERVICE_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public PollQuestions getPollAnswersById(Long id) {
        String sql = "SELECT * FROM " + POLL_SERVICE_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new PollServiceMapper(), id);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }

}
