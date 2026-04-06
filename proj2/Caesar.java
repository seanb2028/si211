/**
 * Implementation of a Caesar cipher encryption algorithm
 * using the Encryptor interface.
 * 
 * @author Sean Beckford
 */
public class Caesar extends ShiftCipher {
    private int shiftAmount; // The calculated k value

    public String getAlgName() { return "caesar"; }
    
    // Calculates the shift amount once based on the key
    public void computeShift() {
        int key_sum = 0;
        for (char c : shift) {
            key_sum += (int) c - 42;
        }
        this.shiftAmount = (18 + key_sum) % 81;
    }

    public void init(char[] key) throws CipherException {
        super.init(key); 
        computeShift();
    }

    protected int getShiftAt(int index) { return shiftAmount; }
}