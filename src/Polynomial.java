public class Polynomial<T extends Number> extends Function {
    private Double[] polynom;
    private int length;

    public Polynomial(Double... nums) {
        int length = nums.length;
        this.polynom = new Double[length];
        int i = 0;
        for (Double num : nums) {
            this.polynom[i] = num;
            i++;
        }
        this.length=length;
    }
    public Polynomial(double[]nums) {
        int length = nums.length;
        this.polynom = new Double[length];
        int i = 0;
        for (double num : nums) {
            this.polynom[i] = num;
            i++;
        }
        this.length=length;
    }
    public Polynomial pop(){
        int newLength= this.length-1;
        T[] newPolynomT=  new T[newLength];
        newPolynomT[0]=this.polynom[1];
        for (int i=1;i<newLength;i++){
            newPolynomT[i-1]=this.polynom[i];
        }
        Polynomial newPolynom=new Polynomial(newPolynomT);
        return newPolynom;
    }

    @Override
    public Polynomial derivative(){
        int newLength= this.length-1;
        Polynomial derivativePolynom=this.pop();
        double value;
        for (int i=0; i<newLength;i++){
            value = derivativePolynom.polynom[i];
            derivativePolynom.polynom[i] = value * i;
        }
        return derivativePolynom;

    }


    @Override
    public double valueAt(double point) {
        double product = point;
        double value = 0;
        for(int i = 0; i< length; i++){
            value += (polynom[i] * product);
            product = point * product;
        }
        return value;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if(this.polynom[i] == (T) Integer.valueOf(1) && this.polynom[i] == this.polynom[i]){
                string.append(" x^");
                string.append(i);
                string.append(" + ");
            }
            else if (this.polynom[i] == (T) Integer.valueOf(-1) && this.polynom[i] == this.polynom[i]){
                string.append(" -x^");
                string.append(i);
                string.append(" + ");
            }
            else if (this.polynom[i] != (T) Integer.valueOf(0)) {
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
