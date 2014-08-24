package us.trycatch.chess_allocator_solver.chess.marker;

import us.trycatch.chess_allocator_solver.chess.Cell;

/**
 *This marker marks the column of the board position.
 * 
 * @author Alberto Delso Encabo
 * @version 1.0
 */
public class ColumnMarker extends  AbstractMarker{
    

    /**
     * @inheritDoc
     */
    @Override
    public void mark(int boardPosition, Cell[] cellBoard, int rows, int columns) 
    throws IllegalMark{
        
        //Find the column.
        int boardPositionColumn = boardPosition % columns;
        
        //Mark the row.
        for(int i= boardPositionColumn; i < boardPositionColumn + rows * columns ; i+= columns ){
            mark(boardPosition,i,cellBoard);
        }
    }
}
