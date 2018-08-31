package commandlineprgct;

import com.google.gson.Gson;

public class TestJSON {

	public static void testJson() {
		
		//testing Maven & adding dependencies.
		
		int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 }; 
		
		Gson gson = new Gson();
		
        System.out.println(gson.toJson(intArray) );
	}

}
