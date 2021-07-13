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
	
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.WHITE), new Position(2,1));
		board.placePiece(new King(board, Color.BLACK), new Position(0,4));
		board.placePiece(new King(board, Color.WHITE), new Position(7,4));
	}
}
