/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package us.trycatch.chess_allocator_solver.chess;

import java.util.Arrays;
import java.util.List;


/**
 *
 * @author albertodelso
 */
public class ChessGame {
    
    private Cell[] chessBoard;
    private List<? extends Piece> availablePieces;
    
    public ChessGame(int rows, int columns,List<? extends Piece> availablePieces){
    
        chessBoard = new Cell[rows * columns];
        
        Arrays.fill(chessBoard, Cell.DEFAULT_EMPTY_CELL);
        
        this.availablePieces = availablePieces;
        
    }
    
        
    
}
