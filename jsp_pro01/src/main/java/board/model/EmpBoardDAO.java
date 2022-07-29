package board.model;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.conn.db.DBConn;

public class EmpBoardDAO {
	private SqlSession session = null;
	private String mapper = "empBoardMapper.%s";
	
	public EmpBoardDAO() {
		this.session = DBConn.getSqlSession();
	}
	
	public int getNextSeq() {
		String mapperId = String.format(mapper, "getNextSeq");
		int seq = session.selectOne(mapperId);
		System.out.println(seq);
		return seq;
	}
	
	public boolean insertData(EmpBoardDTO data) {
		String mapperId = String.format(mapper, "insertData");
		int res = session.insert(mapperId, data);
		return res == 1 ? true : false;
	}
	
	public EmpBoardDTO selectData(int id) {
		String mapperId = String.format(mapper, "selectData");
		EmpBoardDTO res = session.selectOne(mapperId, id);
		return res;
	}
	
	public boolean updateViewCnt(EmpBoardDTO data) {
		String mapperId = String.format(mapper, "updateViewCnt");
		int res = session.update(mapperId, data);
		return res == 1 ? true : false;
	}
	
	public boolean updateLike(EmpBoardDTO data) {
		String mapperId = String.format(mapper, "updateLike");
		int res = session.update(mapperId, data);
		return res == 1 ? true : false;
	}
	
	public void commit() {
		this.session.commit();
	}
	
	public void rollback() {
		this.session.rollback();
	}
	
	public void close() {
		this.session.close();
	}
}
