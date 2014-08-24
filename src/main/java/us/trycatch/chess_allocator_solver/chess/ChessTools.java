package us.trycatch.chess_allocator_solver.chess;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *This class has utility static methods used across the application
 * 
 * @author Alberto Delso Encabo
 * @version 1.0
 */
public class ChessTools {

    /**
     * This method get a piece list from its representation string. The allowed
     * piece chars are defined in the ChessConstants interface.
     * 
     * @param in the input representation string
     * @return the piece list
     * @throws IllegalArgumentException If unknown piece char is found
     */
    
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
    
    /**
     * Returns the piece representation char.
     * 
     * @param in the input char
     * @return the asociated piece representation char
     * @throws IllegalArgumentException If the piece is unknown or it has not
     * representation char
     */
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
    
    /**
     * Return the piece instance from its representation char
     * 
     * @param in the representation char
     * @return The piece associated with the representation char
     * @throws IllegalArgumentException If it is not found the associated piece
     */
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
    
    /**
     * From the representation number of the chess game configuration it gets
     * the cell list associated
     * 
     * @param biNumber the representation number
     * @return the associated cell list
     */
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
    
    /**
     * Calculate the representation number from the cell list
     * 
     * @param currentBoard the cell list
     * @return the representation number
     */
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
    
    /**
     * Convert a representation number to a representation string. It is used
     * to show the chess game configuration in a compact string.
     * 
     * @param irepresentation the input representation number
     * @param alfabet the alfabet used to do the conversion to string
     * @return the representation string
     */
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
    
    /**
     * Calculate the representation number from the representation string.
     * 
     * @param representationString the input representation string
     * @param alfabet The alfabet used to do the coversion
     * @return The representation number
     */
    public static BigInteger convertoToRepresentationNumber(String representationString, char[] alfabet){
        Hashtable<Character,Integer> conversionFunction = new Hashtable<>();
        
        BigInteger base = BigInteger.valueOf(alfabet.length);
        BigInteger out = BigInteger.ZERO;        
        
        for(int i= 0; i < alfabet.length;i++){
            conversionFunction.put(alfabet[i], i);
        }
        
        char[] chars = representationString.toCharArray();
               
        for(int i= 0; i < chars.length ;i++ ){
            char representationStringCharacter = chars[i];
            BigInteger number = BigInteger.valueOf(conversionFunction.get(representationStringCharacter));
            out = out.add(number.multiply(base.pow(i)));
        }
        
        return out;
    }
}
