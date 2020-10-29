package fr.hoag.repositories.encryptions;

import com.google.common.primitives.Ints;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.security.NoSuchAlgorithmException;

@Converter
public class EncryptionConverter implements AttributeConverter<Integer, Integer> {

    private static final Logger logger = LoggerFactory.getLogger(EncryptionConverter.class);
    private static final String PASSWORD = "P1EJ5JKI7GUID7632HJ";
    private static final IvParameterSpec SEED =  new IvParameterSpec(new byte[16]);


    private static class Key {

        private static final Key instance = new Key();
        private SecretKeySpec secretKey;

        Key() {
            try {
                KeyGenerator generator = KeyGenerator.getInstance("AES");
                generator.init(256) ; // Key size is specified here.
                byte[] key = generator.generateKey().getEncoded();
                secretKey = new SecretKeySpec(key, "AES");
                logger.trace("Secret Key : {}", secretKey);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        public static Key getInstance() {
            return instance;
        }

        public SecretKeySpec getSecretKey() {
            return secretKey;
        }
    }

    @Override
    public Integer convertToDatabaseColumn(Integer id) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, Key.getInstance().getSecretKey(), SEED);
            return Ints.fromByteArray(cipher.doFinal(Ints.toByteArray(id)));
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer convertToEntityAttribute(Integer idDb) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, Key.getInstance().getSecretKey(), SEED);
            return Ints.fromByteArray(cipher.doFinal(Ints.toByteArray(idDb)));
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            throw new RuntimeException(e);
        }
    }


}
