public class Power extends Function {
    private Function f1;
    private int power;

    public Power (Function f1,int power){
        this.f1=f1;
        this.power=power;
    }
    @Override
    public double valueAt(double point){

    }
    @Override
    public String toString(){
        String string =String.format("((%s)^%d)", this.f1.toString(), this.power);
        return string;

    }
    @Override
    public Function derivative() {
        Constant constantPower= new Constant(this.power);
        Product temp1= new Product(this.f1.derivative(),constantPower);
        Power temp2 = new Power(this.f1,power-1);
        Product derivativePower = new Product(temp1,temp2);
        return derivativePower;
    }



}




