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
 * This is the main class of the application. It takes the row number, the 
 * column number and a String with the chess pieces that it is pretended to
 * allocate in the chess board. If no solution is found the application will 
 * show a error message in other case all found solutions are shown as
 * its string representation. The string representation can be used in the
 * ChessAllocatorViewer to get a text representation of the solution.
 * 
 * @author Alberto Delso Encabo
 * @version 1.0 
 */
public class ChessAllocatorSolver {
    
    //i18n
    private ResourceBundle messages = ResourceBundle.getBundle("messages");
    
    /**
     * This is main method. The application start here.
     * 
     * @param args Three parameters are expected. Rows number (number) +
     *  columns number + Pieces string representation.  
     * <P>
     * The pieces string represention has one char for each piece. 
     * <P>
     * For example:
     * <BR> 'K' -> One rook
     * <BR> 'GG' -> Two knight
     * <BR> 'KQ'-> One King and One Queen
     * <BR> The pieces char order do not matter.
     * 
     * 
     */
    public static void main(String[] args){
        ChessAllocatorSolver application = new ChessAllocatorSolver();
        application.run(args);
    }
    
    /**
     * The same behaivour as main method.
     * @param args 
     */
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
    
    /**
     * Prints in the System.out the solution list.
     * @param results solution list
     */
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
