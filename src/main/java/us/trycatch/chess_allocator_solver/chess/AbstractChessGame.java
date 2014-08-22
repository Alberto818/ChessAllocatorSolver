/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package us.trycatch.chess_allocator_solver.chess;

import java.util.Arrays;
import us.trycatch.chess_allocator_solver.chess.marker.CellMarkFactory;
import us.trycatch.chess_allocator_solver.chess.marker.Marker;

/**
 *
 * @author albertodelso
 */
public class AbstractChessGame {
    
    private int rows = 0;
    private int columns = 0;
    private Cell[] currentBoard = null;
    private int internalHashCode = 0;
    
    public Cell[] getCurrentBoard() {
        return currentBoard;
    }
            
    protected AbstractChessGame(Cell[] currentBoard,int rows,int columns){
    
        this.currentBoard = currentBoard;
        this.rows = rows;
        this.columns = columns;
        this.internalHashCode = calculateInternalHashCode(currentBoard);
    }
        
    @Override
    public int hashCode(){
        int out = this.internalHashCode;
        return out;
    }
    
    @Override
    public boolean equals(Object obj){
        
        boolean out = false;
        
        if (obj instanceof AbstractChessGame){
            AbstractChessGame acg = (AbstractChessGame) obj;
            
            out = this.hashCode() == acg.hashCode();
        
        }
        
        return out;
    }
    private int calculateInternalHashCode(Cell[] currentBoard){
        int out = 0;
        Cell actualCell;
        int base = Piece.values().length;
        
        for(int i=0; i < currentBoard.length;i++){
            actualCell = currentBoard[i];
            
            if (actualCell instanceof PieceCell){
                PieceCell pieceCell = (PieceCell) actualCell;
                Piece piece = pieceCell.getPiece();
                
                //Calculate the new hashcode.
                out += piece.ordinal() + Math.pow(base, i);
            }
        }
        
        return out;
    }
    
    public ChessGameConfiguration putPiece(Piece piece,int boardPosition){
        ChessGameConfiguration out;
    
        Cell[] newCellBoard = Arrays.copyOf(this.currentBoard, this.currentBoard.length);
        
        //
        Marker[] markers = CellMarkFactory.getMarks(piece);
        
        for(Marker marker:markers){
              marker.mark(boardPosition,newCellBoard,this.rows,this.columns);
        }
        
        //Set the piece cell.
        newCellBoard[boardPosition] = new PieceCell(piece);        
        
        out = new ChessGameConfiguration(newCellBoard, rows, columns);
        
        return out;
    }
    
}
