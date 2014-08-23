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
public class OneDownMarker extends AbstractMarker {

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
