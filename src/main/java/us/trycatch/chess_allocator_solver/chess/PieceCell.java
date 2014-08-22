/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package us.trycatch.chess_allocator_solver.chess;

/**
 *
 * @author albertodelso
 */
public class PieceCell implements Cell {
    
    private Piece piece = null;
    
    public PieceCell(Piece piece){
     this.piece = piece;
    }
    
    public Piece getPiece(){
     return this.piece;
    }
}