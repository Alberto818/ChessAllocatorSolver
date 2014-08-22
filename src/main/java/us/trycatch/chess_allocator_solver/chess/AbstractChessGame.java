/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package us.trycatch.chess_allocator_solver.chess;

import java.math.BigInteger;
import java.util.Arrays;
import us.trycatch.chess_allocator_solver.chess.marker.CellMarkFactory;
import us.trycatch.chess_allocator_solver.chess.marker.Marker;
import static us.trycatch.chess_allocator_solver.chess.ChessConstants.*;
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
    
    public Cell[] getBoard(){
        Cell[] out = this.currentBoard;
        return out;
    }
    @Override
    public boolean equals(Object obj){
        
        boolean out = false;
        
        if (obj instanceof AbstractChessGame){
            AbstractChessGame acg = (AbstractChessGame) obj;
            
            if(this.currentBoard.length == acg.getBoard().length){
                
                if (currentBoard.length <= CELL_NUMBER_TO_CALCULATE_HASHCODE){
                    out = this.hashCode() == acg.hashCode();
                }else{
                    out = true;
                    
                    for(int i= CELL_NUMBER_TO_CALCULATE_HASHCODE +1; out && (i < currentBoard.length);i++){
                        Cell thisCell = this.currentBoard[i];
                        Cell otherCell = acg.getBoard()[i];
                        
                        if (thisCell instanceof PieceCell){
                            if (otherCell instanceof PieceCell){
                                PieceCell thisPieceCell = (PieceCell) thisCell;
                                PieceCell otherPieceCell = (PieceCell) otherCell;
                                
                                out = thisPieceCell.getPiece() == otherPieceCell.getPiece();
                            }else{
                                out = false;
                            }
                        }else{
                            if (otherCell instanceof PieceCell){
                                out = false;
                            }
                        }
                    }
                }
            }
            
        
        }
        
        return out;
    }
    private int calculateInternalHashCode(Cell[] currentBoard){
        
        int maxLength = (currentBoard.length <= CELL_NUMBER_TO_CALCULATE_HASHCODE) 
                      ?  currentBoard.length
                      :  CELL_NUMBER_TO_CALCULATE_HASHCODE;
        
        Cell[] limitedCurrentBoard = Arrays.copyOfRange(currentBoard, 0, maxLength);
        BigInteger biHashcode = ChessTools.calculateRepresentationNumber(limitedCurrentBoard);
        
        int out = biHashcode.intValue();
        
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
