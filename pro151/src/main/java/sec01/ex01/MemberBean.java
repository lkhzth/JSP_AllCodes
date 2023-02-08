package sec01.ex01;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberBean {
	
	private int mno;
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;
	
	
	
}
