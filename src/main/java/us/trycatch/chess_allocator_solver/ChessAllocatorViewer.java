/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package us.trycatch.chess_allocator_solver;

import java.math.BigInteger;
import us.trycatch.chess_allocator_solver.chess.Cell;
import us.trycatch.chess_allocator_solver.chess.ChessConstants;
import us.trycatch.chess_allocator_solver.chess.ChessTools;
import us.trycatch.chess_allocator_solver.chess.Piece;
import us.trycatch.chess_allocator_solver.chess.PieceCell;

/**
 *
 * @author albertodelso
 */
public class ChessAllocatorViewer {
     public static void main(String[] args){
        ChessAllocatorViewer application = new ChessAllocatorViewer();
        application.run(args);
    }
    public void run(String[] args){
    
        int rows = 0;
        int columns = 0;
        
        String errorMsg;
        
        if (args.length != 3){
            errorMsg = "Invalid number of parameters. Expected rows colums representationString";
            System.out.println(errorMsg);
        }else{
            
            //Get the row number.
            try{
               rows = Integer.parseInt(args[0]);
               
               //Get the column number.
               try{                  
                columns = Integer.parseInt(args[1]);

                String alfabet = ChessConstants.CHESS_BOARD_REPRESENTATION_ALFABET;
                BigInteger biRepresentationNumber = ChessTools.convertoToRepresentationNumber(args[2], alfabet.toCharArray());
                Cell[] boardCells = ChessTools.calculateCells(biRepresentationNumber);
                
                printChessBoard(rows, columns, boardCells);
                }catch(NumberFormatException columnsNumberFormatException){
                errorMsg = "Invalid columns number";
                System.out.println(errorMsg);
                }
            }catch(NumberFormatException rowNumberFormatException){
            errorMsg = "Invalid rows number";
            System.out.println(errorMsg);
            }
        }
    }
    
    private void printChessBoard(int rows,int columns, Cell[] boardCells){
        String errorMsg;
        
        
        for(int currentRow = 0; currentRow < rows; currentRow++){
            for(int currentColumn = 0; currentColumn < columns; currentColumn++){
                
                int position = currentRow * columns + currentColumn;
                char representationChar;
                
                if (position >= boardCells.length){
                    representationChar = '·';
                }
                else{
                    Cell cell = boardCells[position];
                    
                    if (cell == Cell.DEFAULT_EMPTY_CELL){
                        representationChar = '·';                    
                    }else{
                        if (cell == Cell.DEFAULT_TAKEN_CELL){
                            representationChar= '*';
                        }else{
                            PieceCell pieceCell = (PieceCell) cell;
                            Piece piece = pieceCell.getPiece();
                            representationChar = ChessTools.getCharFromPiece(piece);
                        }
                    }
                }
                
                System.out.print(representationChar);
                
            }
            
            System.out.println();
        }
        
    }
}
