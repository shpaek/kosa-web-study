package com.my.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
@Builder

@Entity
@Table(name="c_tbl") 
/**
 * 회원(작성자)
 */
public class C {
	@Id
	@Column(name="c_id")
	private String cId;      //아이디
	
	@Column(name="c_name")
	private String cName;	//이름
	
	@OneToMany //(mappedBy = "bC")
	@JoinColumn(name = "b_id")
	private List<B> bs;		//게시글들
	
}