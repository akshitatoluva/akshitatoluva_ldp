import java.security.SecureRandom;
import java.math.BigInteger;
 public class RSA{
    private static final SecureRandom ran = new SecureRandom();
    private static final int B_LEN = 512;
    public static MyKeyPair generatekey()
    {
        BigInteger p=BigInteger.probablePrime(B_LEN/2, ran);
        BigInteger q=BigInteger.probablePrime(B_LEN/2, ran);

        while(p.equals(q))//p!=q
        {
            q = BigInteger.probablePrime(B_LEN / 2, ran);
        } 

        BigInteger n=p.multiply(q);
        BigInteger phi=(p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        BigInteger e=BigInteger.probablePrime(16, ran);
        while(!(e.compareTo(BigInteger.ONE) > 0 || e.gcd(phi).equals(BigInteger.ONE))){
            e=e.add(BigInteger.TWO);//to make sure that e is odd and relatively prime to phi.
        }
        BigInteger d=e.modInverse(phi);

        return new MyKeyPair(new BigInteger[]{e, n}, new BigInteger[]{d, n});
    }

    public static BigInteger[] encrypt(String message,BigInteger[] publickey)
    {
        BigInteger e = publickey[0];
        BigInteger n = publickey[1];

        byte[] bytes = message.getBytes();
        BigInteger[] encrypted = new BigInteger[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            BigInteger m = BigInteger.valueOf(bytes[i] & 0xFF); // Ensure positive value
            encrypted[i] = m.modPow(e, n);
        }
        return encrypted;
    }

    public static String decrypt(BigInteger[] encrypted, BigInteger[] privateKey) {
        BigInteger d = privateKey[0];
        BigInteger n = privateKey[1];

        byte[] decryptedBytes = new byte[encrypted.length];
        for (int i = 0; i < encrypted.length; i++) {
            BigInteger m = encrypted[i].modPow(d, n);
            decryptedBytes[i] = m.byteValue();
        }
        return new String(decryptedBytes);
    }

 }