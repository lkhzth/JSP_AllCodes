package com.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberVO {

	private int mno;
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;
}
