import java.util.*;
import java.math.BigInteger;
public class Main{
        public static void main(String[] args){
        MyKeyPair key=RSA.generatekey();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter your message");
        String message=scan.nextLine();
        System.out.println("Enter 1 if you wnat to encrypt.");
        System.out.println("Enter 2 if ypu want to encrypt and decrypt");
        int number=scan.nextInt();
        if(number==1)
        {
            BigInteger[] encrypted=RSA.encrypt(message,key.publickey);
            System.out.println("Encrypted message is:");
            for(BigInteger i : encrypted)
            {
                System.out.print(i+" ");
            }
        }
        else{
            BigInteger[] encrypted=RSA.encrypt(message,key.publickey);
            System.out.println("Encrypted message is:");
            for(BigInteger i : encrypted)
            {
                System.out.print(i+" ");
            }
            String decryptedMessage = RSA.decrypt(encrypted, key.privatekey);
            System.out.println("Decrypted message: " + decryptedMessage);
        }
        scan.close();
    }
}