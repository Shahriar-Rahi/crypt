import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class Experiment6 {

    static Scanner sc = new Scanner(System.in);
    static int lehmann(BigInteger n,int t)
    {
        Random rand =  new Random();
        BigInteger a = new BigInteger(500,rand);
        BigInteger x = n.subtract(new BigInteger("1"));
        BigInteger e = x.divide(new BigInteger("2"));
        int bitLength = n.bitLength();
        BigInteger randomNumber;
        while(true)
        {
            randomNumber = new BigInteger(bitLength,rand);
            randomNumber = randomNumber.add(BigInteger.TWO);
            if(randomNumber.compareTo(n) < 0)
              break;
        }

        while(t > 0)
        {
            BigInteger result = randomNumber.modPow(e,n);
            result = result.mod(n);
            if(result.compareTo(BigInteger.ONE) == 0 || result.compareTo(n.subtract(BigInteger.ONE)) == 0)
            {
                while(true)
                {
                    randomNumber = new BigInteger(bitLength,rand);
                    randomNumber = randomNumber.add(BigInteger.TWO);
                    if(randomNumber.compareTo(n) < 0)
                        break;
                }
                t -= 1;
            }
            else return -1;
        }
        return 1;
    }

    public static void main(String[] args) {
         BigInteger N;
         N = sc.nextBigInteger();
         if(N.compareTo(BigInteger.TWO) == 0)
             System.out.println(N + " is a Prime number");
         else if(N.mod(BigInteger.TWO).compareTo(BigInteger.ZERO) == 0)
             System.out.println(N + " is Composite");
         else
         {
             int status = lehmann(N,5);
             if(status == 1)
                 System.out.println( N + " may be Prime");
             else System.out.println(N + " is Composite");
         }
    }
}
