public class Polynomial<T extends Number> extends Function {
    private T[] polynom;
    private int length;

    public Polynomial(T... nums) {
        this.length = nums.length;
        this.polynom = (T[]) new Number[this.length];
        int i = 0;
        for (T num : nums) {
            this.polynom[i] = num;
            i++;
        }
    }

    @Override
    public double valueAt(double point) {
        double product = point;
        double value = 0;
        for(int i = 0; i< length; i++){
            value += ((double)polynom[i] * product);
            product = point * product;
        }
        return value;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if((int)this.polynom[i] == 1 && (double)this.polynom[i] == (int)this.polynom[i]){
                string.append(" x^");
                string.append(i);
                string.append(" + ");
            }
            else if ((int)this.polynom[i] == -1 && (double)this.polynom[i] == (int)this.polynom[i]){
                string.append(" -x^");
                string.append(i);
                string.append(" + ");
            }
            else if ((int)this.polynom[i] != 0) {
                string.append(this.polynom[i].toString());
                string.append(" x^");
                string.append(i);
                string.append(" + ");
            }
        }

        String result = string.toString();
        result = String.format("(%s)", result);

        return result;
    }
}
