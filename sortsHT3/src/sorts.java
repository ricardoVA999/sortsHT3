public class sorts {
    public compare comparar = new compare();
    public int[] gnome(int[] result){
        for (int i = 1; i <= result.length;){

            if (result[i - 1] <= result[i])
                ++i;

            else {

                int tempValue = result[i];
                result[i] = result[i - 1];
                result[i - 1] = tempValue;
                --i;

                if (i == 0)
                    i = 1;

            }
        }
        return result;
    }
}
