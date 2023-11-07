package com.my.board.entity;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicInsert
@Entity
@Table(name = "board2")
@SequenceGenerator(
    name = "B_SEQ_GENERATOR2",
    sequenceName = "board_seq2",
    initialValue = 1, allocationSize = 1
)
public class BoardEntity {
    @Id
    @Column(name = "board_no")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "B_SEQ_GENERATOR2")
    private Integer boardNo;

    @Column(name = "board_title")
    private String boardTitle;

//    @NotEmpty(message = "글내용은 반드시 입력하세요")
//    @Size(max = 10, message = "글내용은 최대10자리까지만 가능합니다")
    @Column(name = "board_content")
    private String boardContent;

//    @NotEmpty(message = "글작성자아이디는 반드시 입력하세요")
    @Column(name = "board_id")
    private String boardId;

    @Column(name = "board_dt")
//    @ColumnDefault(value = "SYSDATE")
    private Date boardDt;

    @OneToMany(fetch = FetchType.EAGER,  //글 검색할 때 답글들까지 같이 검색하려면
    		   cascade = CascadeType.REMOVE)
    @JoinColumn(name = "reply_board_no")
    @Builder.Default
    private List<ReplyEntity> replies = new ArrayList<>();
    
    @Transient
    @Builder.Default
    private Integer replyCnt = 0; //답글수
    
    public void modifyBoardTitle(String boardTitle) {
    	this.boardTitle = boardTitle;
    }
    
    public void modifyBoardContent(String boardContent) {
    	this.boardContent = boardContent;
    }
    
    public int getReplyCnt() {
    	//return this.replyCnt;
    	return replies.size();
    }
}