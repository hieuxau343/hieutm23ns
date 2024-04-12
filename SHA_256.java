package security;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA_256 {

    public static String hashString(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        
        byte[] encodedhash = digest.digest(
                input.getBytes(StandardCharsets.UTF_8));

        StringBuilder hexString = new StringBuilder();
        for (byte b : encodedhash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        
        return hexString.toString();
    }

    public static void main(String[] args) {
        String input = "hello, world!";
        
        try {
            String hashedString = hashString(input);
            System.out.println("Chuoi sau ma hoa: " + hashedString);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}