import java.util.Scanner;

public class Main {

    public static void main(String args[]){

    	// Input Section
    	Scanner input = new Scanner(System.in);

    	System.out.println("Enter the initial state of each room where: 1 - Clean | 2 - Dirty");
    	System.out.print("Enter the state of the first room: ");
    	boolean statusA = (input.nextInt() == 1) ? true : false;

    	System.out.print("Enter the state of the second room: ");
    	boolean statusB = (input.nextInt() == 1) ? true : false;

    	System.out.println("Enter the initial position of the vacuum where: 1 - Room A | 2 - Room B");
    	System.out.print("Enter the initial position: ");
    	int position = input.nextInt();
    	input.close();

    	// Create state instances
    	State state1 = new State(), state2 = new State(), state3 = new State(), state4 = new State(),
    			state5 = new State(), state6 = new State(), state7 = new State(), state8 = new State();
    	int iniState = state1.identifyInputState(position, statusA, statusB);
    	// Setup and connect each state
    	state1.setAgentState(state1, state2, state5, "State 1", 1);
    	state2.setAgentState(state1, state2, state4, "State 2", 2);
    	state3.setAgentState(state3, state4, state7, "State 3", 3);
    	state4.setAgentState(state3, state4, state4, "State 4", 4);
    	state5.setAgentState(state5, state6, state5, "State 5", 5);
    	state6.setAgentState(state5, state6, state8, "State 6", 6);
    	state7.setAgentState(state7, state8, state7, "State 7", 7);
    	state8.setAgentState(state7, state8, state8, "State 8", 8);
    	// Run agent
    	switch(iniState) {
	    	case 1:
	    		runAgent(state1, state7, state8);
	    		break;
	    	case 2:
	    		runAgent(state2, state7, state8);
	    		break;
	    	case 3:
	    		runAgent(state3, state7, state8);
	    		break;
	    	case 4:
	    		runAgent(state4, state7, state8);
	    		break;
	    	case 5:
	    		runAgent(state5, state7, state8);
	    		break;
	    	case 6:
	    		runAgent(state6, state7, state8);
	    		break;
	    	case 7:
	    		runAgent(state7, state7, state8);
	    		break;
	    	case 8:
	    		runAgent(state8, state7, state8);
	    		break;
	    	default:
	    		System.out.println("\nInitial state is unknown...");
    	}
    }

    static void runAgent(State state1, State state7, State state8) {
    	if(new Agent(state1, state7, state8).runAlgo() == true)
    		System.out.println("\nAgent achieved goal.");
    	else
    		System.out.println("\nAgent failed to reach goal.");
    }

}
