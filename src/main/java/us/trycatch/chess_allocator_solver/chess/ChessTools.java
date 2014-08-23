/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package us.trycatch.chess_allocator_solver.chess;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Hashtable;
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
    public static char getCharFromPiece(Piece in)
    throws IllegalArgumentException{
    
        char out;
        
        switch(in){
            case KING:{
                out = ChessConstants.KING_PIECE_CHAR;
                break;
            }
            case QUEEN:{
                out = ChessConstants.QUEEN_PIECE_CHAR;
                break;
            }
            case BISHOP:{
                out = ChessConstants.BISHOP_PIECE_CHAR;
                break;
            }
            case KNIGHT:{
                out= ChessConstants.KNIGHT_PIECE_CHAR;
                break;
            }
            case ROOK:{
                out = ChessConstants.ROOK_PIECE_CHAR;
                break;
            }
            default:{
                String errorMsg = "Unknow piece type '"+in.name()+"'";
                IllegalArgumentException exception;
                exception = new IllegalArgumentException(errorMsg);
                throw exception;
            }
        }
        
        return out;
    }
    
    public static Piece getPieceFromChar(char in)
    throws IllegalArgumentException{
    
        Piece out = null;
        
        switch(in){
            case ChessConstants.KING_PIECE_CHAR:{
                out = Piece.KING;
                break;
            }
            case ChessConstants.QUEEN_PIECE_CHAR:{
                out = Piece.QUEEN;
                break;
            }
            case ChessConstants.BISHOP_PIECE_CHAR:{
                out = Piece.BISHOP;
                break;
            }
            case ChessConstants.KNIGHT_PIECE_CHAR:{
                out= Piece.KNIGHT;
                break;
            }
            case ChessConstants.ROOK_PIECE_CHAR:{
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
    
    public static Cell[] calculateCells(BigInteger biNumber){
    
        List<? super Cell> cellList = new ArrayList<>();
        
        BigInteger leftNumber = biNumber;
        Cell cell;
        BigInteger base = BigInteger.valueOf(Piece.values().length + 2);
        
        while(leftNumber.intValue() > 0){
        
            BigInteger ordinal = leftNumber.mod(base);
            leftNumber = leftNumber.divide(base);
            
            switch(ordinal.intValue()){
                case 0:{
                    cell = Cell.DEFAULT_EMPTY_CELL;
                    break;
                }
                case 1:{
                    cell= Cell.DEFAULT_TAKEN_CELL;                
                    break;
                }
                default:{
                Piece piece = Piece.getPieceFromOrdinal(ordinal.intValue() -2);
                cell = new PieceCell(piece);
                }
            }
            
            cellList.add(cell);
        }
        
        Cell[] out = cellList.toArray(new Cell[cellList.size()]);
        return out;
    }
    public static BigInteger calculateRepresentationNumber(Cell[] currentBoard){
        
        BigInteger out = BigInteger.ZERO;
        
        Cell actualCell;
        int ibase = Piece.values().length + 2;
        BigInteger base = BigInteger.valueOf(ibase);
        
        for(int i=0; i < currentBoard.length;i++){
            actualCell = currentBoard[i];
            
            if (actualCell == Cell.DEFAULT_EMPTY_CELL){
                //Do nothing. Empty cells value is zero.
            }else{
                if(actualCell == Cell.DEFAULT_TAKEN_CELL){
                    
                    //Calculate the new hashcode.
                    out = out.add(base.pow(i));
                }
                else{
                    if (actualCell instanceof PieceCell){
                        PieceCell pieceCell = (PieceCell) actualCell;
                        Piece piece = pieceCell.getPiece();

                        //Calculate the new hashcode.
                        out = out.add(BigInteger.valueOf(piece.ordinal() +2).multiply(base.pow(i)));
                    }
                }
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
                
                sb.append(alfabet[alfabetIndex.intValue()]);
        }
        
        out = sb.toString();
        
        return out;
    }
    
    public static BigInteger convertoToRepresentationNumber(String representationString, char[] alfabet){
        Hashtable<Character,Integer> conversionFunction = new Hashtable<>();
        
        BigInteger base = BigInteger.valueOf(alfabet.length);
        BigInteger out = BigInteger.ZERO;        
        
        for(int i= 0; i < alfabet.length;i++){
            conversionFunction.put(alfabet[i], i);
        }
        
        char[] chars = representationString.toCharArray();
        /**for(int i= chars.length -1; i >= 0 ;i-- ){
            char representationStringCharacter = chars[i];
            BigInteger number = BigInteger.valueOf(conversionFunction.get(representationStringCharacter));
            out = out.add(number.multiply(base.pow(chars.length - i -1)));
        }*/
        
         for(int i= 0; i < chars.length ;i++ ){
            char representationStringCharacter = chars[i];
            BigInteger number = BigInteger.valueOf(conversionFunction.get(representationStringCharacter));
            out = out.add(number.multiply(base.pow(i)));
        }
        
        return out;
    }
}
