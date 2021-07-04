package chess;

import boardgame.Board;

public class ChessMatch {

	public final static int ROW_COLUMN = 8;
	private Board board;

	public ChessMatch() {
		board = new Board(ROW_COLUMN, ROW_COLUMN);
	}

	public ChessPiece[][] getPieces() {
		ChessPiece[][] matriz = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				matriz[i][j] = (ChessPiece) board.getPiece(i, j);
			}
		}
		return matriz;
	}
}
