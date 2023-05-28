
public class Product extends Function {
    private Function f1;
    private Function f2;

    public Product(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public double valueAt(double point) {
        return (this.f1.valueAt(point)) * (this.f2.valueAt(point));
    }

    @Override
    public String toString(){
        String string =String.format("(%s * %s)", this.f1.toString(), this.f2.toString());
        return string;

    }
    @Override
    public Product derivative() {

    }


}
