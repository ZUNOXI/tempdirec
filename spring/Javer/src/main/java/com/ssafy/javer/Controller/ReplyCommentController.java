package com.ssafy.javer.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.javer.DTO.Comment_dto;
import com.ssafy.javer.DTO.ReplyComment_dto;
import com.ssafy.javer.Service.ReplyCommentService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins= {"*"}, maxAge=6000)
@RestController
@RequestMapping("/api/replycomment")
public class ReplyCommentController {
	public static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	ReplyCommentService rcser;
	
	@PostMapping("/replycommentreg")
	@ApiOperation(value="댓글 등록 서비스")
	public ResponseEntity<Map<String, Object>> replycommentReg(@RequestBody ReplyComment_dto reply){
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy.MM.dd HH:mm", Locale.KOREA );
		Date currentTime = new Date ();
		String date = mSimpleDateFormat.format ( currentTime );
		try {
			int insert = rcser.InsertReplyComment(reply.getRnum(), reply.getCnum()
					, reply.getUid(), reply.getRcontent(), date);
			msg.put("resmsg", "succ");
			msg.put("resdata", insert);
		} catch(RuntimeException e) {
			msg.put("resmsg", "fail");
			msg.put("resdata", -1);
		}
		resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		return resEntity;
	}
	
	@GetMapping("reply")
	@ApiOperation(value="답글 조회 서비스", response=List.class)
	public ResponseEntity<Map<String, Object>> replycommentList(int cnum){
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
		try {
			List<ReplyComment_dto> rlist = rcser.SelectListReplyComment(cnum);
			msg.put("resmsg", "succ");
			msg.put("resdata", rlist);
		} catch(RuntimeException e) {
			msg.put("resmsg", "fail");
			msg.put("resdata", -1);
		}
		resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		return resEntity;
	}
	
	@PostMapping("/replyupdate")
	@ApiOperation(value="답글 수정 서비스")
	public ResponseEntity<Map<String, Object>> replycommentUpdate(@RequestBody ReplyComment_dto reply){
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
		System.out.println("답글 수정 서비스입니다!!");
		System.out.println(reply);
		try {
			int update = rcser.UpdateReplyComment(reply.getRnum(), reply.getCnum()
					, reply.getUid(), reply.getRcontent(), reply.getRcreation_date());
			msg.put("resmsg", "succ");
			msg.put("resdata", update);
		} catch(RuntimeException e) {
			msg.put("resmsg", "fail");
			msg.put("resdata", -1);
		}
		resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		return resEntity;
	}
	
	@PostMapping("/replydelete")
	@ApiOperation(value="답글  삭제 서비스")
	public ResponseEntity<Map<String, Object>> replycommentDelete(@RequestBody ReplyComment_dto reply){
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
		try {
			int delete = rcser.DeleteReplyComment(reply.getRnum());
			msg.put("resmsg", "succ");
			msg.put("resdata", delete);
		} catch(RuntimeException e) {
			msg.put("resmsg", "fail");
			msg.put("resdata", -1);
		}
		resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		return resEntity;
	}
}
