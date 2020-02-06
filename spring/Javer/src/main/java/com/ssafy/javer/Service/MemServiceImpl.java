package com.ssafy.javer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ssafy.javer.DTO.Member;
import com.ssafy.javer.Repository.MemRepo;
@Service("MemServiceImpl")
public class MemServiceImpl implements MemService{

	@Autowired
	@Qualifier("MemMybatisRepo")
	private MemRepo repo;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void addMem(String uid, String upw, String uname, String unickname, String uphonenum,
			String uemail, String uaddress, String ufavor_ctg, String uprofilephoto, String ubirth_date,
			String ujoin_date, String rcmd_blst) {
		// TODO Auto-generated method stub
		repo.addMem(new Member(uid,upw,uname,unickname,uphonenum,
			uemail,uaddress,ufavor_ctg,uprofilephoto,ubirth_date,
			ujoin_date,rcmd_blst));
		
		System.out.println(uemail);
		// 회원 가입이 완료되었음을 메일로 전송하는 메소드
		SimpleMailMessage mail =  new SimpleMailMessage();
		mail.setTo(uemail);
		mail.setFrom("pjtssafytest@gmail.com");
		mail.setSubject("Javer 회원 가입이 완료되었습니다.");
		mail.setText("이제 탈퇴할 수 없습니다. ^0^");
		
		javaMailSender.send(mail);
		
	}

	@Override
	public void delMem(String uid) {
		// TODO Auto-generated method stub
		repo.delMem(uid);
	}

	@Override
	public void updateMem(String uid, String upw, String uname, String unickname, String uphonenum,
			String uemail, String uaddress, String ufavor_ctg, String uprofilephoto, String ubirth_date,
			String ujoin_date, String rcmd_blst) {
		// TODO Auto-generated method stub
		repo.updateMem(new Member(uid,upw,uname,unickname,uphonenum,
			uemail,uaddress,ufavor_ctg,uprofilephoto,ubirth_date,
			ujoin_date,rcmd_blst));
	}

	@Override
	public Member searchMem(String uid) {
		// TODO Auto-generated method stub
		return repo.searchMem(uid);
	}

	@Override
	public void sendMail(Member mem) throws MailException{
		// TODO Auto-generated method stub
		SimpleMailMessage mail =  new SimpleMailMessage();
		mail.setTo(mem.getUemail());
		mail.setFrom("pjtSSafyTest@gmail.com");
		mail.setSubject("pjtSSAFY 인증 메일입니당 헤헷");
		mail.setText("오 잘 전송되어버렸네~~!!! 에헿");
		
		javaMailSender.send(mail);
	}

}
