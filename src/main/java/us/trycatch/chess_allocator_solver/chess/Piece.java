package us.trycatch.chess_allocator_solver.chess;

import java.util.Hashtable;

/**
 * This enum defines the list of possible pieces.
 * 
 * @author Alberto Delso Encabo
 * @version 1.0
 */
public enum Piece {
    KING,QUEEN,BISHOP,KNIGHT,ROOK;
    
    private static Hashtable<Integer,Piece> fromOrdinalToPiece = new Hashtable<>();
    static{
    
        for(Piece piece: values()){
            fromOrdinalToPiece.put(piece.ordinal(), piece);
        }
    }
    
    /**
     * Known the pice ordinal its possible to know the associated piece
     * 
     * @param ordinal The input piece ordinal
     * @return The associated piece
     */
    public static Piece getPieceFromOrdinal(int ordinal){
        Piece out = fromOrdinalToPiece.get(ordinal);
        return out;
    }
}
