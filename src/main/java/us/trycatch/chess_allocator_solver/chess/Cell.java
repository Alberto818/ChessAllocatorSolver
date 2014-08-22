/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package us.trycatch.chess_allocator_solver.chess;

/**
 *
 * @author albertodelso
 */
public interface Cell {
    
    public static final Cell DEFAULT_EMPTY_CELL = new EmptyCell();
    public static final Cell DEFAULT_TAKEN_CELL = new TakenCell();
}
