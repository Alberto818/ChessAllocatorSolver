/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package us.trycatch.chess_allocator_solver.chess.marker;

import us.trycatch.chess_allocator_solver.chess.Cell;

/**
 *
 * @author albertodelso
 */
public class RightKnightMarker extends AbstractMarker{

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
