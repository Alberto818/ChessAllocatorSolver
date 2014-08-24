package us.trycatch.chess_allocator_solver.chess.marker;

import us.trycatch.chess_allocator_solver.chess.Cell;

/**
 *Abstract marker class. It has a method to mark a cell used in all markers.
 * 
 * @author Alberto Delso Encabo
 * @version 1.0
 */
public abstract class AbstractMarker implements Marker {
    
    /**
     * Mark one cell in positionToMark as taken. If try to mark a piece cell 
     * then a IllegalMark is thrown.
     * 
     * @param originPosition Piece position where the piece is put
     * @param positionToMark Position to mark
     * @param cellBoard The board to mark
     * @throws IllegalMark If try to mark a piece cell 
     * then a IllegalMark is thrown.
     */
    protected void mark(int originPosition,int positionToMark,Cell[] cellBoard)
    throws IllegalMark{
        if (cellBoard[positionToMark] == Cell.DEFAULT_EMPTY_CELL){
                cellBoard[positionToMark] = Cell.DEFAULT_TAKEN_CELL;
            }
        else{
            if(cellBoard[positionToMark] == Cell.DEFAULT_TAKEN_CELL){
                //Do nothing. It's already taken.
            }else{
                //There is a piece here. Throw a IllegarlMark
                IllegalMark exception = new IllegalMark(originPosition,positionToMark);
                throw exception;
            }
        }
    }
}
