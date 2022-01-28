package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece{

	public Bishop(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "B";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position auxPosi = new Position(0,0);
		
		//noroeste
		auxPosi.setValues(position.getRow() - 1, position.getColumn() - 1);
		while (getBoard().positionExists(auxPosi) && !getBoard().thereIsAPiece(auxPosi)) {
			matriz[auxPosi.getRow()][auxPosi.getColumn()] = true;
			auxPosi.setValues(auxPosi.getRow() - 1, auxPosi.getColumn() - 1);
		}
		if (getBoard().positionExists(auxPosi) && isThereOpponentPiece(auxPosi))
			matriz[auxPosi.getRow()][auxPosi.getColumn()] = true;
		
		//nordeste
		auxPosi.setValues(position.getRow() - 1, position.getColumn() + 1);
		while (getBoard().positionExists(auxPosi) && !getBoard().thereIsAPiece(auxPosi)) {
			matriz[auxPosi.getRow()][auxPosi.getColumn()] = true;
			auxPosi.setValues(auxPosi.getRow() - 1, auxPosi.getColumn() + 1);
		}
		if (getBoard().positionExists(auxPosi) && isThereOpponentPiece(auxPosi))
			matriz[auxPosi.getRow()][auxPosi.getColumn()] = true;
		
		//sudeste
		auxPosi.setValues(position.getRow() + 1, position.getColumn() + 1);
		while (getBoard().positionExists(auxPosi) && !getBoard().thereIsAPiece(auxPosi)) {
			matriz[auxPosi.getRow()][auxPosi.getColumn()] = true;
			auxPosi.setValues(auxPosi.getRow() + 1, auxPosi.getColumn() + 1);
		}
		if (getBoard().positionExists(auxPosi) && isThereOpponentPiece(auxPosi))
			matriz[auxPosi.getRow()][auxPosi.getColumn()] = true;
		
		//sudoeste
		auxPosi.setValues(position.getRow() + 1, position.getColumn() - 1);
		while (getBoard().positionExists(auxPosi) && !getBoard().thereIsAPiece(auxPosi)) {
			matriz[auxPosi.getRow()][auxPosi.getColumn()] = true;
			auxPosi.setValues(auxPosi.getRow() + 1, auxPosi.getColumn() - 1);
		}
		if (getBoard().positionExists(auxPosi) && isThereOpponentPiece(auxPosi))
			matriz[auxPosi.getRow()][auxPosi.getColumn()] = true;
		
		return matriz;
	}

}
