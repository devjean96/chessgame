package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{

	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "R";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position auxPosi = new Position(0,0);
		
		//cima
		auxPosi.setValues(position.getRow() - 1, position.getColumn());
		while (getBoard().positionExists(auxPosi) && !getBoard().thereIsAPiece(auxPosi)) {
			matriz[auxPosi.getRow()][auxPosi.getColumn()] = true;
			auxPosi.setRow(auxPosi.getRow() - 1);
		}
		if (getBoard().positionExists(auxPosi) && isThereOpponentPiece(auxPosi))
			matriz[auxPosi.getRow()][auxPosi.getColumn()] = true;
		
		//esquerda
		auxPosi.setValues(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExists(auxPosi) && !getBoard().thereIsAPiece(auxPosi)) {
			matriz[auxPosi.getRow()][auxPosi.getColumn()] = true;
			auxPosi.setColumn(auxPosi.getColumn() - 1);
		}
		if (getBoard().positionExists(auxPosi) && isThereOpponentPiece(auxPosi))
			matriz[auxPosi.getRow()][auxPosi.getColumn()] = true;
		
		//direita
		auxPosi.setValues(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExists(auxPosi) && !getBoard().thereIsAPiece(auxPosi)) {
			matriz[auxPosi.getRow()][auxPosi.getColumn()] = true;
			auxPosi.setColumn(auxPosi.getColumn() + 1);
		}
		if (getBoard().positionExists(auxPosi) && isThereOpponentPiece(auxPosi))
			matriz[auxPosi.getRow()][auxPosi.getColumn()] = true;
		
		//baixo
		auxPosi.setValues(position.getRow() + 1, position.getColumn());
		while (getBoard().positionExists(auxPosi) && !getBoard().thereIsAPiece(auxPosi)) {
			matriz[auxPosi.getRow()][auxPosi.getColumn()] = true;
			auxPosi.setRow(auxPosi.getRow() + 1);
		}
		if (getBoard().positionExists(auxPosi) && isThereOpponentPiece(auxPosi))
			matriz[auxPosi.getRow()][auxPosi.getColumn()] = true;
		
		return matriz;
	}

}
