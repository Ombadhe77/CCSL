import java.util.Scanner;

class Rsa1 {
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static int modInverse(int e, int phi) {
        for (int d = 1; d < phi; d++) {
            if ((e * d) % phi == 1) {
                return d;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of P: ");
        int p = sc.nextInt();
        System.out.print("Enter the value of Q: ");
        int q = sc.nextInt();
        sc.close();

        int n = p * q;
        int phi = (p - 1) * (q - 1);

        System.out.println("n = " + n);
        System.out.println("φ(n) = " + phi);

        int e = 13;
        // while (gcd(e, phi) != 1) {
        //     e++;
        // }
        
        System.out.println("e = " + e);

        int d = modInverse(e, phi);
        if (d == -1) {
            System.out.println("No modular inverse found.");
            return;
        }
        System.out.println("d = " + d);

        int m = 13;
        int c = (int) (Math.pow(m, e) % n);
        System.out.println("Encrypted message = " + c);

        int decryptedM = 1;
        for (int i = 0; i < d; i++) {
            decryptedM = (decryptedM * c) % n;
        }
        System.out.println("Decrypted message = " + decryptedM);
    }
}