package com.my.board.control;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.board.dto.Board;
import com.my.board.dto.Reply;
import com.my.board.service.BoardService;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;

@RestController
@RequestMapping("/board")
public class BoardController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public List<Board> list() throws FindException {
		return service.findAll();
	}
	
	@GetMapping("/{boardNo}")	// /board/1, /board/2
	public Board info(@PathVariable int boardNo) throws FindException {
		return service.findByBoardNo(boardNo);
	}
	
	//POST	/board
	@PostMapping(value = "", produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> write(@RequestBody Board board) throws AddException {
		try {
			service.write(board);
//			return "글쓰기" + board;

			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "text/html;charset=UTF-8");
			return new ResponseEntity<>("작성완료",
										headers,
										HttpStatus.OK);
		} catch (AddException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	//PUT	/board/1
	@PutMapping(value = "/{boardNo}", produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> modify(@PathVariable int boardNo, @RequestBody Board board)
								throws ModifyException {
		board.setBoardNo(boardNo);

			service.modify(board);
//			return "글수정" + board;

			return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//DELETE	/board/1
	@DeleteMapping(value = "/{boardNo}", produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> remove(@PathVariable int boardNo) throws RemoveException {
			service.remove(boardNo);
//			return "글삭제" + boardNo;

			return new ResponseEntity<>(HttpStatus.OK);
	}
		
	//POST    /board/reply/1
	//POST   /board/reply/1/9
	@PostMapping(value={"reply/{boardNo}/{parentNo}", "reply/{boardNo}"})
	public ResponseEntity<?> writeReply(@PathVariable int boardNo,
			@PathVariable(name = "parentNo") Optional<Integer> optParentNo,
			@RequestBody Reply reply) throws AddException {
		if(!optParentNo.isPresent()) { //parentNo가 없는 경우 --일반 답글쓰기
			
		}else { //parentNo가 있는 경우 --답글의 답글쓰기
			Integer parentNo = optParentNo.get();
			reply.setReplyParentNo(parentNo);
		}
		reply.setReplyBoardNo(boardNo);
		service.writeReply(reply);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//PUT     /board/reply/15
	@PutMapping(value="reply/{replyNo}")
	public ResponseEntity<?> modifyReply(@PathVariable int replyNo,
										 @RequestBody Reply reply) throws ModifyException {
//		System.out.println(replyNo);

		reply.setReplyNo(replyNo);
		service.modifyReply(reply);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//DELETE  /board/reply/9
	@DeleteMapping(value="reply/{replyNo}")
	public ResponseEntity<?> removeReply(@PathVariable int replyNo) throws RemoveException {
//		System.out.println(replyNo);
		service.removeReply(replyNo);
//		log.debug("DEBUG 메시지");
//		log.info("INFO 메시지");
//		log.warn("WARN 메시지");
//		log.error("ERROR 메시지");
		return new ResponseEntity<>(HttpStatus.OK);
	}
}