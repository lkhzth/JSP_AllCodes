package model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {

	private int mno;
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;
}
