package com.customerService.repository.mapper;

import com.customerService.model.PollQuestions;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PollServiceMapper implements RowMapper<PollQuestions> {

    @Override
    public PollQuestions mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new PollQuestions(
                rs.getLong("customer_id"),
                rs.getLong("first_question"),
                rs.getLong("second_question"),
                rs.getLong("third_question"),
                rs.getLong("fourth_question")
        );
    }
}
