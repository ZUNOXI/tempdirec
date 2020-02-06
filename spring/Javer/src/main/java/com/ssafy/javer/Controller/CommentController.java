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
import com.ssafy.javer.DTO.Comment_dto;
import com.ssafy.javer.Service.CommentService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins= {"*"}, maxAge=6000)
@RestController
@RequestMapping("/api/comment")
public class CommentController {
	public static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	@Autowired
	CommentService cser;
	
	@PostMapping("/commentreg")
	@ApiOperation(value="답변 등록 서비스")
	public ResponseEntity<Map<String, Object>> boardReg(@RequestBody Comment_dto comment){
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy.MM.dd HH:mm", Locale.KOREA );
		Date currentTime = new Date ();
		String date = mSimpleDateFormat.format ( currentTime );
		try {
			int insert = cser.InsertComment(comment.getBnum()
					, comment.getUid(), comment.getCcontent(), date);
			msg.put("resmsg", "succ");
			msg.put("resdata", insert);
		} catch(RuntimeException e) {
			msg.put("resmsg", "fail");
			msg.put("resdata", -1);
		}
		resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		return resEntity;
	}
	
	@GetMapping("comment")
	@ApiOperation(value="답글 조회 서비스", response=List.class)
	public ResponseEntity<Map<String, Object>> commentList(int bnum){
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
		try {
			List<Comment_dto> clist = cser.SelectListComment(bnum);
			msg.put("resmsg", "succ");
			msg.put("resdata", clist);
		} catch(RuntimeException e) {
			msg.put("resmsg", "fail");
			msg.put("resdata", -1);
		}
		resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		return resEntity;
	}
	
	@PostMapping("/commentupdate")
	@ApiOperation(value="답글 수정 서비스")
	public ResponseEntity<Map<String, Object>> commentUpdate(@RequestBody Comment_dto comment){
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
		try {
			int update = cser.UpdateComment(comment.getCnum(), comment.getBnum()
					, comment.getUid(), comment.getCcontent(), comment.getCcreation_date());
			msg.put("resmsg", "succ");
			msg.put("resdata", update);
		} catch(RuntimeException e) {
			msg.put("resmsg", "fail");
			msg.put("resdata", -1);
		}
		resEntity = new ResponseEntity<Map<String, Object>>(msg, HttpStatus.OK);
		return resEntity;
	}
	
	@PostMapping("/commentdelete")
	@ApiOperation(value="답글  삭제 서비스")
	public ResponseEntity<Map<String, Object>> commentDelete(@RequestBody Comment_dto comment){
		ResponseEntity<Map<String, Object>> resEntity = null;
		Map<String, Object> msg = new HashMap<String, Object>();
		try {
			int delete = cser.DeleteComment(comment.getCnum());
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
