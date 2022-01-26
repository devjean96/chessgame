package chess;

import boardgame.Position;
import lombok.Getter;

@Getter
public class ChessPosition {
	
	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Erro na associacao da posicao do xadrez. Posicoes Validas: a1 at� h8");
		}
		this.column = column;
		this.row = row;
	}
	
	protected Position toPosition() {
		return new Position(ChessMatch.ROW_COLUMN - row, column - 'a');
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char) ('a' + position.getColumn()), ChessMatch.ROW_COLUMN - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
}
