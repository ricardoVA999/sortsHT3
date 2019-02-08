public class compare implements Comparable<compare> {
    private int x;

    /**
     * Metodo que compara dos objetos
     * @param o, objeto tipo compare
     * @return un int dependiendo si es mayor, menor o igual
     */
    public int compareTo(compare o) {
        int resultado=0;
        if (this.x<o.x) {
            resultado = -1;
        }
        else if (this.x>o.x) {
            resultado = 1;
        }
        return resultado;
    }

    /**
     * Ingresa un valor a la variable
     * @param x, que es un numero
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Regresa el valor de la variable
     * @return x
     */
    public int getX() {
        return x;
    }
}
