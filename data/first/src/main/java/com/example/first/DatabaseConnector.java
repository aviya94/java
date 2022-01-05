package com.example.first;

import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cglib.core.internal.Function;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;


@Setter
@Configuration
@ConfigurationProperties(prefix = "connection")
@Component
public class DatabaseConnector {
    private String jdbc;
    private String dbFile;

    @SneakyThrows
    public <T> ArrayList<T> getQueries(String sql, Function<ResultSet, T> function,String...queryValues) {
        PreparedStatement stmt = GetConnection(sql);
        ArrayList<T> result = new ArrayList<>();
             setQueryValues(stmt,queryValues);
             ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                result.add(function.apply(rs));
            }

        return result;
    }

    private PreparedStatement GetConnection(String sql) throws SQLException {
        final var connectionString = jdbc + dbFile;
        var connection = DriverManager.getConnection(connectionString);
        var stmt = connection.prepareStatement(sql);
        return stmt;
    }
    @SneakyThrows
    public <T> int insertToDatabase(String sql, String... queryValues){
        PreparedStatement stmt = GetConnection(sql);
        setQueryValues(stmt,queryValues);
        return stmt.executeUpdate();
    }
    private void setQueryValues(PreparedStatement stmt,String...queryValues) throws SQLException {
        for (int i = 0; i < queryValues.length; i++) {
            stmt.setString(i+1, queryValues[i]);
        }
    }

}
