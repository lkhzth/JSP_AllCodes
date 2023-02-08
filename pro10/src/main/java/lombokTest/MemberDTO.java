package lombokTest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberDTO {
	private String id;
	private String name;
	private String password;
	private String email;
	
	public static void main(String[] args) {
		MemberDTO dto1 = new MemberDTO("lee","12","123","lle@");
		MemberDTO dto2 = new MemberDTO("lee","12","123","lle@");
		System.out.println(dto1.equals(dto2));
	}
}	
