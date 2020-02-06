package com.ssafy.javer.Repository;

import com.ssafy.javer.DTO.Member;

public interface MemRepo {
	
	public void addMem(Member m);
	
	public void delMem(String uid);
	
	public void updateMem(Member m);
	
	public Member searchMem(String uid);
	
}
