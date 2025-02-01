package stacklab;

import java.io.*;
import java.util.Stack;


public class Lister {
	
	private File file;
	private boolean showHidden;
	
	public Lister(File f, boolean showH) {
		file = f;
		showHidden = showH;
	}
	
	public void list() {
		//listFilesRecurse(file);
		listFilesStack(file);
	}
    
	private void listFilesRecurse(File f) { //this method prints the names of all of the files
		if(f.isDirectory()) { 				//check if f is a directory
			File[] files = f.listFiles(); //create a list of files of the folder
			for(File file:files) {	//for each file in the files[] file 
				listFilesRecurse(file);	//recurse each file separate the files from the list
			}
		}
		else {
			if(showHidden || !f.isHidden()) { //if it is a file (cannot separate it any further)
				System.out.println(f.getName()); //print the name of the file
			}
		}
			
	}
    
    //fill this in
    private void listFilesStack(File f) {
    	Stack<File> stack = new Stack<>();
    	stack.push(f);
    	while (!stack.isEmpty()) {
    		File directory = stack.pop();
    		if (directory.isDirectory()) {
    			File[] files = directory.listFiles();
    			for (File file : files) {
    				if (file.isDirectory()) {
    					stack.push(file);
    				}
    				else {
    					if(showHidden || !file.isHidden()) { //if it is a file (cannot separate it any further)
    						System.out.println(file.getName()); //print the name of the file
    					}
    				}
    			}
    		}
    		else {
    			if (showHidden || !directory.isHidden()) {
    				System.out.println(directory.getName());
    			}
    		}
    	}
    	
    }
	
	public static void main(String[] args) {
        //replace with a directory of your own
        String directory = "/Users/vaisp/Downloads/VaishnaviPanchal- unofficial transcript";
		File dir = new File(directory);
		Lister l = new Lister(dir,true);
		l.list();
	}

}
