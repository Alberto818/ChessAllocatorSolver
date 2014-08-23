/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package us.trycatch.chess_allocator_solver.chess;

/**
 *
 * @author albertodelso
 */
public interface ChessConstants {
 
    public static final int CELL_NUMBER_TO_CALCULATE_HASHCODE = 10;
     
    public static final String CHESS_BOARD_REPRESENTATION_ALFABET =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwyxz";
    
    public static final char KING_PIECE_CHAR = 'K';
    
    public static final char QUEEN_PIECE_CHAR = 'Q';
    
    public static final char BISHOP_PIECE_CHAR = 'B';
    
    public static final char KNIGHT_PIECE_CHAR = 'G';
    
    public static final char ROOK_PIECE_CHAR = 'R';
    
    public static final char EMPTY_CELL_CHAR = '·';
    
    public static final char TAKEN_CELL_CHAR = '*';
}
