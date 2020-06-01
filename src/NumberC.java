import java.io.*;
import java.util.ArrayList;

public class NumberC {
    ArrayList<Function> funF = new ArrayList<>();
    ArrayList<Function> funG = new ArrayList<>();
    int m, n;
    int l, ln;

    public static void main(String[] args) throws IOException {
        NumberC numberC = new NumberC();
        numberC.go();
    }

    public void go() throws IOException {
        File file = new File("C:\\Java\\YandexTest\\src\\input.txt");
        reader(file);

        try {
            FileWriter writer = new FileWriter("C:\\Java\\YandexTest\\src\\output.txt");
            // здесь должен быть код, но я не поняла, каким образом применить части n и m. Нужно было применить метод
            // трапеций или прямоугольников, но времени на понимание реализации не осталось
            writer.write(Double.toString(expo()));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reader(File file) throws IOException {

        String line = null;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader buff = new BufferedReader(fileReader);

            String line2 = buff.readLine();
            String [] result2 = line2.split(" ");
            n = Integer.parseInt(result2[0]);
            m = Integer.parseInt(result2[0]);

            String line1 = buff.readLine();
            String [] result1 = line1.split(" ");
            l = Integer.parseInt(result1[0]);
            ln = Integer.parseInt(result1[1]);

            while (!(line = buff.readLine()).equals(line1)) {
                String [] result  = line.split(" ");

                int a = Integer.parseInt(result[0]);
                int b = Integer.parseInt(result[1]);
                int c = Integer.parseInt(result[2]);
                funF.add(new Function(a, b, c));
            }
            line1 = buff.readLine();
            while ((line = buff.readLine()) != null) {
                String [] result  = line.split(" ");

                int a = Integer.parseInt(result[0]);
                int b = Integer.parseInt(result[1]);
                int c = Integer.parseInt(result[2]);
                funG.add(new Function(a, b, c));
            }
            buff.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double expo () {
        double a1 = l; // левая граница интегрирования по x
        double a2 = ln; // правая граница интегрирования по x
        double h = 0.001; // шаг инегрирования
        return integral (a1, a2, h);
    }

    public double integral (double a, double a2, double h) {
        int i, n1;
        double sum;
        double x;

        n1 = (int) (a2 - a) / 2;
        sum = 0.0;

        for (i = 0; i < n1; i++) {
            x = a + i * h + h / 2;
            sum = (funF.get(i).getA() * Math.pow(x,2) + funF.get(i).getB() * x + funF.get(i).getC() - funG.get(i).getA() * Math.pow(x,2) + funG.get(i).getB() * x + funG.get(i).getC());
        }
        return sum;
    }

    public class Function {
        private int a;
        private int b;
        private int c;

        public Function (int aK, int bK, int cK) {
            a = aK;
            b = bK;
            c = cK;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public int getC() {
            return c;
        }
    }
}
