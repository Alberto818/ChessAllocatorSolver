package us.trycatch.chess_allocator_solver.chess.marker;

import us.trycatch.chess_allocator_solver.chess.Cell;

/**
 *OneUpMarker marks the cell in position in one row up. If the position is out
 * of the board it does nothing.
 * 
 * @author Alberto Delso Encabo
 * @version 1.0
 */
public class OneUpMarker extends AbstractMarker{

    /**
     * @inheritDoc
     */
    @Override
    public void mark(int boardPosition, Cell[] cellBoard, int rows, int columns) throws IllegalMark {
        
        //Find the row.
        int boardPositionRow = boardPosition / columns * columns;
        
        if (boardPositionRow > 0){
            //It's not the first row.
            
            int oneUpCellPosition = boardPosition - columns;
            mark(boardPosition,oneUpCellPosition,cellBoard);
        }
    }
    
}
