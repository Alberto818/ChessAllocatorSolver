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
public class UpKnightMarker extends AbstractMarker{

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
