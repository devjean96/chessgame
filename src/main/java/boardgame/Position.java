package boardgame;

import lombok.Data;
import lombok.NonNull;

@Data
public class Position {
	
	@NonNull
	private int row;
	@NonNull
	private int column;

}
