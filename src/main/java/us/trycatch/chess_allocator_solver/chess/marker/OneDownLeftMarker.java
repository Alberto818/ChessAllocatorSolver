package us.trycatch.chess_allocator_solver.chess.marker;

import us.trycatch.chess_allocator_solver.chess.Cell;

/**
 *OneDownLeftMarker marks the cell in the left column and down row.
 *If the position is out of the board it does nothing.
 * 
 * @author Alberto Delso Encabo
 * @version 1.0
 */
public class OneDownLeftMarker extends AbstractMarker {

    /**
     * @inheritDoc
     */
    @Override
    public void mark(int boardPosition, Cell[] cellBoard, int rows, int columns) throws IllegalMark {
        //Find the row.
        int boardPositionRow = boardPosition / columns ;
        
        //Find the column.
        int boardPositionColumn = boardPosition % columns;
        
        if (boardPositionColumn > 0 && boardPositionRow < rows -1){
            //It's not the first column.
            
            int oneUpLeftCellPosition = boardPosition + columns -1;
            mark(boardPosition,oneUpLeftCellPosition,cellBoard);
        }
    }
    
}
