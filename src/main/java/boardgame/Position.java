package boardgame;

import lombok.Data;
import lombok.NonNull;

@Data
public class Position {
	
	@NonNull
	private int row;
	@NonNull
	private int column;
	
	public void setValues(int row, int column) {
		this.row = row;
		this.column = column;
	}

}
