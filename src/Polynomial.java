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
    /**
     * this function creates a string for the polynomial so it can be printed
     * @return the string
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        if (this.length != 0 && this.helpFunctionAllZero()) { // if all array's values are 0
                String result = "(0)";
                return result;
            }
        for (int i = 0; i < length; i++) {
            helpFunctionToString(string, i); // for each index, go to help function that edits the string
        }
        String result = string.toString();
        result = String.format("(%s)", result);

        return result;
    }


    /**
     * help function for the function 'to string'.
     * @param string the string that 'to string' function will return
     * @param num an index at polynomial[] (polynomial[num]=> x^num)
     */
    public void helpFunctionToString(StringBuilder string, int num) {
        if (this.polynom[num] != 0) {
            if (num == 0) {
                helpFunctionToStringFirst(string);// help function that edits the string only for polynomial[0] (=x^0)
                return;
            }
            if (num == 1) {
                helpFunctionToString1(string); // help function that edits the string only for polynomial[1] (=x^1)
                return;
            }
            final double epsilon = Math.pow(10, -20);
            if (this.polynom[num] > epsilon || this.polynom[num] < -epsilon) {
                if (string.length() > 0 && this.polynom[num] > 0) {
                    string.append(" + "); // if polynom[num] > 0, puts "+" before it
                }
                if (string.length() > 0 && this.polynom[num] < 0) {
                    string.append(" - "); // if polynom[num] > 0, puts "-" before it
                }
                if (this.polynom[num] == 1|| this.polynom[num] == -1) {
                    string.append("x^");
                    string.append(num); // add to the string: 'x^'num

                } else if (this.polynom[num] == Math.floor(this.polynom[num])) { // if polynomial[num] is an integer
                    string.append(Math.abs(polynom[num]. // change polynomial[0]'s to its absolut value
                            intValue())); // change polynomial[num]'s type into Int
                    string.append("x^"); // add to the string: 'x^'num
                    string.append(num);

                } else {
                    string.append(Math.abs(this.polynom[num])); // change polynomial[0]'s to its absolut value
                    string.append("x^"); // add to the string: 'x^'num
                    string.append(num);

                }
            }
        }
    }

    /**
     * this is a help function for the function 'to string'
     * @param string the string that the function 'to string' will return.
     the function edits the string only for the first term of the polynomial (polynomial[0]=x^0).
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
                    string.append(this.polynom[0]);
                }
            }
        }

    /**
     * this is a help function for the function 'to string'
     * @param string the string that the function 'to string' will return.
    the function edits the string only for the second term of the polynomial (polynomial[1]=x^1). */

    public void helpFunctionToString1(StringBuilder string) {
        if (this.polynom[1] != 0) {
            if (string.length() > 0) { // if polynomial[0]!=0 => polynomial[1] isn't the beginning of the string.
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
                if (this.polynom[1] == 1) {
                    string.append("x");
                }
                if (this.polynom[1] == -1) {
                        string.append("-x");
                } else {
                    if (this.polynom[1] == Math.floor(this.polynom[1])) { // if polynomial[0] is an integer
                        string.append(polynom[1].intValue()); // change polynomial[0]'s type into Int
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


