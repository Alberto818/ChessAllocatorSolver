/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
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
public class TwoRooksTest {
    SearchEngine searchEngine;
    
    public TwoRooksTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        searchEngine = new SearchEngine();
    }
    
    private void genericTest(int rows, int columns,String chessPiecesStr,
                               String[] expectedRepresentationString){        
                
        
        List<Piece> pieces;
        pieces = ChessTools.getPiecesFromString(chessPiecesStr);
        
        
        Cell[] chessBoard;
        chessBoard = new Cell[rows * columns];
        
        Arrays.fill(chessBoard, Cell.DEFAULT_EMPTY_CELL);
        
        ChessGameConfiguration cgc = new ChessGameConfiguration(chessBoard,rows,columns);
        
        ChessGameConfiguration[] results = searchEngine.search(cgc, pieces);
        
        
        boolean fault = false;
        if (results.length == expectedRepresentationString.length){
                       
            for(int i= 0; i < results.length && !fault; i++){
                
               BigInteger biRepresentation = ChessTools.calculateRepresentationNumber(results[i].getCurrentBoard());
               String alfabet = ChessConstants.CHESS_BOARD_REPRESENTATION_ALFABET;
               String  currentRepresentationString = ChessTools.convertToRepresentationString(biRepresentation, alfabet.toCharArray());
               fault = !currentRepresentationString.equals(expectedRepresentationString[i]);
            }
        }else{
          fault = true;
        }
        
        assertFalse(fault);
    }
    //@Test
    public void twoRooks(){
    
        
        int rows = 2;
        int columns = 2;
        
        String chessPiecesStr = "RR";
        String[] expectedRepresentationString = {"o","Cj"};
        
        genericTest(rows, columns, chessPiecesStr, expectedRepresentationString);        
    }
    
    //@Test
    public void fourKings(){
    
        
        int rows = 3;
        int columns = 3;
        
        String chessPiecesStr = "KKKK";
        String[] expectedRepresentationString = {"DNab"};
        
        genericTest(rows, columns, chessPiecesStr, expectedRepresentationString);        
    }
    
    //@Test
    public void twoBishops(){
    
        
        int rows = 2;
        int columns = 2;
        
        String chessPiecesStr = "BB";
        String[] expectedRepresentationString = {"DE","K","Cj","f"};
        
        genericTest(rows, columns, chessPiecesStr, expectedRepresentationString);        
    }
    
    
   // @Test
    public void threeRooks(){
    
        
        int rows = 3;
        int columns = 3;
        
        String chessPiecesStr = "RRR";
        String[] expectedRepresentationString = {"391263","81263","78287","16287","18767","390767"};
        
        genericTest(rows, columns, chessPiecesStr, expectedRepresentationString);        
    }
    
    //@Test
    public void twoQueens(){
    
        
        int rows = 2;
        int columns = 3;
        
        String chessPiecesStr = "QQ";
        String[] expectedRepresentationString = {"BNb","DA"};
        
        genericTest(rows, columns, chessPiecesStr, expectedRepresentationString);        
    }
    
    @Test
    public void fourKnightsAndOneRoot(){
    
        
        int rows = 3;
        int columns = 3;
        
        String chessPiecesStr = "GGGGR";
        String[] expectedRepresentationString = {"ShNHE"};
        
        genericTest(rows, columns, chessPiecesStr, expectedRepresentationString);        
    }
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
