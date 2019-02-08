import java.awt.*;
import java.io.*;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        int[] listaNumeros = new int[3000];
        WriteFile("./numeros.txt");
        listaNumeros = ReadFile("./numeros.txt");
        sorts mysorts = new sorts();
        mysorts.gnome(listaNumeros);

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
            for (int i = 0; i <= 3000; i++) {
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
