public class Power extends Function {
    private Function f1;
    private int power;

    public Power (Function f1,int power){
        this.f1=f1;
        this.power=power;
    }
    @Override
    public double valueAt(double point){
        double result= Math.pow(this.f1.valueAt(point),power);
        return result;
    }
    @Override
    public String toString(){
        String string =String.format("(%s ^ %d)", this.f1.toString(), this.power);
        return string;
    }

    /**
     * @return derivative of this function
     * [(f(x))^n]'=n*f'(x)*[(f(x))^n-1]
     */
    @Override
    public Function derivative() {
        Constant constantPower= new Constant(this.power); //turning the value of the power into a constant function.
        Product temp1= new Product(this.f1.derivative(),constantPower); // temp1= n*f'(x)
        Power temp2 = new Power(this.f1,power-1); // temp2= (f(x))^n-1
        Product derivativePower = new Product(temp1,temp2);// temp1*temp2
        return derivativePower;
    }



}




