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
public abstract class AbstractMarker implements Marker {
    
    protected void mark(int originPosition,int positionToMark,Cell[] cellBoard)
    throws IllegalMark{
        if (cellBoard[positionToMark] == Cell.DEFAULT_EMPTY_CELL){
                cellBoard[positionToMark] = Cell.DEFAULT_TAKEN_CELL;
            }
        else{
            if(cellBoard[positionToMark] == Cell.DEFAULT_TAKEN_CELL){
                //Do nothing. It's already taken.
            }else{
                //There is a piece here. Throw a IllegarlMark
                IllegalMark exception = new IllegalMark(originPosition,positionToMark);
                throw exception;
            }
        }
    }
}
