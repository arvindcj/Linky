import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

class Parser
{
    File file;

    Parser(String file_path)
    {
	file = new File(file_path);

	try {
	    BufferedReader br = new BufferedReader(new FileReader(file_path));
	    StringBuilder sb = new StringBuilder();
	    String line = br.readLine();
	    
	    while (line != null) {
		sb.append(line);
		sb.append(System.lineSeparator());
		line = br.readLine();
	    }
	    String everything = sb.toString();
	    
	    System.out.println(everything);
	    readEve(everything, 0);

	}
	catch (Exception e){
	    System.out.println(e);
	}
	    
	 finally {
	     // br.close();
	}
	
    }

    // read char by char
    int readEve(String e, int i)
    {
	//System.out.println(i);
	if (e.length() <= i)
	{
	    return e.length();
	}
	System.out.println(e.charAt(i));
	return readEve(e, i+1);
    }
}
