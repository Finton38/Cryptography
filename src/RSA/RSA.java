package RSA;

public class RSA {
    public static void main(String[] args) {
        // 1. Find large primes p and q
        int p = 3;
        int q = 7;

        // 2. Compute n from p and q
        int n = p*q;

        // 3. Compute Phi(n)
        int phi = ((p-1)*(q-1));

        // 4. Find an int e such that 1 < e < Phi(n) 	and gcd(e,Phi) = 1
        int e = 2;
        while (e < phi)
        {
            // e must be co-prime to phi and
            // smaller than phi.
            if (GCD(e, phi)==1)
                break;
            else
                e++;
        }

        // 5. Calculate d where  d = e^(-1) (mod Phi(n))
        // d*e = 1 + k * phi
        int k = 2;  // A constant value
        int d = (1 + (k*phi))/e;

        // Print generated values for reference
        System.out.println("p: " + p);
        System.out.println("q: " + q);
        System.out.println("n: " + n);
        System.out.println("Phi: " + phi);
        System.out.println("e: " + e);
        System.out.println("d: " + d);

        // Cipher text example
        int cipherMessage = (13);

        // Encryption c = (msg ^ e) % n
        int c = (int) Math.pow(cipherMessage, e);
        c = (c % n);
        //System.out.println("Encrypted data = " + c);

        // Decryption m = (c ^ d) % n
        int m = (int) Math.pow(c, d);
        m = (m % n);
        //System.out.println("Original Message Sent = " + m);

        //Final outputs
        System.out.println("Original message: " + m);
        System.out.println("Encrypted: " + c);
        System.out.println("Decrypted: " + m);

    }

    // Returns gcd of a and b
    private static int GCD(int a, int b) {
        if (b==0) return a;
        return GCD(b,a%b);
    }
}