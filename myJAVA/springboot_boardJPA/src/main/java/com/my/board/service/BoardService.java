package com.my.board.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.board.dao.BoardRepository;
import com.my.board.dao.ReplyRepository;
import com.my.board.dto.Board;
import com.my.board.dto.Reply;
import com.my.board.entity.BoardEntity;
import com.my.board.entity.ReplyEntity;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;

@Service
public class BoardService {
	@Autowired
	private BoardRepository br;
	
	@Autowired
	private ReplyRepository rr;
	
	public Board buildBoardDTO(Object[] objArr) {
		Board board = Board.builder()
				.boardNo(((BigDecimal)objArr[0]).intValue())
				.boardContent((String)objArr[1])
				.boardDt((Date)objArr[2])
				.boardId((String)objArr[3])
				.boardTitle((String)objArr[4])
				.build();
		return board;
	}
	
	
	public List<Board> findAll() throws FindException {
		List<BoardEntity> boardList = br.selectAll();
		List<Board> boards = new ArrayList<>();
		for(BoardEntity b: boardList) {
			
			Board board = findByBoardNo(b.getBoardNo());
			
			List<Reply> replyList = board.getReplies();
			board.setReplies(replyList);
			boards.add(board);
		}
		return boards;
	}

	public Board findByBoardNo(int boardNo) throws FindException {
		List<Object[]> list=br.selectByBoardNo(boardNo);
		List<Reply> replylist=new ArrayList<>();
		try {
			Board board=buildBoardDTO(list.get(0));
			if(list.get(0)[5]==null) return board;
			for(Object[] objArr : list) {
				Reply reply;
				//System.out.println(objArr[5].getClass().getName());
				reply = Reply.builder()
						.level(((BigDecimal)objArr[5]).intValue())
						.replyNo(((BigDecimal)objArr[6]).intValue())
						.replyBoardNo(((BigDecimal)objArr[7]).intValue())
						.replyContent((String)objArr[8])
						.replyDt((Date)objArr[9])
						.replyId((String)objArr[10])
						.build();
				if(objArr[11]==null) reply.setReplyParentNo(null);
				else reply.setReplyParentNo(Integer.valueOf(String.valueOf(objArr[11])));
				replylist.add(reply);
			}
			board.setReplies(replylist);
			board.setReplycnt(replylist.size());
			return board;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public void write(Board board) throws AddException {
		BoardEntity be = BoardEntity
						.builder()
						.boardContent(board.getBoardContent())
						.boardId(board.getBoardId())
						.boardTitle(board.getBoardTitle())
						.boardDt(new java.sql.Date(new java.util.Date().getTime()))
						.build();
						
		br.save(be);
		
		
	}
	
	public void modify(Board board) throws ModifyException, FindException {
		Board b = findByBoardNo(board.getBoardNo());
		
		BoardEntity be = BoardEntity
				.builder()
				.boardContent(board.getBoardContent())
				.boardId(board.getBoardId())
				.boardNo(board.getBoardNo())
				.boardTitle(b.getBoardTitle())
				.boardDt(new java.sql.Date(new java.util.Date().getTime()))
				.build();
		br.save(be);
	}
	
	public void remove(int boardNo) throws RemoveException {
		br.deleteById(boardNo);
	}
	
	public void writeReply(Reply reply) throws AddException {
		ReplyEntity re = ReplyEntity
						 .builder()
						 .replyBoardNo(reply.getReplyBoardNo())
						 .replyContent(reply.getReplyContent())
						 .replyId(reply.getReplyId())
						 .replyParentNo(reply.getReplyParentNo())
						 .replyDt(new java.sql.Date(new java.util.Date().getTime()))
						 .build();
		rr.save(re);
	}
	
	public void modifyReply(Reply reply) throws ModifyException, FindException {
		ReplyEntity r = rr.selectByReplyNo(reply.getReplyNo());
		
		ReplyEntity re = ReplyEntity
				 .builder()
				 .replyContent(reply.getReplyContent())
				 .replyNo(reply.getReplyNo())
				 .replyBoardNo(r.getReplyBoardNo())
				 .replyId(r.getReplyId())
				 .replyParentNo(r.getReplyParentNo())
				 .replyDt(new java.sql.Date(new java.util.Date().getTime()))
				 .build();
		rr.save(re);
	}
	
	public void removeReply(int replyNo) throws RemoveException {
		rr.deleteById(replyNo);
	}
}
