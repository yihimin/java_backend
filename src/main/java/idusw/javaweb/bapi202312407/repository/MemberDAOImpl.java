package idusw.javaweb.bapi202312407.repository;

import idusw.javaweb.bapi202312407.model.Member;

import java.sql.*;
import java.util.List;

public class MemberDAOImpl extends DAOImplMysql implements MemberDAO {
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public MemberDAOImpl(){
        conn = getConnection();
    }

    @Override
    public int create(Member member) {
        return 0;
    }

    public Member read(Member member) {
        Member result = null;
        String sql = "SELECT * FROM member WHERE id = ? AND pw = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPw());
            rs = pstmt.executeQuery();

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    result = new Member();
                    result.setSeq(rs.getInt("seq"));
                    result.setId(rs.getString("id"));
                    result.setPw(rs.getString("pw"));
                    result.setName(rs.getString("name"));
                    result.setEmail(rs.getString("email"));
                    //result.setBirthday(rs.getDate("birthday"));
                    //result.setCtime(rs.getTimestamp("ctime").toLocalDateTime());
                    //result.setRtime(rs.getTimestamp("rtime").toLocalDateTime());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Member> readList() {
        return List.of();
    }

    @Override
    public int update(Member member) {
        return 0;
    }

    @Override
    public int delete(Member member) {
        return 0;
    }
}
