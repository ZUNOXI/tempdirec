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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.javer.DTO.Board_dto;
import com.ssafy.javer.DTO.ReplyBoard_dto;
import com.ssafy.javer.Service.ReplyBoardService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins= {"*"}, maxAge=6000)
@RestController
@RequestMapping("/api/replyboard")
public class ReplyBoardController {
	public static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	ReplyBoardService rbser;
	
	@PostMapping("/replyreg")
	@ApiOperation(value="댓글 등록 서비스")
	public ResponseEntity<Map<String, Object>> replyboardReg(@RequestBody ReplyBoard_dto reply){
		System.out.println("우하하하ㅏ");
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy.MM.dd HH:mm", Locale.KOREA );
		Date currentTime = new Date ();
		String date = mSimpleDateFormat.format ( currentTime );
		try {
			System.out.println(reply);
			int insert = rbser.InsertReplyBoard(reply.getBnum()
					, reply.getUid(), reply.getRcontent(), date);
			msg.put("resmsg", "succ");
			msg.put("resdata", insert);
		} catch(RuntimeException e) {
			e.printStackTrace();
			msg.put("resmsg", "fail");
			msg.put("resdata", -1);
		}
		resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		return resEntity;
	}
	
	@GetMapping("reply")
	@ApiOperation(value="댓글 조회 서비스", response=List.class)
	public ResponseEntity<Map<String, Object>> replyboardList(int bnum){
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
		try {
			List<ReplyBoard_dto> rlist = rbser.SelectListReplyBoard(bnum);
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
	@ApiOperation(value="댓글 수정 서비스")
	public ResponseEntity<Map<String, Object>> replyboardUpdate(@RequestBody ReplyBoard_dto reply){
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
		try {
			int update = rbser.UpdateReplyBoard(reply.getRnum(), reply.getBnum()
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
	@ApiOperation(value="댓글  삭제 서비스")
	public ResponseEntity<Map<String, Object>> replyboardDelete(@RequestBody ReplyBoard_dto reply){
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
		try {
			int delete = rbser.DeleteReplyBoard(reply.getRnum());
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
