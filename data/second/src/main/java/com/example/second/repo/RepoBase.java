package com.example.second.repo;

import com.example.second.entity.Entity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public abstract class RepoBase {
    private final JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    protected RepoBase(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    protected <T> Optional<Entity> getQuery(T queryValue, String sql, RowMapper<Entity> rowMapper) {
        var query = jdbc.queryForObject(sql, rowMapper, queryValue);
        return Optional.of(query);
    }
}
