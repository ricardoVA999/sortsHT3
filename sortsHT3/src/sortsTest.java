import junit.framework.TestCase;

public class sortsTest extends TestCase {
    /**
     * JUnit que comprueba que se ordene
     * una lista usando Radix Sort
     */
    public void testRadix() {
        sorts pruebaSorts = new sorts();
        compare a = new compare();
        compare b = new compare();
        compare c = new compare();
        compare d = new compare();
        compare e = new compare();
        a.setX(35);
        b.setX(50);
        c.setX(40);
        d.setX(2);
        e.setX(22);
        compare[] listaNumeros = {a,b,c,d,e};
        pruebaSorts.radixsort(listaNumeros,listaNumeros.length);
        int resutl=listaNumeros[3].getX();
        assertEquals(40, resutl);
    }

    /**
     * JUnit que comprueba que se ordene
     * una lista usando Bubble Sort
     */
    public void testBubble() {
        sorts pruebaSorts = new sorts();
        compare a = new compare();
        compare b = new compare();
        compare c = new compare();
        compare d = new compare();
        compare e = new compare();
        a.setX(35);
        b.setX(50);
        c.setX(40);
        d.setX(2);
        e.setX(22);
        compare[] listaNumeros = {a,b,c,d,e};
        pruebaSorts.bubble(listaNumeros);
        int resutl=listaNumeros[2].getX();
        assertEquals(35, resutl);
    }

    /**
     * JUnit que comprueba que se ordene
     * una lista usando Merge Sort
     */
    public void testMergeSort() {
        sorts pruebaSorts = new sorts();
        compare a = new compare();
        compare b = new compare();
        compare c = new compare();
        compare d = new compare();
        compare e = new compare();
        a.setX(35);
        b.setX(99);
        c.setX(40);
        d.setX(2);
        e.setX(22);
        compare[] listaNumeros = {a,b,c,d,e};
        pruebaSorts.mergeSort(listaNumeros,0,listaNumeros.length-1);
        int resutl=listaNumeros[4].getX();
        assertEquals(99, resutl);
    }

    /**
     * JUnit que comprueba que se ordene
     * una lista usando Gnome Sort
     */
    public void testGnome() {
        sorts pruebaSorts = new sorts();
        compare a = new compare();
        compare b = new compare();
        compare c = new compare();
        compare d = new compare();
        compare e = new compare();
        a.setX(35);
        b.setX(99);
        c.setX(40);
        d.setX(2);
        e.setX(22);
        compare[] listaNumeros = {a,b,c,d,e};
        pruebaSorts.gnome(listaNumeros,listaNumeros.length);
        int resutl=listaNumeros[1].getX();
        assertEquals(22, resutl);
    }

    /**
     * JUnit que comprueba que se ordene
     * una lista usando Quick Sort
     */
    public void testQuickSort() {
        sorts pruebaSorts = new sorts();
        compare a = new compare();
        compare b = new compare();
        compare c = new compare();
        compare d = new compare();
        compare e = new compare();
        a.setX(35);
        b.setX(50);
        c.setX(40);
        d.setX(2);
        e.setX(22);
        compare[] listaNumeros = {a,b,c,d,e};
        pruebaSorts.quickSort(listaNumeros,0,listaNumeros.length-1);
        int resutl=listaNumeros[0].getX();
        assertEquals(2, resutl);
    }
}