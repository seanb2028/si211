/**
 * Encryptor providing the clear algorithm, which is to
 * not change the plaintext at all.
 * 
 * @author Sean Beckford
 */
public class Clear extends ShiftCipher {
    public String getAlgName() { return "clear"; }

    protected int getShiftAt(int index) {
        return 0; // Clear cipher has no shift
    }
}