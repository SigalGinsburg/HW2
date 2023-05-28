public abstract class Function {
    public abstract double valueAt(double point);
    @Override
    public abstract String toString();
    public abstract Function derivative();
    public double bisectionMethod(double left, double right){
        while ((right - left) > (1e-5)){
            double mid = (left + right) / 2;
            if (this.valueAt(left) * this.valueAt(mid) > 0){
                left = mid;
            }
            else right = mid;
        }
        return (left + right) / 2;
    }
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
    public double newtonRaphsonMethod(double a, double epsilon){
        double current = a;
        double next = current - (this.valueAt(current) / this.derivative().valueAt(current));
        while (Math.abs(valueAt(current)) >= epsilon){
            current = next;
            next = current - (this.valueAt(current) / this.derivative().valueAt(current));
        }
        return valueAt(current);
    }

    public double newtonRaphsonMethod(double a){
        double current = a;
        double next = current - (this.valueAt(current) / this.derivative().valueAt(current));
        while (Math.abs(valueAt(current)) >= (1e-5)){
            current = next;
            next = current - (this.valueAt(current) / this.derivative().valueAt(current));
        }
        return valueAt(current);
    }
    public double taylorPolynomial(int n){

    }
}
