package us.trycatch.chess_allocator_solver.chess.marker;

import us.trycatch.chess_allocator_solver.chess.Cell;

/**
 *RowMarker marks a row.
 * 
 * @author Alberto Delso Encabo
 * @version 1.0
 */
public class RowMarker extends AbstractMarker{

    /**
     * @inheritDoc
     */
    @Override
    public void mark(int boardPosition, Cell[] cellBoard, int rows, int columns) 
    throws IllegalMark{

        //Find the row.
        int boardPositionRow = boardPosition / columns * columns;
        
        //Mark the row.
        for(int i= boardPositionRow; i < boardPositionRow + columns; i++ ){
            mark(boardPosition,i,cellBoard);
        }
    }
    
}
