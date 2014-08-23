/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package us.trycatch.chess_allocator_solver;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import us.trycatch.chess_allocator_solver.chess.Cell;
import us.trycatch.chess_allocator_solver.chess.ChessConstants;
import us.trycatch.chess_allocator_solver.chess.ChessGameConfiguration;
import us.trycatch.chess_allocator_solver.chess.ChessTools;
import us.trycatch.chess_allocator_solver.chess.Piece;
import us.trycatch.chess_allocator_solver.chess.SearchEngine;

/**
 *
 * @author albertodelso
 */
public class ChessAllocatorSolver {
    
    ResourceBundle messages = ResourceBundle.getBundle("messages");
    
    public static void main(String[] args){
        ChessAllocatorSolver application = new ChessAllocatorSolver();
        application.run(args);
    }
    public void run(String[] args){
    
        int rows = 0;
        int columns = 0;
        List<? extends Piece> piecesToAllocate;
        String errorMsg;
        
        if (args.length != 3){
            errorMsg = messages.getString("numParametersInvalid");
            System.out.println(errorMsg);
        }else{
            
            //Get the row number.
            try{
               rows = Integer.parseInt(args[0]);
               
               //Get the column number.
               try{                  
                columns = Integer.parseInt(args[1]);

                //Get the pieces.
                try{
                piecesToAllocate = ChessTools.getPiecesFromString(args[2]);
                
                Cell[] chessBoard;
                chessBoard = new Cell[rows * columns];

                Arrays.fill(chessBoard, Cell.DEFAULT_EMPTY_CELL);

                ChessGameConfiguration cgc = new ChessGameConfiguration(chessBoard,rows,columns);

                
                SearchEngine searchEngine = new SearchEngine();
                ChessGameConfiguration[] results = searchEngine.search(cgc, piecesToAllocate);
                
                printResults(results);
                }catch(IllegalArgumentException invalidPieceCharException){
                   errorMsg = messages.getString("pieceCharInvalid");
                   System.out.println(errorMsg);
                }
                }catch(NumberFormatException columnsNumberFormatException){
                errorMsg = messages.getString("columnsNumberInvalid");
                System.out.println(errorMsg);
                }
            }catch(NumberFormatException rowNumberFormatException){
            errorMsg = messages.getString("rowsNumberInvalid");
            System.out.println(errorMsg);
            }
        }
    }
    
    private void printResults(ChessGameConfiguration[] results){
        String errorMsg;
        
        if (results.length == 0){
            errorMsg = messages.getString("noSolutionsFound");
            System.out.println(errorMsg);
        }else{
            String msg = results.length + messages.getString("solutionsFound");
            System.out.println(msg);
            
            for(int i = 0; i < results.length; i++){
                Cell[] cells = results[i].getCurrentBoard();
                
                String alfabet = ChessConstants.CHESS_BOARD_REPRESENTATION_ALFABET;
                BigInteger biRepresentationNumber = ChessTools.calculateRepresentationNumber(cells);                
                String strRepresentationString = ChessTools.convertToRepresentationString(biRepresentationNumber, alfabet.toCharArray());
                                
                msg = messages.getString("solution") +" ("+i+"): " + strRepresentationString;
                System.out.println(msg);
            }
            
            msg = messages.getString("viewerAdvice");
            System.out.println("\n" + msg);
        }
    }
}
