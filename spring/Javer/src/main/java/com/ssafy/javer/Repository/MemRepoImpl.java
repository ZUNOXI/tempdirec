package com.ssafy.javer.Repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.javer.DTO.Member;
@Repository("MemMybatisRepo")
public class MemRepoImpl implements MemRepo{
	
	@Autowired
	private SqlSession session;
	
	@Override
	public void addMem(Member m) {
		// TODO Auto-generated method stub
		session.insert("sql.member.insertmember",m);
	}

	@Override
	public void delMem(String uid) {
		// TODO Auto-generated method stub
		session.delete("sql.member.deletemember", uid);
	}

	@Override
	public void updateMem(Member m) {
		// TODO Auto-generated method stub
		session.update("sql.member.updatemember", m);
	}

	@Override
	public Member searchMem(String uid) {
		// TODO Auto-generated method stub
		return session.selectOne("sql.member.selectmember", uid);
	}

}
