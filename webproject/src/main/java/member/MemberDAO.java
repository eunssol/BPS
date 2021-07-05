package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import board.BoardVO;
import jdbc.JdbcUtil;

public class MemberDAO {
	// 싱글톤
	private static MemberDAO instance = new MemberDAO();
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		return instance;
	}
	
	
	public MemberVO selectOne(Connection conn, int memberno) {
		Statement stmt = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from member where memberno="+memberno);
			if (rs.next()) {
				vo = new MemberVO();
				vo.setMemberno(rs.getInt("memberno"));
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setRegdate(rs.getTimestamp("regdate"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(stmt);
			JdbcUtil.close(rs);
		}
		return vo;
	}
	// 아이디가 중복인지 확인
	public boolean isDuplicateId(Connection conn, String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = true;
		try {
			pstmt = conn.prepareStatement("select * from member where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = true; // 중복
			} else {
				result = false; // 중복아님
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		return result;
	}
	public int insert(Connection conn, MemberVO vo) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(
					"insert into member (id, pwd, name, regdate) values (?,password(?),?,now())");
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt);
		}
		return result;
	}
	public MemberVO login(Connection conn, String id, String pwd) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from member where id=? and pwd=password(?)");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new MemberVO();
				vo.setMemberno(rs.getInt("memberno"));
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setRegdate(rs.getTimestamp("regdate"));
			}
		} catch(Exception e) {
			
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		return vo;
	}
	public int update(Connection conn, MemberVO vo) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(
					"update member set name=?, pwd=password(?) where memberno=?");
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPwd());
			pstmt.setInt(3, vo.getMemberno());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(pstmt);
		}
		return result;
	}
	public List<MemberVO> select(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		MemberVO vo = null;
		List<MemberVO>list = new ArrayList<MemberVO>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from member ");
			
			while (rs.next()) {
				vo = new MemberVO();
				vo.setMemberno(rs.getInt("memberno"));
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setRegdate(rs.getTimestamp("regdate"));
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(stmt);
			JdbcUtil.close(rs);
		}
		return list;
	}
}
