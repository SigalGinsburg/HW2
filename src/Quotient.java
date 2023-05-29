
public class Quotient extends Function {

    private Function f1;
    private Function f2;

    public Quotient (Function f1,Function f2){
        this.f1=f1;
        this.f2=f2;
    }
    @Override
    public double valueAt(double point) {
        return (this.f1.valueAt(point)) / (this.f2.valueAt(point));
    }

    @Override
    public String toString() {
        String string = String.format("(%s / %s)", this.f1.toString(), this.f2.toString());
        return string;
    }

    /**
     * [f(x)/g(x)]' = [(f'(x)*g(x)-g'(x)*f(x)) / g(x)^2]
     *
     * @return derivative
     */
    @Override
    public Quotient derivative(){
        Product temp1= new Product(this.f1.derivative(),this.f2); //f'(x)*g(x)
        Product temp2 = new Product(this.f1,this.f2.derivative()); //g'(x)*f(x)
        Difference numerator = new Difference(temp1, temp2); //f'(x)*g(x)-g'(x)*f(x)
        Power denominator = new Power(this.f2, 2); //g(x)^2
        Quotient derivative = new Quotient(numerator,denominator);
        return derivative;
    }

}