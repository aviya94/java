package com.example.second.data;

import com.example.second.entity.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class StoreRepository {
    private final JdbcTemplate jdbc;

    public StoreRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Optional<Entity> getUser(String id) {
        var sql = "select FirstName||' '||LastName as name,Email,City from customers where CustomerId=?";
        RowMapper<Entity> toCustomer = (rs, n) -> new Customer(rs.getString(1), rs.getString(2), rs.getString(3));
        return getQuery(id, sql, toCustomer);
    }

    public Optional<Entity> getAlbumsByArtistId(int id) {
        var sql = "select AlbumId,Title from albums where ArtistId=?";
        RowMapper<Entity> toAlbum = (rs, n) -> new Album(rs.getInt(1), rs.getString(2),id);
        return getQuery(id, sql, toAlbum);
    }

    public Optional<Entity> selectArtist(String name) {
        var sql = "select ArtistId, Name from artists where Name like '%?%'";
        RowMapper<Entity> toArtist = (rs, n) -> new Artist(rs.getInt(1), rs.getString(2));
        return getQuery(name, sql, toArtist);
    }

    public Optional<Entity> getTracksByAlbumId (int id) {
        var sql = "select TrackId,name,UnitPrice from tracks where AlbumId=?;";
        RowMapper<Entity> toTrack = (rs, n) -> new Track(rs.getInt(1), rs.getString(2),rs.getDouble(3));
        return getQuery(id, sql, toTrack);
    }

    public Optional<Entity> selectTrack (int id) {
        var sql = "select TrackId,name,UnitPrice from tracks where TrackId=?";
        RowMapper<Entity> toTrack = (rs, n) -> new Track(rs.getInt(1), rs.getString(2),rs.getDouble(3));
        return getQuery(id, sql, toTrack);
    }

    private<T> Optional<Entity> getQuery(T queryValue, String sql, RowMapper<Entity> rowMapper) {
        var query = jdbc.queryForObject(sql, rowMapper, queryValue);
        return Optional.of(query);
    }
}