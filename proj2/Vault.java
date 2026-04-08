/**
 * @author Sean Beckford
 * Main class that handles the I/O of the program
 */
import java.util.*;
import java.io.*;

public class Vault {
	public static void main(String[] args) {
		try {
			if (args.length == 0 || args.length > 2) {
				throw new VaultException("usage: java Vault [-au] <filename>");
			}

			boolean addMode = args[0].equals("-au");
			String filename = addMode ? args[1] : args[0];

			VaultManager v = new VaultManager(filename);
		
			if (addMode) {
				System.out.print("username: ");
				String user = System.console().readLine();
				System.out.print("password: ");
				char[] pass = System.console().readPassword();
				System.out.print("Hash algorithm: ");
                String alg = System.console().readLine();
				v.addUser(user, pass, alg);
				return; // exit after adding user
			}

			System.out.print("username: ");
			String user = System.console().readLine();
			System.out.print("password: ");
			char[] pass = System.console().readPassword();

			if (!v.checkMatch(user, pass)) { 
				System.out.println("Access denied!");
				System.exit(0);
			}
			System.out.println("Access granted!");

			while (true) {
				System.out.print("> ");
				String s = System.console().readLine();
				String[] cmd = s.trim().split("\\s+");

				if (cmd[0].equals("quit")) { break; }
				else if (cmd[0].equals("labels")) {
					v.getLabels(user, pass);
				}
				else if (cmd[0].equals("get")) { // WIP
					if (cmd.length > 2) { continue; }
					v.getLabelText(user, pass, cmd[1]);
				}
				else { System.out.println("Unknown command '" + s + "'."); }
			}
		}
		catch (VaultException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		catch (Exception e) {
			System.out.println("An unexpected error occured: " + e.getMessage());
			System.exit(1);
		}
	}
}
