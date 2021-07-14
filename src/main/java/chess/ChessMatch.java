package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

	public final static int ROW_COLUMN = 8;
	private Board board;

	public ChessMatch() {
		board = new Board(ROW_COLUMN, ROW_COLUMN);
		initialSetup();
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
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		placeNewPiece('e', 1, new King(board, Color.BLACK));
		placeNewPiece('e', 8, new King(board, Color.WHITE));
	}
}
