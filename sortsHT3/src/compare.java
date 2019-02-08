import java.util.ArrayList;

public class compare implements Comparable<compare> {
    private int x;
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
    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }
}
