package us.trycatch.chess_allocator_solver.chess.marker;

/**
 *IllegalMark is thrown when a marker try to mark as taken a piece cell.
 * 
 * @author albertodelso
 * @version 1.0
 */
public class IllegalMark extends Exception {
    
    private int originCellPosition;
    private int forbiddenCellPosition;
    
    /**
     * The default constructor.
     */
    public IllegalMark(){
    }
    
    /**
     * A constructor that set the message.
     * 
     * @param msg Message.
     */
    public IllegalMark(String msg){
        super(msg);
    }
    
    /**
     * A constructor that set originCellPosition and the forbiddenCellPosition
     * 
     * @param originCellPosition the position where the piece is put.
     * @param forbiddenCellPosition  the position that is tried to mark
     */
    public IllegalMark(int originCellPosition,int forbiddenCellPosition){
        this.originCellPosition = originCellPosition;
        this.forbiddenCellPosition = forbiddenCellPosition;
    }
    
    /**
     * Getter
     * 
     * @return orginCellPosition. 
     */
    public int getOriginCellPosition(){
        int out = this.originCellPosition;
        return out;
    }
    
    /**
     * Getter
     * 
     * @return forbiddenCellPosition. 
     */
    public int getForbiddenCellPosition(){
        int out = this.forbiddenCellPosition;
        return out;
    }
}
