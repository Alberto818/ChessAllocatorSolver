package us.trycatch.chess_allocator_solver.chess;

/**
 *This interface store all application constants.
 * 
 * @author Alberto Delso
 * @version 1.0
 */
public interface ChessConstants {
 
    /**
     * Number of cells to calculate the hascode of one ChessGameConfiguration.
     */
    public static final int CELL_NUMBER_TO_CALCULATE_HASHCODE = 10;
     
    /**
     * Alfabet used to convert a Cell[] to its representation string.
     */
    public static final String CHESS_BOARD_REPRESENTATION_ALFABET =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwyxz";
    
    /**
     * King char
     */
    public static final char KING_PIECE_CHAR = 'K';
    
    /**
     * Queen char
     */
    public static final char QUEEN_PIECE_CHAR = 'Q';
    
    /**
     * Bishop char
     */
    public static final char BISHOP_PIECE_CHAR = 'B';
    
    /**
     * Knight char
     */
    public static final char KNIGHT_PIECE_CHAR = 'G';
    
    /**
     * Rook char
     */
    public static final char ROOK_PIECE_CHAR = 'R';
    
    /**
     * Empty cell char
     */
    public static final char EMPTY_CELL_CHAR = '·';
    
    /**
     * Taken cell char
     */
    public static final char TAKEN_CELL_CHAR = '*';
}
