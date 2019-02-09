import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Nombre del archivo: sortsHT3
 * Programa que ordena una lista de numeros de 0
 * a 3000, haciendo uso de varios sorts
 * @author Ricardo Valenzuela 18762   Jose Block 18935
 */
public class Main {
    private static Scanner input;
    public static void main(String[] args){
        input = new Scanner(System.in);
        sorts mysorts = new sorts();
        System.out.println("Cuantos numeros desea ordenar: ");
        String numero = (input.next());
        try{
            int num = Integer.parseInt(numero);
            if(num<=3000&&num>=10){
                WriteFile("./numeros.txt", num);
                compare[] listaNumeros = new compare[num];
                compare[] listaOrdenada = new compare[num];
                listaNumeros = ReadFile("./numeros.txt", num);
                for(int i=0; i<=listaNumeros.length-1; i++){
                    System.out.print(listaNumeros[i].getX()+" ");
                }
                System.out.println(""
                        +"\n"
                        + "Sorts\n"
                        + "1. Quick\n"
                        + "2. Gnome\n"
                        + "3. Merge\n"
                        + "4. Bubble\n"
                        + "5. Radix\n"
                        + "");
                System.out.println("Seleccione una opcion: ");
                String election = input.next();
                listaNumeros = ReadFile("./numeros.txt", num);
                switch (election){
                    case "1":
                        listaOrdenada=mysorts.quickSort(listaNumeros,0,listaNumeros.length-1);
                        WriteSortFile("./SortedNumbers.txt", listaOrdenada);
                        for(compare i: listaOrdenada){
                            System.out.print(i.getX()+" ");
                        }
                        break;
                    case"2":
                        listaOrdenada=mysorts.gnome(listaNumeros,listaNumeros.length);
                        WriteSortFile("./SortedNumbers.txt", listaOrdenada);
                        for(compare i: listaOrdenada){
                            System.out.print(i.getX()+" ");
                        }
                        break;
                    case"3":
                        listaOrdenada=mysorts.mergeSort(listaNumeros,0,listaNumeros.length-1);
                        WriteSortFile("./SortedNumbers.txt", listaOrdenada);
                        for(compare i: listaOrdenada){
                            System.out.print(i.getX()+" ");
                        }
                        break;
                    case"4":
                        listaOrdenada=mysorts.bubble(listaNumeros);
                        WriteSortFile("./SortedNumbers.txt", listaOrdenada);
                        for(compare i: listaOrdenada){
                            System.out.print(i.getX()+" ");
                        }
                        break;
                    case"5":
                        listaOrdenada=mysorts.radixsort(listaNumeros,listaNumeros.length);
                        WriteSortFile("./SortedNumbers.txt", listaOrdenada);
                        for(compare i: listaOrdenada){
                            System.out.print(i.getX()+" ");
                        }
                        break;
                    default:
                        System.out.println("Esa opcion no existe");;
                        break;

                }
            }else{
                System.out.println("Su cantidad ingresada no es permitida");
            }

        }catch(NumberFormatException ex){
            System.out.println("No es un número");
        }
    }


    /**
     * Funcion que lee un archivo e ingresa los datos en una lista de tipo compare
     * @param fileName, nombre del archivo txt
     * @return una lista de tipo compare
     */
    private static compare[] ReadFile(String fileName, int numero){

        compare[] textNumbers =  new compare[numero];

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
    private static void WriteFile(String fileName, int cantidad){
        try{

            File text = new File(fileName);
            FileOutputStream fos = new FileOutputStream(text);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            Random randomNumbers = new Random();
            for (int i = 0; i <= cantidad-1; i++) {
                int num = randomNumbers.nextInt(3001);
                bw.write("" + num );
                if(i!=cantidad-1){
                    bw.newLine();
                }
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
