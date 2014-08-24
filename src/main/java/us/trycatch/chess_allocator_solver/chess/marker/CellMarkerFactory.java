package us.trycatch.chess_allocator_solver.chess.marker;

import java.util.Hashtable;
import us.trycatch.chess_allocator_solver.chess.Piece;

/**
 *CellMarkerFactory get the piece markes of one piece.
 * 
 * @author Alberto Delso Encabo
 * @version 1.0
 */
public class CellMarkerFactory {

    private static CellMarkerFactory singlenton = null;
    private Hashtable<Piece,Marker[]> pieceMarksConfiguration;
    
    private CellMarkerFactory(){
     
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
     
     //Queen configuration
     //Rook markers + bishop markers = queen markers
     
     Marker[] queenMarkers = {rowMarker,columnMarker,
                              upLeftDiagonalMarker,upRightDiagonalMarker,
                              downLeftDiagonalMarker,downRightDiagonalMarker};
             
     pieceMarksConfiguration.put(Piece.QUEEN, queenMarkers);
     
     //Knight configuration
     Marker upKnightMarker = new UpKnightMarker();
     Marker downKnightMarker = new DownKnightMarker();
     Marker leftKnightMarker = new LeftKnightMarker();
     Marker rightKnightMarker = new RightKnightMarker();
     
     Marker[] knightMarkers = {upKnightMarker,downKnightMarker,
                               leftKnightMarker,rightKnightMarker};
     
     pieceMarksConfiguration.put(Piece.KNIGHT,knightMarkers);
    }
    
    /**
     * Returns the instance of CellMarkerFactory
     * 
     * @return this only instance.
     */
    public static CellMarkerFactory getInstance(){
        
        if (singlenton == null){
            singlenton = new CellMarkerFactory();
        }
        
        return singlenton;
    }
    
    /**
     * Return the associted markers of the piece.
     * 
     * @param piece The input piece
     * @return The asocciated piece marker piece
     */
    public Marker[] getMarks(Piece piece){
        
        Marker[] out = pieceMarksConfiguration.get(piece);
        return out;
    }
}
