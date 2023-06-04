public class Sum extends Function {
    private Function f1;
    private Function f2;

    public Sum (Function f1,Function f2){
        this.f1=f1;
        this.f2=f2;
    }
    @Override
    public double valueAt(double point){
        return this.f1.valueAt(point)+this.f2.valueAt(point);
    }
    @Override
    public String toString(){
        String string =String.format("(%s + %s)", this.f1.toString(), this.f2.toString());
        return string;

    }
    /** (f(x)+g(x))' = f(x)' + g(x)' */
    @Override
    public Sum derivative() {
        Sum derivativeSum = new Sum(this.f1.derivative(), this.f2.derivative());
        return derivativeSum;
    }

}





