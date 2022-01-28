package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position auxPosi = new Position(0, 0);
		
		if(getColor() == Color.WHITE) {
			
			//cima
			auxPosi.setValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(auxPosi) && !getBoard().thereIsAPiece(auxPosi)) {
				matriz[auxPosi.getRow()][auxPosi.getColumn()] = true;
			}
			
			auxPosi.setValues(position.getRow() - 2, position.getColumn());
			Position auxPosi2 = new Position(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(auxPosi) && !getBoard().thereIsAPiece(auxPosi)
					&& getBoard().positionExists(auxPosi2) && !getBoard().thereIsAPiece(auxPosi2)
					&& getMoveCount() == 0) {
				matriz[auxPosi.getRow()][auxPosi.getColumn()] = true;
			}	
			
			//diagonal
			auxPosi.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(auxPosi) && isThereOpponentPiece(auxPosi)) {
				matriz[auxPosi.getRow()][auxPosi.getColumn()] = true;
			}
			
			auxPosi.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(auxPosi) && isThereOpponentPiece(auxPosi)) {
				matriz[auxPosi.getRow()][auxPosi.getColumn()] = true;
			}
		} 
		else {
			
			//cima
			auxPosi.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(auxPosi) && !getBoard().thereIsAPiece(auxPosi)) {
				matriz[auxPosi.getRow()][auxPosi.getColumn()] = true;
			}
			
			auxPosi.setValues(position.getRow() + 2, position.getColumn());
			Position auxPosi2 = new Position(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(auxPosi) && !getBoard().thereIsAPiece(auxPosi)
					&& getBoard().positionExists(auxPosi2) && !getBoard().thereIsAPiece(auxPosi2)
					&& getMoveCount() == 0) {
				matriz[auxPosi.getRow()][auxPosi.getColumn()] = true;
			}	
			
			//diagonal
			auxPosi.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(auxPosi) && isThereOpponentPiece(auxPosi)) {
				matriz[auxPosi.getRow()][auxPosi.getColumn()] = true;
			}
			
			auxPosi.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(auxPosi) && isThereOpponentPiece(auxPosi)) {
				matriz[auxPosi.getRow()][auxPosi.getColumn()] = true;
			}
			
		}
		
		return matriz;
	}

}
