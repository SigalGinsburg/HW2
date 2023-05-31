public class MultiSum extends Function {

    protected Function[] multiSumFunctionList;
    private int listLength;

    public MultiSum(Function... functions) {
        int listLength = functions.length;
        this.multiSumFunctionList = new Function[listLength];
        int i = 0;
        for (Function f : functions) {
            multiSumFunctionList[i] = f;
            i++;
        }
        this.listLength= listLength;
    }
    @Override
    public double valueAt(double point){
        double resultValueAtMultiSum=0;
        for (int i=0;i<listLength ;i++){
            resultValueAtMultiSum+=multiSumFunctionList[i].valueAt(point);
        }
        return resultValueAtMultiSum;
    }
    @Override
    public MultiSum derivative(){
        Function[] functions=new Function[listLength];
        for (int i=0;i<listLength ;i++){
        functions[i]= multiSumFunctionList[i].derivative();
        }
        MultiSum derivativeMultiSum= new MultiSum(functions);
        return derivativeMultiSum;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("(");
        string.append(this.multiSumFunctionList[0].toString());
        for (int i = 1; i < listLength; i++) {
            String tempString= String.format(" + %s",this.multiSumFunctionList[i].toString());
            string.append(tempString);
        }
        string.append(")");
        String result= string.toString();
        return result;
    }



}


