/**
 * @author Sean Beckford
 */
public abstract class ShiftCipher extends Cipher implements Encryptor {
    protected abstract int getShiftAt(int index);

    public String encrypt(String plain) throws CipherException {
         char[] cipher = plain.toCharArray();
        for (int i = 0; i < cipher.length; i++) {
            checkBounds(cipher[i], "plaintext");
            int k = getShiftAt(i); // Polymorphic call
            int p = (int) cipher[i] - 42;
            int c = (p + k) % 81;
          cipher[i] = (char) (42 + c);
      }        return new String(cipher);
    }

   public String decrypt(String cipherText) throws CipherException {
        char[] plain = cipherText.toCharArray();
        for (int i = 0; i < plain.length; i++) {
          checkBounds(plain[i], "ciphertext");
          int k = getShiftAt(i); // Polymorphic call
          int c = (int) plain[i] - 42;
          int p = (c + (81 - k)) % 81;
          plain[i] = (char) (42 + p);
        }
        return new String(plain);
    }
}