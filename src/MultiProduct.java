public class MultiProduct extends Function{
    private Function[] multiProductFunctionList;
    private int length;

    public MultiProduct(Function... functions) {
        this.length = functions.length;
        this.multiProductFunctionList = new Function[this.length];
        int i = 0;
        for (Function f : functions) {
            multiProductFunctionList[i] = f;
            i++;
        }
    }

    @Override
    public double valueAt(double point) {
        int length = this.multiProductFunctionList.length;
        double result = 0;
        for(int i = 0; i < length; i++){
            result += this.multiProductFunctionList[i].valueAt(point);
        }
        return result;
    }

    public MultiProduct copy(){
        MultiProduct copy = new MultiProduct();
        Function[] copyFunctionList = new Function[this.length];
        for(int i=0; i < this.length; i++){
            copyFunctionList[i] = this.multiProductFunctionList[i];
        }
        copy.multiProductFunctionList = copyFunctionList;
        copy.length = this.length;
        return copy;
    }
    private MultiProduct partOfDerivative(int k){
        this.multiProductFunctionList[k] = this.multiProductFunctionList[k].derivative();
        Function temp = this.multiProductFunctionList[k];
        Function[] partOfDerivativeList = new Function[this.length];
        partOfDerivativeList[0] = this.multiProductFunctionList[k];
        // Copy the elements before index k to the new array
        System.arraycopy(this.multiProductFunctionList, 0, partOfDerivativeList, 1, k);
        System.arraycopy(this.multiProductFunctionList, k + 1, partOfDerivativeList,
                k + 1, length - k - 1);
        MultiProduct partOfDerivative = new MultiProduct();
        partOfDerivative.multiProductFunctionList = partOfDerivativeList;
        partOfDerivative.length = this.length;
        return partOfDerivative;
    }


    /**
     * The calculation is done according to the given instructions:
     * We created a multi sum array, where each item is represented by a multi power
     * each multi power in the array contains a certain function's derivative
     * doubled by the rest of the functions
     * @return derivative
     */

    @Override
    public Function derivative() {
        int length = this.multiProductFunctionList.length;
        MultiSum derivative = new MultiSum();
        Function[] derivativeFunctionList = new Function[this.length];
        derivative.multiSumFunctionList = derivativeFunctionList;
        for (int i = 0; i < length; i++) {
            MultiProduct multiProduct = this.copy();
            multiProduct = multiProduct.partOfDerivative(i);
            derivative.multiSumFunctionList[i] = multiProduct;
        }
        return derivative;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        int length = this.multiProductFunctionList.length;
        for (int i = 0; i < length; i++) {
            string.append(this.multiProductFunctionList[i].toString());
            if (i != length - 1) {
                string.append(" * ");
            }
        }

        String result = string.toString();
        result = String.format("(%s)", result);
        return result;
    }

}

