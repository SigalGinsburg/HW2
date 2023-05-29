
public class Product extends Function {
    private Function f;
    private Function g;

    public Product(Function f, Function g) {
        this.f = f;
        this.g = g;
    }

    @Override
    public double valueAt(double point) {
        return (this.f.valueAt(point)) * (this.g.valueAt(point));
    }

    @Override
    public String toString(){
        String string =String.format("(%s * %s)", this.f.toString(), this.g.toString());
        return string;

    }
    /**
     * @return derivative of this function
     * [f(x)*g(x)]'=[f(x)]'*g(x)+[g(x)]'*f(x)
     */
    @Override
    public Function derivative() {
        Product temp1= new Product(this.f.derivative(), this.g); // temp1= [f(x)]'*g(x)
        Product temp2= new Product(this.g.derivative(), this.f); // temp2= [g(x)]'*f(x)
        Sum derivativeProduct = new Sum(temp1,temp2);// temp1+temp2
        return derivativeProduct;
    }


}
