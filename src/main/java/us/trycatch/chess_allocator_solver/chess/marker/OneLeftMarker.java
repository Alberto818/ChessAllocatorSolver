package us.trycatch.chess_allocator_solver.chess.marker;

import us.trycatch.chess_allocator_solver.chess.Cell;

/**
 *OneLeftMarker marks the cell in the left column.If the position is out
 *of the board it does nothing.
 * 
 * @author Alberto Delso Encabo
 * @version 1.0
 */
public class OneLeftMarker extends AbstractMarker{

    /**
     * @inheritDoc
     */
    @Override
    public void mark(int boardPosition, Cell[] cellBoard, int rows, int columns) throws IllegalMark {
        //Find the column.
        int boardPositionColumn = boardPosition % columns;
        
        if (boardPositionColumn > 0){
            //It's not the first column.
            
            int oneLeftCellPosition = boardPosition - 1;
            mark(boardPosition,oneLeftCellPosition,cellBoard);
        }
    }
    
}
