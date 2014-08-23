/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package us.trycatch.chess_allocator_solver.chess.marker;

import java.util.Hashtable;
import us.trycatch.chess_allocator_solver.chess.Piece;

/**
 *
 * @author albertodelso
 */
public class CellMarkFactory {

    private static CellMarkFactory singlenton = null;
    private Hashtable<Piece,Marker[]> pieceMarksConfiguration;
    
    private CellMarkFactory(){
     
     pieceMarksConfiguration = new Hashtable<>();
     
     //King configuration
     Marker oneUpMarker = new OneUpMarker();
     Marker oneDownMarker = new OneDownMarker();
     Marker oneLeftMarker = new OneLeftMarker();
     Marker oneRightMarker = new OneRightMarker();
     Marker oneUpLeftMarker = new OneUpLeftMarker();
     Marker oneUpRightMarker = new OneUpRightMarker();
     Marker oneDownLeftMarker = new OneDownLeftMarker();
     Marker oneDownRightMarker = new OneDownRightMarker();
     
     Marker[] kingMarkers = {oneUpMarker,oneDownMarker,
                             oneLeftMarker,oneRightMarker,
                             oneUpLeftMarker,oneUpRightMarker,
                             oneDownLeftMarker,oneDownRightMarker};
     
     pieceMarksConfiguration.put(Piece.KING,kingMarkers);
     
     //Bishop configuration
     Marker upLeftDiagonalMarker = new UpLeftDiagonalMarker();
     Marker upRightDiagonalMarker = new UpRightDiagonalMarker();
     Marker downLeftDiagonalMarker = new DownLeftDiagonalMarker();
     Marker downRightDiagonalMarker = new DownRightDiagonalMarker();
     
     Marker[] bishopMarkers =  {upLeftDiagonalMarker,upRightDiagonalMarker,
                                downLeftDiagonalMarker,downRightDiagonalMarker};
     
     pieceMarksConfiguration.put(Piece.BISHOP,bishopMarkers);
     //Rook configuration.
     Marker rowMarker = new RowMarker();
     Marker columnMarker = new ColumnMarker();
     
     Marker[] rookMarkers = {rowMarker,columnMarker};
     
     pieceMarksConfiguration.put(Piece.ROOK, rookMarkers);
    }
    
    public static CellMarkFactory getInstance(){
        
        if (singlenton == null){
            singlenton = new CellMarkFactory();
        }
        
        return singlenton;
    }
    public Marker[] getMarks(Piece piece){
        
        Marker[] out = pieceMarksConfiguration.get(piece);
        return out;
    }
}
