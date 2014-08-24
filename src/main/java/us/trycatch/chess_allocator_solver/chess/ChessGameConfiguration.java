package us.trycatch.chess_allocator_solver.chess;

import java.math.BigInteger;
import java.util.Arrays;
import static us.trycatch.chess_allocator_solver.chess.ChessConstants.*;
import us.trycatch.chess_allocator_solver.chess.marker.CellMarkerFactory;
import us.trycatch.chess_allocator_solver.chess.marker.IllegalMark;
import us.trycatch.chess_allocator_solver.chess.marker.Marker;

/**
 *This class is used to representate one chess board configuration. It has
 * number of rows and columns and a list with all cells.
 * 
 * @author Alberto Delso
 * @version 1.0
 */
public class ChessGameConfiguration {
    
    private int rows = 0;
    private int columns = 0;
    private Cell[] currentBoard = null;
    private int internalHashCode = 0;
    
   
    /**
     * Return the cell list stored in this chess game configuration.
     * @return the current cell list
     */
    public Cell[] getCurrentBoard() {
        return currentBoard;
    }
            
    /**
     * ChessGameConfiguration constructor.
     * 
     * @param currentBoard the cell list to store in this chess game configuration
     * @param rows number of rows
     * @param columns number of columns
     */
    public ChessGameConfiguration(Cell[] currentBoard,int rows,int columns){
    
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
        
        if (obj instanceof ChessGameConfiguration){
            ChessGameConfiguration acg = (ChessGameConfiguration) obj;
            
            if(this.currentBoard.length == acg.getCurrentBoard().length){
                
                if (currentBoard.length <= CELL_NUMBER_TO_CALCULATE_HASHCODE){
                    out = this.hashCode() == acg.hashCode();
                }else{
                    out = true;
                    
                    for(int i= CELL_NUMBER_TO_CALCULATE_HASHCODE +1; out && (i < currentBoard.length);i++){
                        Cell thisCell = this.currentBoard[i];
                        Cell otherCell = acg.getCurrentBoard()[i];
                        
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
    
    /**
     * Used to calculate the hascode of the chess game configutation. It uses
     * the ChessConstants.CELL_NUMBER_TO_CALCULATE_HASCODE to take the cell that
     * are needed for the calculation. Later it uses that cells to calculate the
     * hashcode with the ChessTools.calculateRepresentationNumber.
     * 
     * @param currentBoard the board to calculate the hashcode.
     * @return the calculated hashcode
     */
    private int calculateInternalHashCode(Cell[] currentBoard){
        
        int maxLength = (currentBoard.length <= CELL_NUMBER_TO_CALCULATE_HASHCODE) 
                      ?  currentBoard.length
                      :  CELL_NUMBER_TO_CALCULATE_HASHCODE;
        
        Cell[] limitedCurrentBoard = Arrays.copyOfRange(currentBoard, 0, maxLength);
        BigInteger biHashcode = ChessTools.calculateRepresentationNumber(limitedCurrentBoard);
        
        int out = biHashcode.intValue();
        
        return out;
    }
    
    /**
     * Put a piece into this chess game configuration and returns the new 
     * chess game configuration.
     * 
     * @param piece Piece to fit
     * @param boardPosition Position where the piece wants to stay
     * @return The new chess game configuration afte the piece is allocated
     * @throws IllegalMark If the piece try to take a cell with a piece
     */    
    public ChessGameConfiguration putPiece(Piece piece,int boardPosition)
    throws IllegalMark{
        ChessGameConfiguration out;
    
        Cell[] newCellBoard = Arrays.copyOf(this.currentBoard, this.currentBoard.length);
        
        //
        CellMarkerFactory cellMarkFactory = CellMarkerFactory.getInstance();
        Marker[] markers = cellMarkFactory.getMarks(piece);
        
        for(Marker marker:markers){    
              marker.mark(boardPosition,newCellBoard,this.rows,this.columns);
        }
        
        //Set the piece cell.
        newCellBoard[boardPosition] = new PieceCell(piece);        
        
        out = new ChessGameConfiguration(newCellBoard, rows, columns);
        
        return out;
    }
    
}
