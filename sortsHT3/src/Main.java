import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        compare[] listaNumeros = new compare[3000];
        compare[] listaOrdenadaPorMerge = new compare[3000];
        compare[] listaOrdenadaPorBubble = new compare[3000];
        compare[] listaOrdenadaPorGnome = new compare[3000];
        compare[] listaOrdenadaPorQuick = new compare[3000];
        compare[] listaOrdenadaPorRadix = new compare[3000];
        WriteFile("./numeros.txt");
        listaNumeros = ReadFile("./numeros.txt");
        sorts mysorts = new sorts();
        listaOrdenadaPorMerge= mysorts.mergeSort(listaNumeros,0,listaNumeros.length-1);
        listaOrdenadaPorBubble= mysorts.bubble(listaNumeros);
        listaOrdenadaPorGnome= mysorts.gnome(listaNumeros, listaNumeros.length);
        listaOrdenadaPorQuick= mysorts.quickSort(listaNumeros,0,listaNumeros.length-1);
        listaOrdenadaPorRadix= mysorts.radixsort(listaNumeros, listaNumeros.length);
        /**
         *         for(compare i: listaOrdenadaPorMerge){
         *             System.out.println(i.getX());
         *         }
         */
    }

    private static compare[] ReadFile(String fileName){

        compare[] textNumbers =  new compare[3000];

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            int i = 0;
            while (line != null){
                compare ln = new compare();
                ln.setX(Integer.parseInt(line));
                textNumbers[i]=ln;
                line = bufferedReader.readLine();
                i++;
            }
        } catch (Exception var10) {
            System.out.println("Error al leer");
        }
        return textNumbers;
    }

    private static void WriteFile(String fileName){
        try{

            File text = new File(fileName);
            FileOutputStream fos = new FileOutputStream(text);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            Random randomNumbers = new Random();
            for (int i = 0; i <= 2999; i++) {
                int num = randomNumbers.nextInt(3001); //generate a random number
                bw.write("" + num ); //write the number to the file
                bw.newLine();
            }

            bw.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
