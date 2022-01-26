package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

	public final static int ROW_COLUMN = 8;
	private Board board;
	private int turn;
	private Color currentPlayer;
	private boolean check;

	private List<Piece> piecesBoard = new ArrayList<>();
	private List<Piece> capturedPieces = new ArrayList<>();

	public ChessMatch() {
		board = new Board(ROW_COLUMN, ROW_COLUMN);
		turn = 1;
		currentPlayer = Color.WHITE;
		initialSetup();
	}

	public int getTurn() {
		return turn;
	}

	public Color getCurrentPlayer() {
		return currentPlayer;
	}
	
	public boolean getCheck() {
		return check;
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

	public boolean[][] possibleMoves(ChessPosition sourcePosition) {
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);

		return board.getPiece(position).possibleMoves();
	}

	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetposition) {
		Position source = sourcePosition.toPosition();
		Position target = targetposition.toPosition();

		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);
		
		if (testCheck(currentPlayer)) {
			undoMove(source, target, capturedPiece);
			throw new ChessException("Voce nao pode se colocar em CHECK");
		}
		
		check = (testCheck(getOpponent(currentPlayer))) ? true : false;

		nextTurn();

		return (ChessPiece) capturedPiece;
	}

	private Piece makeMove(Position source, Position target) {
		Piece piece = board.removePiece(source);
		Piece capturePiece = board.removePiece(target);
		board.placePiece(piece, target);

		if (capturePiece != null) {
			piecesBoard.remove(capturePiece);
			capturedPieces.add(capturePiece);
		}

		return capturePiece;
	}

	private void undoMove(Position source, Position target, Piece capturedPiece) {
		Piece pieceTarget = board.removePiece(target);
		board.placePiece(pieceTarget, source);

		if (capturedPiece != null) {
			board.placePiece(capturedPiece, target);
			capturedPieces.remove(capturedPiece);
			piecesBoard.add(capturedPiece);
		}

	}

	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("Nao existe peca na posicao de origem");
		}
		if (currentPlayer != ((ChessPiece) board.getPiece(position)).getColor()) {
			throw new ChessException("Nao eh possivel mover uma peca adversaria");
		}
		if (!board.getPiece(position).isThereAnyPossibleMove()) {
			throw new ChessException("Nao existe movimento possivel para a peca");
		}
	}

	private void validateTargetPosition(Position source, Position target) {
		if (!board.getPiece(source).possivleMove(target)) {
			throw new ChessException("A peca escolhida nao pode ser movida para a posicao de destino");
		}
	}

	private void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}

	private Color getOpponent(Color color) {
		return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}

	private ChessPiece getKing(Color color) {
		List<Piece> list = piecesBoard.stream()
				                      .filter(x -> ((ChessPiece) x).getColor() == color)
				                      .collect(Collectors.toList());
		for (Piece p : list) {
			if (p instanceof King) {
				return (ChessPiece) p;
			}
		}
		throw new IllegalStateException("Nao existe Rei " + color + " no tabuleiro");
	}

	private boolean testCheck(Color color) {
		Position kingPosition = getKing(color).getChessPosition().toPosition();
		List<Piece> opponentPieces = piecesBoard.stream()
				                                .filter(x -> ((ChessPiece) x).getColor() == getOpponent(color))
				                                .collect(Collectors.toList());
		for (Piece p : opponentPieces) {
			boolean[][] matriz = p.possibleMoves();
			if(matriz[kingPosition.getRow()][kingPosition.getColumn()]) {
				return true;
			}
		}
		
		return false;
	}

	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
		piecesBoard.add(piece);
	}

	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
		placeNewPiece('c', 2, new Rook(board, Color.WHITE));
		placeNewPiece('d', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 1, new Rook(board, Color.WHITE));
		placeNewPiece('d', 1, new King(board, Color.WHITE));

		placeNewPiece('c', 7, new Rook(board, Color.BLACK));
		placeNewPiece('c', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 7, new Rook(board, Color.BLACK));
		placeNewPiece('e', 7, new Rook(board, Color.BLACK));
		placeNewPiece('e', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
}
