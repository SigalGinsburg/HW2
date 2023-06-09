public abstract class Function {
    public abstract double valueAt(double point);
    @Override
    public abstract String toString();
    public abstract Function derivative();

    /**
     * The methods application is according to the given algorithm
     * @param left represents the left boundary of the functions domain
     * @param right represents the right boundary of the functions domain
     * @return a square rood of a function
     */
    public double bisectionMethod(double left, double right){
        while ((right - left) > (1e-5)){ // epsilon = 1e-5
            double mid = (left + right) / 2;
            if (this.valueAt(left) * this.valueAt(mid) > 0){
                left = mid;
            }
            else right = mid;
        }
        return (left + right) / 2;
    }
    /**
     * The methods application is according to the given algorithm
     * @param left represents the left boundary of the functions domain
     * @param right represents the right boundary of the functions domain
     * @param epsilon represents the wanted level of accuracy
     * @return a square rood of a function
     */
    public double bisectionMethod(double left, double right, double epsilon){
        while ((right - left) > epsilon){
            double mid = (left + right) / 2;
            if (this.valueAt(left) * this.valueAt(mid) > 0){
                left = mid;
            }
            else right = mid;
        }
        return (left + right) / 2;
    }

    /**
     * The methods application is according to the given newton Raphson algorithm
     * @param a a number around which we'll look for the square root of the function
     * @param epsilon represents the wanted level of accuracy
     * @return a square rood of a function
     */
    public double newtonRaphsonMethod(double a, double epsilon){
        double current = a;
        double next = current - (this.valueAt(current) / this.derivative().valueAt(current));
        while (Math.abs(valueAt(current)) >= epsilon){
            current = next;
            next = current - (this.valueAt(current) / this.derivative().valueAt(current));
        }
        return current;
    }
    /**
     * The methods application is according to the given newton Raphson algorithm
     * @param a a number around which we'll look for the square root of the function
     * @return a square rood of a function
     */

    public double newtonRaphsonMethod(double a){
        double current = a;
        double next = current - (this.valueAt(current) / this.derivative().valueAt(current));
        while (Math.abs(valueAt(current)) >= (1e-5)){ // epsilon = 1e-5
            current = next;
            next = current - (this.valueAt(current) / this.derivative().valueAt(current));
        }
        return current;
    }
    public boolean roundToInt(double num){
        if (num==Math.floor(num)){
            return true;
        }
        return false;
    }

    /**
     * this function returns a taylor polynomial of this function
     * @param n represents taylor polynomial of order n
     * @return new Polynomial object
     */
    public Polynomial taylorPolynomial(int n) {
        Function tempDerivative=this;
        double valueAtZero;
        double factorial=1;
        double [] polynomTaylor=new double[n+1]; // creating new array for the new polynomial
        valueAtZero= this.valueAt(0); // first term of taylor polynomial= this polynomial at 0=>f(0)
        polynomTaylor[0]=valueAtZero;
        for (int i=1; i<=n;i++){// derivative this polynomial n times
            tempDerivative=tempDerivative.derivative(); // derivative of order i
            valueAtZero=tempDerivative.valueAt(0); // calculate the value at 0 for the polynomial above
            factorial=factorial*i; // factorial= (1/n!)
            polynomTaylor[i]= valueAtZero/factorial; //(1/n!) * f^(derivative of order i)(0)
        }
        Polynomial taylorPolynomial= new Polynomial(polynomTaylor);
        return taylorPolynomial;
    }






}

