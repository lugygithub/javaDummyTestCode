/* a program to show how to dump environment varaibles of command line commands from a java program
 * 2 ways to do this(they are the same results, since they call the same method to get the environment variables): 
 * 						(1) from System.getenv()
 * 						(2) from ProcessBuilder.environment()
 */

import java.io.IOException;

import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.NoSuchElementException ;

public class dumpExternalCmdEnv{

	public static void dumpEnv(Map<String, String> map) throws IOException{
		String key = null;
		String value = null;
		Set<String> keys = map.keySet();
		Iterator<String> iterator = keys.iterator();

		System.out.println("-----The Environment variables are-----");
		while(iterator.hasNext()){
			try{
				key = iterator.next();
				value = map.get(key);
			}catch(NoSuchElementException e){ System.out.println(e);
			}catch(NullPointerException e){ System.out.println(e);
			}catch(ClassCastException e){ System.out.println(e); }//end catch

			System.out.printf("\033[01;34m%s\033[00m=%s\n", key, value);
		}// end while

		System.out.println("\n");
	}// end getOutPut()


	public static void main(String args[]){
	    try{
			//String homeDir =  System.getenv("HOME");
			Process pr;
			ProcessBuilder pb;
			Map<String, String> env;

			// way-1: use Runtime.getRuntime()
			System.out.println("-------- way-1 ---------");
			env = System.getenv(); // get environment variables from System.getEnv();
			dumpEnv(env);

			// way-2: use ProcessBuilder
			System.out.println("-------- way-2 ---------");
			pb = new ProcessBuilder(""); //empty commad
			env = pb.environment(); // get environment variables from ProcessBuilder.environment()
			dumpEnv(env);
		}//end try
	    catch(NullPointerException e){ System.out.println(e); }
	    //catch(InterruptedException e){ System.out.println(e); }
	    catch(IOException e)		 { System.out.println(e); }
	}//end main()
}//end adbrestart class
