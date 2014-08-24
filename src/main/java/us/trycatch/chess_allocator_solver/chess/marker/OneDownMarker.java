package us.trycatch.chess_allocator_solver.chess.marker;

import us.trycatch.chess_allocator_solver.chess.Cell;

/**
 *OneDownMarker marks the cell in one row down. If the position is out
 *of the board it does nothing.
 * 
 * @author Alberto Delso Encabo
 * @version 1.0
 */
public class OneDownMarker extends AbstractMarker {

    /**
     * @inheritDoc
     */
    @Override
    public void mark(int boardPosition, Cell[] cellBoard, int rows, int columns) throws IllegalMark {
        //Find the row.
        int boardPositionRow = boardPosition / columns;
        
        if (boardPositionRow < rows -1){
            //It's not the last row.
            
            int oneDownCellPosition = boardPosition + columns;
            mark(boardPosition,oneDownCellPosition,cellBoard);
        }
    }
    
}
