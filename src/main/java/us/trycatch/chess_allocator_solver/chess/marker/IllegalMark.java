/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package us.trycatch.chess_allocator_solver.chess.marker;

/**
 *
 * @author albertodelso
 */
public class IllegalMark extends Exception {
    
    private int originCellPosition;
    private int forbiddenCellPosition;
    public IllegalMark(){
    }
    
    public IllegalMark(String msg){
        super(msg);
    }
    
    public IllegalMark(int originCellPosition,int forbiddenCellPosition){
        this.originCellPosition = originCellPosition;
        this.forbiddenCellPosition = forbiddenCellPosition;
    }
    
    public int getOriginCellPosition(){
        int out = this.originCellPosition;
        return out;
    }
    
    public int getForbiddenCellPosition(){
        int out = this.forbiddenCellPosition;
        return out;
    }
}
