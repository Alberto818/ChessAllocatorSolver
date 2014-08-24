package us.trycatch.chess_allocator_solver.chess.marker;

import us.trycatch.chess_allocator_solver.chess.Cell;

/**
 *DownKnightMarker marks the positions when the knight is moved down.
 * 
 * @author Alberto Delso Encabo
 * @version 1.0
 */
public class DownKnightMarker extends AbstractMarker {

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
        
        if (boardPositionRow +2 < rows){
            
            //Left side.
            if(boardPositionColumn -1 >= 0){
                positionToMark = (boardPositionRow +2) * columns + boardPositionColumn -1;
                mark(boardPosition,positionToMark, cellBoard);
            }
            
            //Right side.
            if(boardPositionColumn +1 < columns){
                positionToMark = (boardPositionRow +2) * columns + boardPositionColumn +1;
                mark(boardPosition,positionToMark, cellBoard);
            }
        }
    }
    
}
