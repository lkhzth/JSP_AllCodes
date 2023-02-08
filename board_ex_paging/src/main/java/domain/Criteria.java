package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Criteria {
	
	int pageNum; // 현재페이지
	int amount; // 페이징게수물수(10)
	
	public Criteria() {
		this(1,10);
	}
	
}
