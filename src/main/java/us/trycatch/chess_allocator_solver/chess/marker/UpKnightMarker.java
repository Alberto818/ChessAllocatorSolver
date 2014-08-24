package us.trycatch.chess_allocator_solver.chess.marker;

import us.trycatch.chess_allocator_solver.chess.Cell;

/**
 *UpKnightMarker marks the positions when the knight is moved up.
 * 
 * @author Alberto Delso Encabo
 * @version 1.0
 */
public class UpKnightMarker extends AbstractMarker{

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
        
        if (boardPositionRow -2 >=0){
            
            //Left side.
            if(boardPositionColumn -1 >= 0){
                positionToMark = (boardPositionRow -2) * columns + boardPositionColumn -1;
                mark(boardPosition,positionToMark, cellBoard);
            }
            
            if(boardPositionColumn +1 < columns){
                positionToMark = (boardPositionRow -2) * columns + boardPositionColumn +1;
                mark(boardPosition,positionToMark, cellBoard);
            }
        }
    }
    
}
