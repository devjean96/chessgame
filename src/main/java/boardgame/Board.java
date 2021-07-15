package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Erro na criacao do tabuleiro: precisar adicionar pelo 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		this.pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece getPiece(int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Posicao nao existe no tabuleiro");
		}
		return pieces[row][column];
	}
	
	public Piece getPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posicao nao existe no tabuleiro");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("Ja existe peca nessa posicao " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
		
	}
	
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posicao nao existe no tabuleiro");
		}
		
		if (getPiece(position) == null) return null;
		
		Piece auxPiece = getPiece(position);
		auxPiece.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		
		return auxPiece;
	}
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && 
			   row < rows && 
			   column >= 0 && 
			   column < columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posicao nao existe no tabuleiro");
		}
		return getPiece(position) != null;
	}
	
}
