package com.hd.sample_jpa_mysql_0605.dao;

import com.hd.sample_jpa_mysql_0605.dto.MemberResDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MemberDao {
    private final JdbcTemplate jdbcTemplate;
    // 전체 조회
    private static final String SELECT_ALL = "select * from member";

    public List<MemberResDto> findAll() {
        return jdbcTemplate.query(SELECT_ALL, new MemberRowMapper());
    }

    private static class MemberRowMapper implements RowMapper<MemberResDto> {
        @Override
        public MemberResDto mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new MemberResDto (
                    rs.getString("email"),
                    rs.getString("name"),
                    rs.getString("pwd"),
                    rs.getString("image"),
                    rs.getTimestamp("reg_date").toLocalDateTime()
            );
        };
    }
}
