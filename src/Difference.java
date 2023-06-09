
public class Difference extends Function {

    private Function f1;
    private Function f2;
    public Difference (Function f1,Function f2) {
        this.f1 = f1;
        this.f2 = f2;
    }
    @Override
    public double valueAt(double point){
        return this.f1.valueAt(point)-this.f2.valueAt(point);
    }

    @Override
    public String toString(){
        String string =String.format("(%s - %s)", this.f1.toString(),this.f2.toString());
        return string;

    }
    /** ((f(x) + g(x))' = f'(x) + g'(x) */
    @Override
    public Difference derivative() {
        Difference derivativeDifference = new Difference(this.f1.derivative(),this.f2.derivative());
        return derivativeDifference;
    }
}