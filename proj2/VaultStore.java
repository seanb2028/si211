/**
 * @author Sean Beckford
 * Class for storing Data into UserRecords
 */
import java.util.*;
import java.io.*;

public class VaultStore {
	public static List<UserRecord> load(String filename) throws Exception {
		List<UserRecord> records = new ArrayList<>();
		List<String[]> data = new ArrayList<>();
		// Read in the file
		try (Scanner fi = new Scanner(new File(filename))) {
			while (fi.hasNextLine()) {
				String line = fi.nextLine().trim();
				if (line.isEmpty()) continue;

				String[] tokens = line.split("\\s+");
				if (tokens.length != 4 || !(tokens[0].equals("user") || tokens[0].equals("data"))) {
					throw new VaultException("Error! File '" + filename + "' improperly formatted.");
				}
                else if (tokens[0].equals("user")) { 
                    records.add(new UserRecord(tokens[1], tokens[2], tokens[3])); 
                }
				else {
					data.add(tokens);
				}
			}
		}
		catch (FileNotFoundException e) { 
			throw new VaultException("Error! File '" + filename + "' could not be opened."); 
		}

		// Load in data to the matching users
		for (String[] tokens : data) {
			for (UserRecord record : records) {
				if (record.getUser().equals(tokens[1])) {
					record.addData(new UserData(tokens[1], tokens[2], tokens[3]));
					break;
				}
			}
		}
        return records;
	}

    public static void save(String filename, List<UserRecord> records) throws VaultException {
        try (PrintWriter pw = new PrintWriter(new File(filename))) {
            for (UserRecord record : records) {
                pw.printf("user %s %s %s%n", record.getUser(), record.getHMethod(), record.getHPass());
            }
        } catch (FileNotFoundException e) {
            throw new VaultException("Error! File '" + filename + "' could not be opened.");
        }
    }
}