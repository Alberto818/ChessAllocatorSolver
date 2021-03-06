package us.trycatch.chess_allocator_solver.chess.marker;

import us.trycatch.chess_allocator_solver.chess.Cell;

/**
 *RightKnightMarker marks the positions when the knight is moved to the right.
 * 
 * @author Alberto Delso Encabo
 * @version 1.0
 */
public class RightKnightMarker extends AbstractMarker{

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
        
        if (boardPositionColumn +2 < columns){
            
            //Up side.
            if(boardPositionRow -1 >= 0){
                positionToMark = (boardPositionRow -1) * columns + boardPositionColumn +2;
                mark(boardPosition,positionToMark, cellBoard);
            }
            
            if(boardPositionRow +1 < rows){
                positionToMark = (boardPositionRow +1) * columns + boardPositionColumn +2;
                mark(boardPosition,positionToMark, cellBoard);
            }
        }
    }
    
}
