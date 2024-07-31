import java.math.*;
public class MyKeyPair {
    public final BigInteger[] publickey;
    public final BigInteger[] privatekey;
    public MyKeyPair(BigInteger[] publickey,BigInteger[] privatekey)
    {
        this.publickey=publickey;
        this.privatekey=privatekey;
    }   
}