public abstract class Function {
    public abstract double valueAt(double point);
    @Override
    public abstract String toString();
    public abstract Function derivative();
}
