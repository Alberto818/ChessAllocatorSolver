package us.trycatch.chess_allocator_solver.chess.marker;

import us.trycatch.chess_allocator_solver.chess.Cell;

/**
 * When a piece is put in the cell board it marks others cells in the board as
 * taken. The cells to mark in the board when a piece is put in the board is 
 * specific of each piece. One piece could have one or more markers. All markers
 * has to implement this interface.
 * 
 * @author Alberto Delso Encabo
 * @version 1.0
 */
public interface Marker {
    
    /**
     * Marks as taken the cells
     * 
     * @param boardPosition The position where the piece is put.
     * @param cellBoard The board where mark the taken cells.
     * @param rows The numbers or board rows.
     * @param columns The numbers or board columns.
     * @throws IllegalMark If try to take a piece cell.
     */
    public void mark(int boardPosition,Cell[] cellBoard,int rows,int columns)
    throws IllegalMark;
}
