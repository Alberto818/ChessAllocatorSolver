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
public class ColumnMarker implements Marker{
    

    @Override
    public void mark(int boardPosition, Cell[] cellBoard, int rows, int columns) {

        //Find the row.
        int boardPositionColumn = boardPosition % columns;
        
        //Mark the row.
        for(int i= boardPositionColumn; i < boardPositionColumn + rows * columns ; i+= columns ){
            if (cellBoard[i] == Cell.DEFAULT_EMPTY_CELL){
                cellBoard[i] = Cell.DEFAULT_TAKEN_CELL;
            }
        }
    }
}
