package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece piece = (ChessPiece) getBoard().getPiece(position);
		return piece == null || piece.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position pos = new Position(0, 0);

		// cima
		pos.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(pos) && canMove(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
		}

		// baixo
		pos.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(pos) && canMove(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
		}

		// esquerda
		pos.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
		}

		// direita
		pos.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
		}

		// noroeste
		pos.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
		}

		// nordeste
		pos.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
		}

		// sudoeste
		pos.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
		}
		
		// sudeste
		pos.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			matriz[pos.getRow()][pos.getColumn()] = true;
		}

		return matriz;
	}

}
