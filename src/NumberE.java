
import java.util.Scanner;

public class NumberE {
    public static void main(String[] args) {
        NumberE numberE = new NumberE();
        numberE.go();

    }

    public void go() {
        Scanner scan = new Scanner(System.in);
        int n; // длина текста
        int m; // длина кодировки
        byte type; // 1 - зашифровать, 2 - расшифровать
        int[] text;
        int[] pI;

        n = scan.nextInt();
        m = scan.nextInt();
        text = new int[n];

        type = scan.nextByte();

        for (int i = 0; i < text.length; i++) {
            text[i] = scan.nextInt();
        }
        scan.close();
        pI = new int[m];

        for (int i = 0; i < pI.length; i++) {
            pI[i] = i + 1;
        }
        if (type == 1) {
            encrypt(text, pI);
        } else {
            decrypt(text, pI);
        }

        for (int i = 0; i < text.length; i++) {
            System.out.print(text[i] + " ");
        }
    }

    public void encrypt (int [] text, int [] pI) {
        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < pI.length; j++) {
                if (text[i] == pI[j]) {
                    text[i] = j + 1;
                    move(pI, j);
                    break;
                }
            }
        }
    }

    public  void decrypt (int [] text, int [] pI) {
        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < pI.length; j++) {
                if (text[i] == pI[j]) {
                    text[i] = j + 1;
                    move(pI, j);
                    break;
                }
            }
        }
    }

    public void move (int [] pI, int j) {
        int buff;
        int buffer = pI[0];
        pI[0] = pI[j];
        for (int i = 1; j > 0; i++) {
            buff = pI[i];
            pI[i] = buffer;
            buffer = buff;
            j -=1;
        }
    }
}

