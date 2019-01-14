import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Agent {
	
	State firstState, goalState1, goalState2;
	
	public Agent(State firstState, State goalState1, State goalState2) {
		this.firstState = firstState;
		this.goalState1 = goalState1;
		this.goalState2 = goalState2;
	}
	
	/*  
	 * Algorithm: Breadth-First Search (BFS)
	 * PSEUDOCODE:
	 * 
	 *  Set State N as the start Node
	 *  Add State N to the Queue
	 *  Add State N to the visited set
	 *  
	 *  If current State is our goal State 
	 * 		return true, else add State 2 and State 3 to our Queue
	 *  	Check State 2 and if it isn’t add both State 4 and State 5 to our Queue. 
	 *  Take the next node from our Queue which should be State 3 and check that.
	 *  If State 3 isn’t the goal node 
	 * 		add State 6 and StateState 7 to our Queue.
	 *  Repeat until goal Node is found.
	 * 
	 */
	public boolean runAlgo() {
		
		// Initialize
		boolean isInitialState = false;
		Queue<State>     queue   = new LinkedList<>();
		ArrayList<State> checked = new ArrayList<>();
		queue.add(this.firstState);
		checked.add(this.firstState);
		
		while(!queue.isEmpty()) {
			State current = queue.remove();
			
			// Display current states
			if(isInitialState == false) {
				isInitialState = true;
				System.out.println("\nInitial State: " + current.stateValue);
			} else 
				System.out.println("\nMove to state " + current.stateValue);
			promptAttributes(current);
			
			if(current.equals(this.goalState1) || current.equals(this.goalState2)) {
				System.out.println("\nFinal State: " + current.stateName);
				return true;
			} else if(current.getStates().isEmpty()) { 
				System.out.println("Final state wasn't found or reached!");
				return false;
			} else {
				System.out.print("Next possible states: ");
				for(State x : current.getStates())
					System.out.print(x.stateName + " ");
				System.out.println();
				queue.addAll(current.getStates());
			}
			checked.add(current);
		}
		return false;
	}
	
	// Display room status for vacuum position, state of room A and B
	private void promptAttributes(State current) {
		System.out.println("Vacuum is in room " + current.agentPosition);
		if(current.roomA == true)
			System.out.println("Room A is clean");
		else
			System.out.println("Room A is dirty");
		
		if(current.roomB == true)
			System.out.println("Room B is clean");
		else
			System.out.println("Room B is dirty");
	}
} 