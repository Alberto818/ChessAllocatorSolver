package us.trycatch.chess_allocator_solver.chess.marker;

import us.trycatch.chess_allocator_solver.chess.Cell;

/**
 *DownLeftDiagonalMarker marks the cell diagonal in the left and down.
 *If the position is out of the board it does nothing.
 * 
 * @author Alberto Delso Encabo
 * @version 1.0
 */
public class DownLeftDiagonalMarker extends AbstractMarker{

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
                currentRow <  rows  && currentColumn >= 0; 
                currentRow++,currentColumn--){
            
                positionToMark = columns * currentRow + currentColumn;
                mark(boardPosition, positionToMark,cellBoard);                
               
            }
        
      
    }
    
}
