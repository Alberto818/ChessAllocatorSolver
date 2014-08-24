package us.trycatch.chess_allocator_solver.chess.marker;

import us.trycatch.chess_allocator_solver.chess.Cell;

/**
 *OneRightMarker marks the cell in the right column.If the position is out
 *of the board it does nothing.
 * 
 * @author Alberto Delso Encabo
 * @version 1.0
 */
public class OneRightMarker extends AbstractMarker {

    /**
     * @inheritDoc
     */
    @Override
    public void mark(int boardPosition, Cell[] cellBoard, int rows, int columns) throws IllegalMark {
        //Find the column.
        int boardPositionColumn = boardPosition % columns;
        
        if (boardPositionColumn < columns -1){
            //It's not the last column.
            
            int oneRightCellPosition = boardPosition  +1;
            mark(boardPosition,oneRightCellPosition,cellBoard);
        }
    }
    
}
