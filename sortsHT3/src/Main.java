import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        int[] listaNumeros = new int[3000];
        int[] listaOrdenadaPorMerge = new int[3000];
        int[] listaOrdenadaPorBubble = new int[3000];
        int[] listaOrdenadaPorGnome = new int[3000];
        int[] listaOrdenadaPorQuick = new int[3000];
        int[] listaOrdenadaPorRadix = new int[3000];
        WriteFile("./numeros.txt");
        listaNumeros = ReadFile("./numeros.txt");
        sorts mysorts = new sorts();
        listaOrdenadaPorMerge= mysorts.mergeSort(listaNumeros,0,listaNumeros.length-1);
        System.out.println(Arrays.toString(listaOrdenadaPorMerge));
        listaOrdenadaPorBubble= mysorts.bubble(listaNumeros);
        System.out.println(Arrays.toString(listaOrdenadaPorBubble));
        listaOrdenadaPorQuick= mysorts.quickSort(listaNumeros,0,listaNumeros.length-1);
        System.out.println(Arrays.toString(listaOrdenadaPorQuick));
        listaOrdenadaPorRadix= mysorts.radixsort(listaNumeros,listaNumeros.length-1);
        System.out.println(Arrays.toString(listaOrdenadaPorRadix));
        listaOrdenadaPorGnome= mysorts.gnome(listaNumeros);
        System.out.println(Arrays.toString(listaOrdenadaPorGnome));
    }

    private static int[] ReadFile(String fileName){

        int[] textNumbers =  new int[3000];

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            int i = 0;
            while (line != null){
                textNumbers[i]=Integer.parseInt(line);
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
                int num = randomNumbers.nextInt(3000); //generate a random number
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
