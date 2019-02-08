import java.io.*;
import java.util.Random;
/**
 * Nombre del archivo: sortsHT3
 * Programa que ordena una lista de numeros de 0
 * a 3000, haciendo uso de varios sorts
 * @author Ricardo Valenzuela 18762   Jose Block 18935
 */
public class Main {
    public static void main(String[] args){
        compare[] listaNumeros = new compare[3000];
        compare[] listaOrdenada = new compare[3000];
        WriteFile("./numeros.txt");
        listaNumeros = ReadFile("./numeros.txt");
        sorts mysorts = new sorts();
        listaOrdenada= mysorts.bubble(listaNumeros);
        WriteSortFile("./SortedNumbers.txt", listaOrdenada);
    }


    /**
     * Funcion que lee un archivo e ingresa los datos en una lista de tipo compare
     * @param fileName, nombre del archivo txt
     * @return una lista de tipo compare
     */
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
    /**Funcion que excribe en un archivo 3000 numeros random
     * de 0 a 3000
     * Escribe en un archivo
     * @param fileName, nombre del archivo
     */
    private static void WriteFile(String fileName){
        try{

            File text = new File(fileName);
            FileOutputStream fos = new FileOutputStream(text);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            Random randomNumbers = new Random();
            for (int i = 0; i <= 2999; i++) {
                int num = randomNumbers.nextInt(3001);
                bw.write("" + num );
                bw.newLine();
            }
            bw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Funcion que escribe en un archivo los numeros
     * ya ordenados de una lista de tipo compare
     * @param fileName, nombre del archivo
     * @param list, lista de tipo compare
     */
    private static void WriteSortFile(String fileName, compare[] list){
        try{

            File text = new File(fileName);
            FileOutputStream fos = new FileOutputStream(text);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            for (compare i: list) {
                int num = i.getX();
                bw.write("" + num );
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
