/* a program to show how to run command line commands from a java program
 * 2 ways to do this: 
 * 						(1) from Runtime.exec()
 * 						(2) from ProcessBuilder.strt()
 */

import java.io.IOException;

import java.io.File;; 
import java.io.BufferedReader;
import java.io.InputStreamReader;; 

public class runExternalCmd{

	public static void getOutput(Process ps) throws IOException{
	    String s = null;
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(ps.getInputStream()));
		System.out.println("-----The out put is-----");
			while ((s = stdInput.readLine()) != null){
				System.out.println(s);
			}//end while
		System.out.println("\n");
	}// end getOutPut()


	public static void main(String args[]){
	    try{
			String homeDir =  System.getenv("HOME");
			Process pr;
			String[] cmds;
			File homePath;
			ProcessBuilder pb;

			// way-1: use Runtime.getRuntime()
			System.out.println("-------- way-1 ---------");
			pr = Runtime.getRuntime().exec("pwd"); //set pr from Runtime.exec()
			pr.waitFor();
			getOutput(pr);

			// way-2: use ProcessBuilder
			System.out.println("-------- way-2 ---------");
			cmds = new String[]{"ls","-l"};
			homePath = new File(homeDir);

			pb = new ProcessBuilder(cmds);
			pb.directory(homePath);
			
			pr = pb.start(); // set pr from ProcessBuilder.start()
			pr.waitFor();
			getOutput(pr);
		}//end try
	    catch(NullPointerException e){ System.out.println(e); }
	    catch(InterruptedException e){ System.out.println(e); }
	    catch(IOException e)		 { System.out.println(e); }
	}//end main()
}//end adbrestart class
