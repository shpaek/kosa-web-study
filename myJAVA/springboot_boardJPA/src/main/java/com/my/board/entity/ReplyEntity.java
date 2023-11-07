package com.my.board.entity;



import java.sql.Date;
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
@Table(name = "board_reply2")
@SequenceGenerator(
    name = "R_SEQ_GENERATOR2",
    sequenceName = "reply_seq2",
    initialValue = 1, allocationSize = 1
)
public class ReplyEntity {
    @Id
    @Column(name = "reply_no")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "R_SEQ_GENERATOR2")
    private Integer replyNo;

    @Column(name = "reply_parent_no")
    private Integer replyParentNo;
    
    @Column(name = "reply_board_no")
    private Integer replyBoardNo;

    @Column(name = "reply_content")
    private String replyContent;

    @Column(name = "reply_id")
    private String replyId;

    @Column(name = "reply_dt")
    private Date replyDt;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "reply_parent_no")
    private List<ReplyEntity> replyList;
    
//    @Transient
//    private Integer level;
    
    public void modifyReplyContent(String replyContent) {
    	this.replyContent = replyContent;
    }
}