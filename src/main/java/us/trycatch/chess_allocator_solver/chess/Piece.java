/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package us.trycatch.chess_allocator_solver.chess;

import java.util.Hashtable;

/**
 *
 * @author albertodelso
 */
public enum Piece {
    KING,QUEEN,BISHOP,KNIGHT,ROOK;
    
    private static Hashtable<Integer,Piece> fromOrdinalToPiece = new Hashtable<>();
    static{
    
        for(Piece piece: values()){
            fromOrdinalToPiece.put(piece.ordinal(), piece);
        }
    }
    
    public static Piece getPieceFromOrdinal(int ordinal){
        Piece out = fromOrdinalToPiece.get(ordinal);
        return out;
    }
}
