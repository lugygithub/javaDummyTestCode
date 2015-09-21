// a demo program to get password like `read -s` doing.
// this program get password from user console input from a specific java VM

import java.io.Console;
import java.io.IOError;

public class getConsolePassword{
	public static void main(String[] args){
		Console cons;
		char[] passwd;
		StringBuilder sb = new StringBuilder();
		
		try{
			if ((cons = System.console()) != null &&
				(passwd = cons.readPassword("[%s]", "Password:")) != null) {
					System.out.println("password get: " + sb.insert(0, passwd).toString());
					java.util.Arrays.fill(passwd, ' ');
			}//end if
		} catch(IOError e){
			System.out.println(e);
		}//end catch
	}//end main
}//end getConsolePassword
