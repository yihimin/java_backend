package idusw.javaweb.bapi202312407.repository;

import idusw.javaweb.bapi202312407.model.Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl extends DAOImplMysql implements MemberDAO {
    @Override
    public int create(Member member) {
        return 0; // 구현 필요
    }

    @Override
    public Member read(Member member) {
        Member result = null;
        String sql = "SELECT * FROM member WHERE id = ? AND pw = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPw());
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    result = new Member();
                    result.setSeq(rs.getInt("seq"));
                    result.setId(rs.getString("id"));
                    result.setPw(rs.getString("pw"));
                    result.setName(rs.getString("name"));
                    result.setEmail(rs.getString("email"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Member> readList() {
        List<Member> memberList = new ArrayList<>();
        String sql = "SELECT * FROM member";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Member retMember = new Member();
                retMember.setSeq(rs.getInt("seq"));
                retMember.setId(rs.getString("id"));
                retMember.setPw(rs.getString("pw"));
                retMember.setName(rs.getString("name"));
                retMember.setEmail(rs.getString("email"));
                memberList.add(retMember);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return memberList;
    }

    @Override
    public int update(Member member) {
        return 0; // 구현 필요
    }

    @Override
    public int delete(Member member) {
        return 0; // 구현 필요
    }
}
