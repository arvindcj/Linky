import java.util.*;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

class FSM {

    public static boolean fsm_run(String input_string,
				  int current_node,
				  Table<Integer, Character, Integer> edges,
				  int [] accepting_states) {

	// check if the string is empty
	if(input_string == "") {

	    // Return: true or false if the current_node is accepting.
	    return Arrays.asList(accepting_states).contains(current_node);
	} else {
	    // 
	    char character = input_string.charAt(0);
	    input_string = input_string.substring(1);

	    Linky.logger.info("First character : " + character);
	    Linky.logger.info("Input String : " + input_string);

	    if (input_string.isEmpty()){
		input_string = input_string.concat(" ");
		//	return true;
	    }
	    
	    boolean ek = edges.contains(current_node, character);


	    if (ek == true) {
		current_node = edges.get(current_node, character);

		return fsm_run(input_string,
			       current_node,
			       edges,
			       accepting_states);
		} else {
		return false;
	    }
	}
    }   
}
