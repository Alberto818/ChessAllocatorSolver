/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package us.trycatch.chess_allocator_solver.chess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import us.trycatch.chess_allocator_solver.chess.marker.IllegalMark;

/**
 *
 * @author albertodelso
 */
public class SearchEngine {

    private class SearchEngineStep{
    
        
        private ChessGameConfiguration cgconfig;
        private List<? extends Piece> availablePieces;

        public SearchEngineStep(ChessGameConfiguration cgc, List<? extends Piece> availablePieces){
             this.cgconfig = cgc;
             this.availablePieces = availablePieces;
        }
        
        public ChessGameConfiguration getCgconfig() {
            return cgconfig;
        }

        public void setCgconfig(ChessGameConfiguration cgconfig) {
            this.cgconfig = cgconfig;
        }

        public List<? extends Piece> getAvailablePieces() {
            return availablePieces;
        }

        public void setAvailablePieces(List<? extends Piece> availablePieces) {
            this.availablePieces = availablePieces;
        }
        
        
    }
    
    private Queue<SearchEngineStep> pendingSearchSteps;
    private Set<ChessGameConfiguration> sucessfullChessGameConfigurations;
    
    public SearchEngine(){
        pendingSearchSteps = new LinkedList<>();
        sucessfullChessGameConfigurations = new HashSet<>();
    }
    
    public ChessGameConfiguration[] search(ChessGameConfiguration cgc,List<? extends Piece> availablePieces){
        
       SearchEngineStep ses = new SearchEngineStep(cgc, availablePieces);
        
       this.pendingSearchSteps.add(ses);
       
       while(!this.pendingSearchSteps.isEmpty()){
           SearchEngineStep ses1 = this.pendingSearchSteps.poll();
           
           Cell[] board = ses1.getCgconfig().getCurrentBoard();
           List<? extends Piece> oldAvailablePieces = ses1.getAvailablePieces();
           
           if(oldAvailablePieces.isEmpty()){
               this.sucessfullChessGameConfigurations.add(ses1.getCgconfig());
           }else{                         
                List<Piece> newAvailablePieces;
                newAvailablePieces = new ArrayList<>(oldAvailablePieces.size());
                
                for(Piece piece:oldAvailablePieces){
                    newAvailablePieces.add(piece);
                }
                
                Piece pieceToPut = newAvailablePieces.remove(0);
                
                
                int cellPosition = 0;

                SearchEngineStep nextSearchStep;
                ChessGameConfiguration nextChessGameConfiguration;
                
                for(Cell boardCell: board){
                    if(boardCell == Cell.DEFAULT_EMPTY_CELL){
                        try{
                            nextChessGameConfiguration = ses1.getCgconfig().putPiece(pieceToPut, cellPosition);
                            nextSearchStep = new SearchEngineStep(nextChessGameConfiguration,newAvailablePieces);
                            
                            this.pendingSearchSteps.add(nextSearchStep);
                        }catch(IllegalMark exception){
                            //Nothing to do.
                            int i = 0;
                        }
                    }

                     cellPosition++;
                }
                }
       }
       
       ChessGameConfiguration[] results;
       int resultSize = this.sucessfullChessGameConfigurations.size();
       results = this.sucessfullChessGameConfigurations.toArray(new ChessGameConfiguration[resultSize]);
       
       return results;
    }
}
