
public class Quotient extends Function {

    private Function f;
    private Function g;

    public Quotient (Function f,Function g){
        this.f =f;
        this.g =g;
    }
    @Override
    public double valueAt(double point) {
        return (this.f.valueAt(point)) / (this.g.valueAt(point));
    }

    @Override
    public String toString() {
        String string = String.format("(%s / %s)", this.f.toString(), this.g.toString());
        return string;
    }

    /**
     * [f(x)/g(x)]' = [(f'(x)*g(x)-g'(x)*f(x)) / g(x)^2]
     *
     * @return derivative
     */
    @Override
    public Quotient derivative(){
        Product temp1= new Product(this.f.derivative(),this.g); //f'(x)*g(x)
        Product temp2 = new Product(this.g.derivative(),this.f); //g'(x)*f(x)
        Difference numerator = new Difference(temp1, temp2); //f'(x)*g(x)-g'(x)*f(x)
        Power denominator = new Power(this.g, 2); //g(x)^2
        Quotient derivative = new Quotient(numerator,denominator);
        return derivative;
    }

}