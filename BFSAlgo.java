import java.util.*;
// import java.util.ArrayList;

public class BFSAlgo {
  public static Queue<State> frontier;
  public static ArrayList<String> list;
  public static ArrayList<State> exploredList;

  public static State solve(State initialState) {
    frontier = new LinkedList<State>();
    exploredList = new ArrayList<State>();
    list = new ArrayList<String>(initialState.getPossibleActions());

    for (int i=0; i!=list.size(); i++){
      State state = new State(initialState, list.get(i));
      frontier.add(state);
    }

    State currentState = null;
    while(frontier.size()>0){
      currentState = frontier.remove();
      list= currentState.getPossibleActions();
      if(currentState.isWin()){
        return currentState;
      }
      else {
        for (int i=0; i!=list.size(); i++){
          System.out.println("======================================"+list.size());
          State newState = currentState.result(currentState, list.get(i));
          String [][] board = newState.getState();
          if(exploredList.size() == 0){
            exploredList.add(newState);
          }
          for(int j = 0; j!=exploredList.size(); j++){
            System.out.println("======================================"+exploredList.size());
            if(board.toString().equals(exploredList.get(j).getState().toString())){
              System.out.println("ya it in list");
              System.out.println(j);
            }
            else{
              // System.out.println("ya it NOT in list");
              System.out.println(j);
              exploredList.add(newState);
              frontier.add(newState);
            }

          }
        }
      }
    }
    return currentState;
  }
}
