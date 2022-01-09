package com.example.second.repo;

import com.example.second.entity.Album;
import com.example.second.entity.Artist;
import com.example.second.entity.Entity;
import com.example.second.entity.Track;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AlbumRepo extends RepoBase{
    protected AlbumRepo(JdbcTemplate jdbc) {
        super(jdbc);
    }


    public List<Artist> selectArtist(String name) {
        var sql = "select ArtistId, Name from artists where instr(Name,?)>0";
        RowMapper<Artist> toArtist = (rs, n) -> new Artist(rs.getInt(1), rs.getString(2));
        return super.getJdbc().query(sql, toArtist,name);
    }

    public List<Album> getAlbumsByArtistId(int id) {
        var sql = "select Title, AlbumId from albums where ArtistId = ?";
        RowMapper<Album> toAlbum = (rs, n) -> new Album(rs.getInt(2), rs.getString(1), id);
        return super.getJdbc().query(sql, toAlbum, id);
    }
    public List<Track> getTrackByGenreId(int id) {
        var sql = "select TrackId,name,UnitPrice from tracks where GenreId=?;";
        RowMapper<Track> toTrack = (rs, n) -> new Track(rs.getInt(1), rs.getString(2),rs.getDouble(3));
        return super.getJdbc().query(sql, toTrack, id);
    }

    public List<Track> getTracksByAlbumId (int id) {
        var sql = "select TrackId,name,UnitPrice from tracks where AlbumId=?;";
        RowMapper<Track> toTrack = (rs, n) -> new Track(rs.getInt(1), rs.getString(2),rs.getDouble(3));
        return super.getJdbc().query(sql, toTrack, id);
    }

    public Track selectTrack (int id) {
        var sql = "select TrackId,name,UnitPrice from tracks where TrackId=?";
        RowMapper<Track> toTrack = (rs, n) -> new Track(rs.getInt(1), rs.getString(2),rs.getDouble(3));
        return super.getJdbc().query(sql, toTrack, id).get(0);
    }
}
