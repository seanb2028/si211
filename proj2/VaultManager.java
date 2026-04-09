/**
 * @author Sean Beckford
 * This class is the logic hub
 */
import java.util.*;

public class VaultManager {
    private List<Hasher> hashers;
	private List<Encryptor> encryptors;
    private List<UserRecord> records;
    private String filename;

    public VaultManager(String filename) throws Exception {
        this.hashers = new ArrayList<>();
        this.hashers.add(new Padcut());
		this.hashers.add(new ShiftCaesar());
		this.hashers.add(new ShiftVigenere());

		this.encryptors = new ArrayList<>();
		this.encryptors.add(new Clear());
		this.encryptors.add(new Caesar());
		this.encryptors.add(new Vigenere());
		
		this.records = VaultStore.load(filename);
		this.filename = filename;
    }

    // Find the hasher associated with the hasher token in the line
	public Hasher getHasher(String alg) throws VaultException {
        	for (Hasher hasher : hashers) {
			if (hasher.getAlgName().equals(alg)) {
				return hasher;
			}
		}
		throw new VaultException("Error! Hash algorithm '" + alg + "' not supported.");
	}

    // Checks if the password matches with the Hash
	public boolean checkMatch(String username, char[] password) throws VaultException {
		for (UserRecord record : records) {
			if (!record.getUser().equals(username)) { continue; }

			Hasher hash = getHasher(record.getHMethod());

			// Hash and check if it matches the Hash in the file
			try {
				hash.init(password);
				String hashtext = hash.hashInto(password);
				if (hashtext.equals(record.getHPass())) { return true; }
			}
			catch (CipherException e) {
				throw new VaultException("Hashing error: " + e.getMessage());
			}
		}
		return false;
	}

    // For adding a new user
	public void addUser(String user, char[] pass, String alg) throws Exception {
		// Check if username exists
		for (UserRecord record : records) {
			if (record.getUser().equals(user)) {
				throw new VaultException("Error! Username '" + user + "' already in use.");
			}
		}

		// Check if password meets requirements
		for (char c : pass) {
			if (c < 42 || c > 122) {
				throw new VaultException("Error! Invalid symbol '" + c + "' in password.");
			}
		}

		Hasher hasher = getHasher(alg);

		hasher.init(pass);
		String hashedPass = hasher.hashInto(pass);
		
		// Add to list and save to file
		records.add(new UserRecord(user, alg, hashedPass));
		VaultStore.save(filename, records);
	}

	public Encryptor getEncryptor(String encalg) throws VaultException {
		for (Encryptor enc : encryptors) {
			if (enc.getAlgName().equals(encalg)) return enc;
		}
		throw new VaultException("Encryption algorithm '" + encalg + "' not supported.");
	}

	// Decrypts the encrypted text
	public String decrypt(String encalg, String cipher, char[] pass) throws Exception {		
		Encryptor enc = getEncryptor(encalg);
		enc.init(pass);

		return enc.decrypt(cipher);
	}

	public String[] separateText(UserData datum, char[] pass) throws Exception {
		String plaintext = decrypt(datum.getEncMethod(), datum.getEncText(), pass);
		int split = plaintext.indexOf('_');
		if (split == -1) { throw new Exception(); }
		return new String[] { plaintext.substring(0, split), plaintext.substring(split + 1) };
	}

	// Gets the label part of the encrypted text
	public void getLabels(String user, char[] pass) throws Exception {
		for (UserRecord record : records) {
			if (record.getUser().equals(user)) {
				for (UserData datum : record.getData()) {
					try {
						String[] entry = separateText(datum, pass);
						System.out.println(entry[0]);
					} catch (VaultException e) {
						System.out.println("Error! Encryption algorithm '" + datum.getEncMethod() + "' not supported.");
					} catch (Exception e) {
						System.out.println("Error! corrupted entry '" + datum.getEncText() + "' in vault file.");
					}
				}
			}
		}
	}

	// Gets the text part of the encypted text
	public void getLabelText(String user, char[] pass, String target) {
		for (UserRecord record : records) {
			if (record.getUser().equals(user)) {
				for (UserData datum : record.getData()) {
					try {
						String[] entry = separateText(datum, pass);
						String label = entry[0];
						String text = entry[1];
						if (label.equals(target)) {
							System.out.println(text);
							return;
						}
					} catch (VaultException e) {
						System.out.println("Error! Encryption algorithm '" + datum.getEncMethod() + "' not supported.");
					} catch (Exception e) {
						System.out.println("Error! corrupted entry '" + datum.getEncText() + "' in vault file.");
					}
				}
			}
		}
	}
}