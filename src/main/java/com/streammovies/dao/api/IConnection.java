package com.streammovies.dao.api;

import org.springframework.stereotype.Repository;

import java.sql.Connection;

public interface IConnection {
    public Connection getConnetion();
}
