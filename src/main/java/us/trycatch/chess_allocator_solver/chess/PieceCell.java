package us.trycatch.chess_allocator_solver.chess;

/**
 * PieceCell represents a cell with a piece in it.
 * 
 * @author Alberto Delso Encabo
 * @version 1.0
 */
public class PieceCell implements Cell {
    
    //The inner piece
    private Piece piece = null;
    
    /**
     * Piece cell constructor. 
     * 
     * @param piece The piece to put into this piece cell
     */
    public PieceCell(Piece piece){
     this.piece = piece;
    }
    
    /**
     * Returns the piece that this piece cell has
     * 
     * @return The inner piece
     */
    public Piece getPiece(){
     return this.piece;
    }
}
