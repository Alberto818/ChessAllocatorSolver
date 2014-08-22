/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package us.trycatch.chess_allocator_solver.chess;

import java.math.BigInteger;
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
    
    public static BigInteger calculateRepresentationNumber(Cell[] currentBoard){
        
        BigInteger out = BigInteger.ZERO;
        
        Cell actualCell;
        int ibase = Piece.values().length;
        BigInteger base = BigInteger.valueOf(ibase);
        
        for(int i=0; i < currentBoard.length;i++){
            actualCell = currentBoard[i];
            
            if (actualCell instanceof PieceCell){
                PieceCell pieceCell = (PieceCell) actualCell;
                Piece piece = pieceCell.getPiece();
                
                //Calculate the new hashcode.
                out = out.add(BigInteger.valueOf(piece.ordinal()).add(base.pow(i)));
                
            }
        }
        
        return out;
    }
    
    public static String convertToRepresentationString(BigInteger irepresentation,char[] alfabet){
        
        String out = null;
        
        StringBuilder sb = new StringBuilder();
        BigInteger leftNumber = irepresentation;
        BigInteger base = BigInteger.valueOf(alfabet.length);
        
        while(leftNumber.intValue() > 0){
                BigInteger alfabetIndex = leftNumber.mod(base);
                leftNumber = leftNumber.divide(base);
                
                sb.insert(0,alfabet[alfabetIndex.intValue()]);
        }
        
        out = sb.toString();
        
        return out;
    }
}
