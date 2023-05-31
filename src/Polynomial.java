public class Polynomial extends Function {
    private Double[] polynom;
    private int length;

    //    public Polynomial(Double... nums) {
//        int length = nums.length;
//        this.polynom = new Double[length];
//        int i = 0;
//        for (Double num : nums) {
//            this.polynom[i] = num;
//            i++;
//        }
//        this.length=length;
//    }
    public Polynomial(double... nums) {
        int length = nums.length;
        this.polynom = new Double[length];
        int i = 0;
        for (double num : nums) {
            this.polynom[i] = num;
            i++;
        }
        this.length = length;
    }

    public Polynomial pop() {
        int newLength = this.length - 1;
        double[] newPolynomT = new double[newLength];
        for (int i = 1; i <= newLength; i++) {
            newPolynomT[i - 1] = this.polynom[i];
        }
        Polynomial newPolynom = new Polynomial(newPolynomT);
        return newPolynom;
    }

    @Override
    public Polynomial derivative() {
        Polynomial derivativePolynom;
        if (this.length==0){
            derivativePolynom= new Polynomial(0);
            return derivativePolynom;
        }
        int newLength = this.length - 1;
        derivativePolynom = this.pop();
        double value;
        for (int i = 0; i < newLength; i++) {
            value = derivativePolynom.polynom[i];
            derivativePolynom.polynom[i] = value * (i+1);
        }
        return derivativePolynom;

    }


    @Override
    public double valueAt(double point) {
        double product = 1;
        double value = 0;
        for (int i = 0; i < length; i++) {
            value += (polynom[i] * product);
            product = point * product;
        }
        return value;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        if (this.length != 0) {
            if(this.helpFunctionAllZero()){
                String result="(0)";
                return result;
            }
            else
            helpFunctionToStringFirst(string, 0);
        }
        for (int i = 1; i < length; i++) {
            helpFunctionToString(string, i);
        }
        String result = string.toString();
        result = String.format("(%s)", result);

        return result;
    }

    public void helpFunctionToString(StringBuilder string, int num) {
        if (num==1){
            helpFunctionToString1(string,num);
            return;
        }
        if (this.polynom[num] != 0) {
            if (string.length() > 0) {
                string.append(" + ");
            }
            if (this.polynom[num] == 1) {

                string.append("x^");
                string.append(num);
            } else if (this.polynom[num] == -1) {
                string.append("-x^");
                string.append(num);


            }else if (this.polynom[num] == Math.floor(this.polynom[num])) {
                string.append((polynom[num].intValue()));
                    string.append("x^");
                    string.append(num);

                } else {
                string.append(this.polynom[num].toString());
                    string.append("x^");
                    string.append(num);

                }
            }
        }

    public void helpFunctionToStringFirst(StringBuilder string, int num) {
        if (this.polynom[num] != 0) {
            if (this.polynom[num] == 1) {
                string.append(1);
            } else if (this.polynom[num] == -1) {
                string.append(-1);

            } else  if (this.polynom[num] == Math.floor(this.polynom[num])) {
                    string.append((polynom[num].intValue()));
                    //string.append(num);
                } else {
                    string.append(this.polynom[num].toString());
                    //string.append(num);
                }
            }
        }
    public void helpFunctionToString1(StringBuilder string, int num) {
        if (this.polynom[num] != 0) {
            if (string.length() > 0) {
                string.append(" + ");
            }
            if (this.polynom[num] == 1) {

                string.append("x");
            } else if (this.polynom[num] == -1) {
                string.append("-x");


            }else if (this.polynom[num] == Math.floor(this.polynom[num])) {
                string.append((polynom[num].intValue()));
                string.append("x");

            } else {
                string.append(this.polynom[num].toString());
                string.append("x");

            }
        }
    }

    public boolean helpFunctionAllZero(){

        for (int i=0;i<this.length;i++){
            if (this.polynom[i]!=0){
                return false;
            }
        }
    return true;
    }



    }


