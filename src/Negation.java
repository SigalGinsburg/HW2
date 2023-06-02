public class Negation extends Function{
    private Function f1;
    /** we create a negative function */

    public Negation (Function f1){
        this.f1=f1;
    }
    @Override
    public double valueAt(double point){
        return (-1 * this.f1.valueAt(point));
    }
    @Override
    public String toString(){
        String string =String.format("(-%s)", this.f1.toString());
        return string;

    }

    /**
     * -[f'(x)] = -[f(x)]' = -f'(x)
     * The minus operator is calculated separately at "valueAt" and is shown in "toString".
     * @return
     */
    @Override
    public Negation derivative() {
        Negation derivativeNegation = new Negation(this.f1.derivative());
        return derivativeNegation;
    }

}




