package us.trycatch.chess_allocator_solver.chess.marker;

import us.trycatch.chess_allocator_solver.chess.Cell;

/**
 *UpRightDiagonalMarker marks the cell diagonal in the right and up.
 *If the position is out of the board it does nothing.
 * 
 * @author Alberto Delso Encabo
 * @version 1.0
 */
public class UpRightDiagonalMarker extends AbstractMarker{

    /**
     * @inheritDoc
     */
    @Override
    public void mark(int boardPosition, Cell[] cellBoard, int rows, int columns) throws IllegalMark {
        //Find the row.
        int boardPositionRow = boardPosition / columns;
        
        //Find the column.
        int boardPositionColumn = boardPosition % columns;
        
        //Position to mark.
        int positionToMark = boardPosition;
        
        for(int currentRow = boardPositionRow,currentColumn = boardPositionColumn; 
                currentRow >=  0 && currentColumn < rows; 
                currentRow--,currentColumn++){
            
                positionToMark = columns * currentRow + currentColumn;
                mark(boardPosition, positionToMark,cellBoard);                
               
            }
        
      
    }
    
}
