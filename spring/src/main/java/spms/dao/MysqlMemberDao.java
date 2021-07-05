package spms.dao;

import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spms.vo.Member;
@Component("memberDao")
public class MysqlMemberDao implements MemberDao{
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
//	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
//		this.sqlSessionFactory = sqlSessionFactory;
//	}
	DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	public List<Member> selectList(HashMap<String, Object> paramMap) throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectList("spms.dao.MemberDao.selectList",paramMap);
	}catch (Exception e) {
		throw e;
	}finally {
		sqlSession.close();
	}
	

	}
	public int insert(Member member) throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			int count = sqlSession.insert("spms.dao.MemberDao.insert",member);
			sqlSession.commit();
			return count;
		}finally {
			sqlSession.close();
		}
		
	}
	public int delete(int no) throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int count = sqlSession.delete("spms.dao.MemberDao.delete",no);
			sqlSession.commit();
			return count;
		}finally {
			sqlSession.close();

		}
	}
		
	public Member selectOne(int no) throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectOne("spms.dao.MemberDao.selectOne",no);
		}finally {
			sqlSession.close();
		}
	}
	public int update(Member member) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
		int count = sqlSession.update("spms.dao.MemberDao.update",member);
		sqlSession.commit();
		return count;
		}finally {
			sqlSession.close();
		}
	}
	public Member exist(String email, String password) throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		HashMap<String, String> Parmmap  = new HashMap<String, String>();
		Parmmap.put("email", email);
		Parmmap.put("password", password);
		try {
			return sqlSession.selectOne("spms.dao.MemberDao.exist",Parmmap);
			
		}finally {
			sqlSession.close();
		}
	}
}

