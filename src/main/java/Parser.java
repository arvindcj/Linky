import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


abstract class State
{
    String currentToken = "";
    
    public abstract void tokenize(Tokenizer tknzer, char c);
}

/* read characters until "<" */
class DataST extends State
{
    public void tokenize(Tokenizer tknzer, char c) {
	if(c == '<') {
	    tknzer.set_state(new TagOpen());
	} else {
	    currentToken = currentToken + tknzer.getCurrentChar();
	}
	tknzer.setCurrentChar(c);
    }
}

class TagOpen extends State
{
    public void tokenize(Tokenizer tknzer, char ch) {
	//int ch = tknzer.getCurrentChar();
	Linky.logger.info("TagOpen tokenizing Current character:\t" + ch);
	if(ch == '/') {
	    tknzer.set_state(new CloseTag());
	} else if ((ch >= 97 && ch <= 122) || (ch >= 65 && ch <= 90)){
	    tknzer.set_state(new TagName());
	    currentToken = currentToken + tknzer.getCurrentChar();
	}
	tknzer.setCurrentChar(ch);
    }
}

class TagName extends State
{
    public void tokenize(Tokenizer tknzer, char ch) {
	//int ch = tknzer.getCurrentChar();
	Linky.logger.info("TagName tokenizing Current character:\t" + ch);

	if(ch == '>') {
	    tknzer.set_state(new DataST());
	} else if ((ch >= 97 && ch <= 122) || (ch >= 65 && ch <= 90)){
	    currentToken = currentToken + tknzer.getCurrentChar();
	}
	tknzer.setCurrentChar(ch);
    }
}

class CloseTag extends State
{
    public void tokenize(Tokenizer tknzer, char ch) {
	//int ch = Character.getNumericValue(tknzer.getCurrentChar());
	if ((ch >= 97 && ch <= 122) || (ch >= 65 && ch <= 90)){
	    tknzer.set_state(new TagName());
	    currentToken = currentToken + tknzer.getCurrentChar();
	}
	tknzer.setCurrentChar(ch);
    }
}

class Tokenizer
{
    private State currentState;
    private String htmlString;
    private int position;
    private char currentChar;
	
    public Tokenizer(String htmlString)
    {
	this.htmlString = htmlString;
	currentState = new DataST();
    }

    public void set_state(State s){
	Linky.logger.info("DataST tokenizing:\t\t\t\t" + currentState.currentToken);
	currentState = s;
	currentState.tokenize(this, this.getCurrentChar());
    }

    // public void tokenize(){
    //	currentState.tokenize(this);
    //}

    public char getCurrentChar(){
	return currentChar;
    }

    public void setCurrentChar(char c) {
	this.currentChar = c;
    }
    
    public int getPosition(){
	return position;
    }

    public void setPosition(int p){
	position = p;
    }
  
    public void run() {
	int i = 0;
	for(char c: htmlString.toCharArray()){
	    Linky.logger.info("Current Parsed character:\t" + c);
	    Linky.logger.info("Current State:\t" + currentState.getClass());
	    setCurrentChar(c);
	    //setPosition(i);
	    currentState.tokenize(this, c);
	    //i++;
	}
    }
}

class Parser
{
    File file;
    Tokenizer tkn;
    FetchHTTP f;
    String everything;
    
    Parser(String file_path)
    {
	file = new File(file_path);
	
	f = new FetchHTTP();

	try {
	    everything = f.fetchHTML("http://127.0.0.1:8080/testdata01.html");
		

	    Linky.logger.info("String to be Parsed \n" + everything + "\n\n");
	    tkn = new Tokenizer(everything);
	    tkn.run();
	    System.out.println("inside parser");
	    //readEve(everything, 0);

	}
	catch (Exception e){
	    System.out.println(e);
	}
	    
	 finally {
	     // br.close();
	}
	
    }

}

