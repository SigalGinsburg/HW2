public class Constant extends Function{
    private final double constant;

    public Constant(double constant) {
        this.constant = constant;
    }

    @Override
    public double valueAt(double point) {
        return constant;
    }
    @Override
    public Constant derivative() {
        Constant zero = new Constant(0);
        return zero;

    }
    @Override
    public String toString(){
        String zero="0";
        String string =String.format("(%s)",zero );
        return string;
    }


}
