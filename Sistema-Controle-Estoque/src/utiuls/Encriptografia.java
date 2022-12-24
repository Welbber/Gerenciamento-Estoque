package utiuls;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encriptografia {

    static MessageDigest algorithm;

    private static Encriptografia instance;

    private static Encriptografia getInstance() throws NoSuchAlgorithmException {
        if (instance == null)
            instance = new Encriptografia();

        return instance;
    }

    private Encriptografia() throws NoSuchAlgorithmException {
        algorithm = MessageDigest.getInstance("SHA-256");
    }

    private static String encriptografaSenha(String senha) {
        byte[] messageDigest = algorithm.digest(senha.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest)
            hexString.append(String.format("%02X", 0xFF & b));

        return hexString.toString();
    }

    public static String encriptografa(String senha) throws NoSuchAlgorithmException {
        return getInstance().encriptografaSenha(senha);
    }
}
