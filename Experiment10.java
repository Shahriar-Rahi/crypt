

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.Vector;

public class Experiment10 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger p,q,n,z,encrypt_mess;
        Vector encrypt_messages = new Vector<BigInteger>();
        System.out.println("Enter two prime numbers : ");
        p = sc.nextBigInteger();
        q = sc.nextBigInteger();
        n = p.multiply(q);
        z = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger encrption_key = BigInteger.TWO;

       for(;encrption_key.compareTo(z) < 0; encrption_key = encrption_key.add(BigInteger.ONE))
        {
            if(encrption_key.gcd(z).compareTo(BigInteger.ONE) == 0)
                break;
        }
        BigInteger decryption_key = encrption_key.modInverse(z);
        int block_size = n.toString().length() - 1;
        String message;
        System.out.println("Enter the message to encrypt : ");
        sc.nextLine();
        message = sc.nextLine();
        String block = "",final_block = "";
        int cnt = 0;
         //encryption process starts from here
        System.out.println("Encrypted message is : ");
        for(int i = 0; i < message.length(); i++)
        {
            ++cnt;
            block += message.charAt(i);
            if(cnt % block_size == 0)
            {
                encrypt_mess = new BigInteger(block);
                encrypt_mess = encrypt_mess.modPow(encrption_key,n);
                System.out.println(encrypt_mess);
                encrypt_messages.add(encrypt_mess);
                block = "";
            }
        }

        if(block != "")
        {
            encrypt_mess = new BigInteger(block);
            encrypt_mess = encrypt_mess.modPow(encrption_key,n);
            System.out.println(encrypt_mess);
            encrypt_messages.add(encrypt_mess);
        }
        //decryption process starts here
        String decrypt_mess = "";

        for(int i = 0; i < encrypt_messages.size(); i++)
        {
            BigInteger result = (BigInteger) encrypt_messages.elementAt(i);
            result = result.modPow(decryption_key,n);
            decrypt_mess += String.valueOf(result);
        }

        System.out.println("Decrypted message is : " + decrypt_mess);
    }
}
