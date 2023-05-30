public class Constant extends Function {
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
    public String toString() {
        String string;
        if(this.roundToInt(this.constant)) {
            string = String.format("(%s)", (int) this.constant);
        }
        else
        string = String.format("(%s)", this.constant);
        return string;
    }


}
