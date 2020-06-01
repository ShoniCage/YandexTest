import java.io.*;
import java.util.ArrayList;

public class NumberB {
    ArrayList<Pallet> array = new ArrayList<Pallet>();

    public static void main(String[] args) throws IOException {
        NumberB numberB = new NumberB();
        numberB.go();
    }

    public void go() throws IOException {
        int k = 0;
        File file = new File("C:\\Java\\YandexTest\\src\\input.txt");
        reader(file);
        try {
            FileWriter writer = new FileWriter("C:\\Java\\YandexTest\\src\\output.txt");
            for (int i = 0; i < array.size(); i++) {
                int not = 1;
                for (int j = 0; j < array.size(); j++) {
                    if (i != j) {
                        if (array.get(i).getLength() <= array.get(j).getLength() && array.get(i).getWidth() <= array.get(j).getWidth()) {
                            not = 0;
                        }
                    }
                }
                if (not != 0) {
                    k++;
                }
            }
            writer.write(Integer.toString(k));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reader(File file) throws  IOException{
        int a, b, n; // a - ширина,  b - длина, n - количество поддонов
        String line = null;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader buff = new BufferedReader(fileReader);

            n = Integer.parseInt(buff.readLine());
            while ((line = buff.readLine()) != null) {
                String[] result = line.split(" ");
                a = Integer.parseInt(result[0]);
                b = Integer.parseInt(result[1]);
                array.add(new Pallet(a, b));
            }
            buff.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public class Pallet {
        private int width;
        private int length;

        public Pallet (int a, int b) {
            width = a;
            length = b;
        }

        public int getLength() {
            return length;
        }

        public int getWidth() {
            return width;
        }
    }
}
