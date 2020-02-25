import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class Experiment11 {

    static Scanner sc = new Scanner(System.in);
    static void Diffie_Hellman(int p,int root)
    {
        Random random = new Random();
        int Xa = random.nextInt(p);
        int Xb = random.nextInt(p);

        BigInteger Root = BigInteger.valueOf(root);
        BigInteger Ya = Root.modPow(BigInteger.valueOf(Xa),BigInteger.valueOf(p));
        BigInteger Yb = Root.modPow(BigInteger.valueOf(Xb),BigInteger.valueOf(p));
        BigInteger Ka = Yb.modPow(BigInteger.valueOf(Xa),BigInteger.valueOf(p));
        BigInteger Kb = Ya.modPow(BigInteger.valueOf(Xb),BigInteger.valueOf(p));

        System.out.println("Key for the first person is : " + Ka);
        System.out.println("key for the second person is : " + Kb);
    }

    public static void main(String[] args) {
        int p,root;
        p = sc.nextInt();
        root = sc.nextInt();
        Diffie_Hellman(p,root);
    }
}
