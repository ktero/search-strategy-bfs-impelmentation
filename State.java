import java.util.ArrayList;

public class State {
	
	String stateName;
	int agentPosition, stateValue;
	boolean roomA, roomB;
	State left, right, clean;
	
	public State() {
		// Default constructor
	}
	
	// Identify the initial state of the agent
	public int identifyInputState(int agentPos, boolean roomA, boolean roomB) {
		if(agentPos == 1 && roomA == false && roomB == false)
			return 1;
		else if(agentPos == 2 && roomA == false && roomB == false)
			return 2;
		else if(agentPos == 1 && roomA == false && roomB == true)
			return 3;
		else if(agentPos == 2 && roomA == false && roomB == true)
			return 4;
		else if(agentPos == 1 && roomA == true && roomB == false)
			return 5;
		else if(agentPos == 2 && roomA == true && roomB == false)
			return 6;
		else if(agentPos == 1 && roomA == true && roomB == true)
			return 7;
		else if(agentPos == 2 && roomA == true && roomB == true)
			return 8;
		else
			return 0;
	}
	
	// Set states
	public void setAgentState(State left, State right, State clean, String stateName, int stateValue) {
		this.left  = left;
		this.right = right;
		this.clean  = clean;
		this.stateName = stateName;
		setRoomState(stateValue);
	}
	
	// Set room states
	private void setRoomState(int stateValue) {
		this.stateValue = stateValue;
		if(stateValue == 1) {
			this.agentPosition = 1; this.roomA = false; this.roomB = false;
		} else if(stateValue == 2) {
			this.agentPosition = 2; this.roomA = false; this.roomB = false;
		} else if(stateValue == 3) {
			this.agentPosition = 1; this.roomA = false; this.roomB = true;
		} else if(stateValue == 4) {
			this.agentPosition = 2; this.roomA = false; this.roomB = true;
		} else if(stateValue == 5) {
			this.agentPosition = 1; this.roomA = true; this.roomB = false;
		} else if(stateValue == 6) {
			this.agentPosition = 2; this.roomA = true; this.roomB = false;
		} else if(stateValue == 7) {
			this.agentPosition = 1; this.roomA = true; this.roomB = true;
		} else if(stateValue == 8) {
			this.agentPosition = 2; this.roomA = true; this.roomB = true;
		}
	}

	public String getStateName() {
		return this.stateName;
	}
	
	public ArrayList<State> getStates() {
		ArrayList<State> nextStates = new ArrayList<>();
		
		if(this.left != null)
			nextStates.add(left);
		if(this.right != null) 
			nextStates.add(right);
		if(this.clean != null)
			nextStates.add(clean);
		
		return nextStates;
	}
} 