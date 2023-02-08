package sec04.ex01;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class boardVo {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
}
