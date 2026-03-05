package org.example.portfoliotracker.repository;

import org.example.portfoliotracker.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final RowMapper<User> userMapper = ((rs, rowNum) -> {
       User u = new User();
       u.setUserId(rs.getLong("userId"));
       u.setUsername(rs.getString("username"));
       u.setEmail(rs.getString("email"));
       return u;
    });

    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbc.query(sql, userMapper);
    }

    public User findById(Long id) {
        String sql = "SELECT * FROM users WHERE userId = ?";
        return jdbc.queryForObject(sql, userMapper, id);
    }

    public int create(User user) {
        String sql = "INSERT INTO users (username, email) VALUES (?, ?)";
        return jdbc.update(sql, user.getUsername(), user.getEmail());
    }

    public int update(User user) {
        String sql = "UPDATE users SET username = ?, email = ? WHERE userId = ?";
        return jdbc.update(sql, user.getUsername(), user.getEmail(), user.getUserId());
    }

    public int deleteById(Long id) {
        String sql = "DELETE FROM users WHERE userId = ?";
        return jdbc.update(sql, id);
    }
}
