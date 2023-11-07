package com.my.jpa.entity;


import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
@Builder

@Entity
@Table(name = "info_tbl")	//사용할 테이블명 : info_tbl
@SequenceGenerator(name = "info_seq_generator",
				   sequenceName = "info_seq",
				   initialValue = 1,
				   allocationSize = 1)
public class Info {
	
	@Id
	@Column(name = "info_no")	//pk역할용 컬럼명: info_no
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "info_seq_generator")
	private Long infoNo;	//주문기본번호 : 일련번호용 객체- info_seq시퀀스객체
	
	@Column(name = "info_id")	//컬럼명 : info_id
	private String infoId;
	
	@Column(name = "info_dt")	//컬럼명 : info_dt
	private Date infoDt;
	
	@OneToMany (fetch = FetchType.EAGER,
			    cascade = CascadeType.ALL,
			    mappedBy = "id.lineNo")
//	@JoinColumn(name = "line_no")
	private List<Line> lines;
}
