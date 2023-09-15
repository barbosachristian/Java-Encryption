public class VigenereCipher {
    private String key;

    public VigenereCipher(String key) {
        this.key = key;
    }

    public String encrypt(String plaintext) {
        StringBuilder ciphertext = new StringBuilder();
        int keyLength = key.length();

        for (int i = 0; i < plaintext.length(); i++) {
            char plainChar = plaintext.charAt(i);
            char keyChar = key.charAt(i % keyLength);

            if (Character.isLetter(plainChar)) {
                char encryptedChar = encryptChar(plainChar, keyChar);
                ciphertext.append(encryptedChar);
            } else {
                ciphertext.append(plainChar);
            }
        }

        return ciphertext.toString();
    }

    public String decrypt(String ciphertext) {
        StringBuilder plaintext = new StringBuilder();
        int keyLength = key.length();

        for (int i = 0; i < ciphertext.length(); i++) {
            char cipherChar = ciphertext.charAt(i);
            char keyChar = key.charAt(i % keyLength);

            if (Character.isLetter(cipherChar)) {
                char decryptedChar = decryptChar(cipherChar, keyChar);
                plaintext.append(decryptedChar);
            } else {
                plaintext.append(cipherChar);
            }
        }

        return plaintext.toString();
    }

    private char encryptChar(char plainChar, char keyChar) {
        int plainOffset = Character.isUpperCase(plainChar) ? 'A' : 'a';
        int keyOffset = Character.isUpperCase(keyChar) ? 'A' : 'a';

        int encryptedChar = ((plainChar - plainOffset + keyChar - keyOffset) % 26) + plainOffset;
        return (char) encryptedChar;
    }

    private char decryptChar(char cipherChar, char keyChar) {
        int cipherOffset = Character.isUpperCase(cipherChar) ? 'A' : 'a';
        int keyOffset = Character.isUpperCase(keyChar) ? 'A' : 'a';

        int decryptedChar = ((cipherChar - cipherOffset - (keyChar - keyOffset) + 26) % 26) + cipherOffset;
        return (char) decryptedChar;
    }

    public static void main(String[] args) {
        String key = "KEY";
        VigenereCipher cipher = new VigenereCipher(key);
        String plaintext = "HELLOWORLD";
        String encryptedText = cipher.encrypt(plaintext);
        String decryptedText = cipher.decrypt(encryptedText);

        System.out.println("Original: " + plaintext);
        System.out.println("Encrypted: " + encryptedText);
        System.out.println("Decrypted: " + decryptedText);
    }
}
//need to implement this algorithm in the GUI
