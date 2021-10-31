package com.streammovies.dao.api;

import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public interface IStatementMapping {
    void mapping(PreparedStatement preparedStatement, Object... member) throws SQLException;
}
