public class Polynomial extends Function {
    private Double[] polynom;
    private int length;

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

    /**this function returns a copy of polynimial[] without the first place of the array*/
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
        if (this.length==0||this.length==1){
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
        double value = polynom[0];
        for (int i = 1; i < length; i++) {
            value += (polynom[i] * Math.pow(point, i));
        }
        return value;
    }

    /**
     * this function creates a string for the polynomial so it can be printed
     * @return the string
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        if (this.length != 0) {
            if (this.helpFunctionAllZero()) {
                String result = "(0)";
                return result;
            } else {
                helpFunctionToStringFirst(string);
            }
        }
        for (int i = 1; i < length; i++) {
            helpFunctionToString(string, i);
        }
        String result = string.toString();
        result = String.format("(%s)", result);

        return result;
    }

    public void helpFunctionToString(StringBuilder string, int num) {
        if (this.polynom[num] != 0) {
            if (num == 1) {
                helpFunctionToString1(string);
                return;
            }
            final double epsilon = Math.pow(10, -20);
            if (this.polynom[num] > epsilon || this.polynom[num] < -epsilon) {
                if (string.length() > 0 && this.polynom[num] > 0) {
                    string.append(" + ");
                }
                if (string.length() > 0 && this.polynom[num] < 0) {
                    string.append(" - ");
                }
                if (this.polynom[num] == 1) {
                    string.append("x^");
                    string.append(num);
                } else if (this.polynom[num] == -1) {
                    string.append("x^");
                    string.append(num);
                } else if (this.polynom[num] == Math.floor(this.polynom[num])) {
                    string.append(Math.abs(polynom[num].intValue()));
                    string.append("x^");
                    string.append(num);

                } else {
                    string.append(Math.abs(this.polynom[num]));
                    string.append("x^");
                    string.append(num);

                }
            }
        }
    }

    /**
     * this is a help function for the function 'to string'
     * @param string the string that the function 'to string' will return.
     the function edits the string only for the first term of the polynomial (polynomial[0]).
     */
    public void helpFunctionToStringFirst(StringBuilder string) {
        if (this.polynom[0] != 0) {
            if (this.polynom[0] == 1) {
                string.append(1);
            } else if (this.polynom[0] == -1) {
                string.append(-1);
            } else  if (this.polynom[0] == Math.floor(this.polynom[0])) { // if polynomial[0] is an integer
                    string.append((polynom[0].intValue())); // change polynomial[0]'s type into Int
            } else {
                    string.append(this.polynom[0].toString());
                }
            }
        }

    /**
     * this is a help function for the function 'to string'
     * @param string the string that the function 'to string' will return.
    the function edits the string only for the second term of the polynomial (polynomial[1]). */

    public void helpFunctionToString1(StringBuilder string) {
        if (this.polynom[1] != 0) {
            if (string.length() > 0) { // if polinomial[0]!=0
                if (this.polynom[1] > 0) {
                    string.append(" + ");
                }
                if (this.polynom[1] < 0) {
                    string.append(" - ");
                }
                if (this.polynom[1] == 1 || this.polynom[1] == -1) {
                    string.append("x");
                } else {
                    if (this.polynom[1] == Math.floor(this.polynom[1])) { // if polynomial[0] is an integer
                        string.append(Math.abs // change polynomial[0]'s to its absolut value
                                (polynom[1].intValue())); // change polynomial[0]'s type into Int
                        string.append("x");

                    } else {
                        string.append(Math.abs(this.polynom[1])); // change polynomial[0]'s to its absolut value
                        string.append("x");
                    }

                }
            }
            else // if polinomial[0]=0
            {
                if (this.polynom[1] < 0) {
                    string.append("-");
                }
                if (this.polynom[1] == 1 || this.polynom[1] == -1) {
                    string.append("x");
                } else {
                    if (this.polynom[1] == Math.floor(this.polynom[1])) { // if polynomial[0] is an integer
                        string.append(polynom[1].intValue());
                        string.append("x");

                    } else {
                        string.append(this.polynom[1]);
                        string.append("x");
                    }

                }
            }


            }
        }
        /** This is a boolean help function that return True if all the coefficients of the polynomial
         * are zero. The function "to string", uses this function.*/
    public boolean helpFunctionAllZero(){
        for (int i=0;i<this.length;i++){
            if (this.polynom[i]!=0){
                return false;
            }
        }
    return true;
    }



    }


