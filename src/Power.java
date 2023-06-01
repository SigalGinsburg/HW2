public class Power extends Function {
    private Function f1;
    private int power;

    public Power (Function f1,int power){
        this.f1=f1;
        this.power=power;
    }
    @Override
    public double valueAt(double point){
        double thisVal= this.f1.valueAt(point);
        if (thisVal==0&&power==0)
            return 0;
        double result= Math.pow(thisVal,power);
        return result;
    }
    @Override
    public String toString(){
        String string =String.format("(%s^%d)", this.f1.toString(), this.power);
        return string;
    }

    /**
     * @return derivative of this function
     * [(f(x))^n]'=n*f'(x)*[(f(x))^n-1]
     */
    @Override
    public Function derivative() {
        Constant constantPower=new Constant(this.power); //turning the value of the power into a constant function.
        if(power==0){
            return constantPower;
        }
//        Power temp1 = new Power(this.f1,power-1); // temp1= (f(x))^n-1
//        Product temp2= new Product(temp1,this.f1.derivative()); // temp2= (f(x))^n-1 * f'(x)
//        Product derivativePower = new Product(constantPower,temp2);// n * (f(x))^n-1 * f'(x)
//        return derivativePower;

        Power temp1 = new Power(this.f1,power-1); // temp1= (f(x))^n-1
        MultiProduct derivativePower;
        derivativePower= new MultiProduct(constantPower,temp1, this.f1.derivative());// n * (f(x))^n-1 * f'(x)
        return derivativePower;


    }



}




