package us.trycatch.chess_allocator_solver.chess;

/**
 *This is the intace for the Cell objects.
 * 
 * @author Alberto Delso Encabo
 * @version 1.0
 */
public interface Cell {
   
    /** Default empty cell intace. Use to not create multiple empty cell 
     * instances
     */
    public static final Cell DEFAULT_EMPTY_CELL = new EmptyCell();
    /** Default taken cell intace. Use to not create multiple taken cell 
     * instances
     */
    public static final Cell DEFAULT_TAKEN_CELL = new TakenCell();
}
