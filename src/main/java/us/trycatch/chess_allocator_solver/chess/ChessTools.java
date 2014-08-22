/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package us.trycatch.chess_allocator_solver.chess;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author albertodelso
 */
public class ChessTools {

    public static List<Piece> getPiecesFromString(String in)
    throws IllegalArgumentException{
        List<Piece> out = new ArrayList<>();
        
        Piece readPiece;
        for(int i=0; i < in.length(); i++){
            readPiece = getPieceFromChar(in.charAt(i));
            out.add(readPiece);
        }
            
        return out;
    }
    
    public static Piece getPieceFromChar(char in)
    throws IllegalArgumentException{
    
        Piece out = null;
        
        switch(in){
            case 'K':{
                out = Piece.KING;
                break;
            }
            case 'Q':{
                out = Piece.QUEEN;
                break;
            }
            case 'B':{
                out = Piece.BISHOP;
                break;
            }
            case 'G':{
                out= Piece.KNIGHT;
                break;
            }
            case 'R':{
                out = Piece.ROOK;
                break;
            }
            default:{
                String errorMsg = "Unknow piece type char '"+in+"'";
                IllegalArgumentException exception;
                exception = new IllegalArgumentException(errorMsg);
                throw exception;
            }
        }
        
        return out;
    }
}
