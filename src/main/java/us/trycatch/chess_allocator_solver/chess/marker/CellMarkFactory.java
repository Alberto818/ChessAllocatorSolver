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

    private static Hashtable<Piece,Marker[]> pieceMarksConfiguration;
    
    static{
     pieceMarksConfiguration = new Hashtable<>();
     
     //Rook configuration.
     Marker rowMarker = new RowMarker();
     Marker columnMarker = new ColumnMarker();
     
     Marker[] rookMarkers = {rowMarker,columnMarker};
     
     pieceMarksConfiguration.put(Piece.ROOK, rookMarkers);
    }
    public static Marker[] getMarks(Piece piece){
        
        Marker[] out = pieceMarksConfiguration.get(piece);
        return out;
    }
}
