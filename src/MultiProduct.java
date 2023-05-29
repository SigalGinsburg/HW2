public class MultiProduct extends Function{
    private Function[] multiProductFunctionList;

    public MultiProduct(Function... functions) {
        int listLength = functions.length;
        this.multiProductFunctionList = new Function[listLength];
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
        int k = 0;
        MultiSum derivative = new MultiSum();
        MultiProduct multiProduct = new MultiProduct();
        while (k < length * length) {
            for (int i = 0; i < length; i++) {
                Function smallDerivative = this.multiProductFunctionList[i].derivative();
                multiProduct.multiProductFunctionList[k] = smallDerivative;
                k++;
                for (int j = i+1; j < length; j++) {
                    multiProduct.multiProductFunctionList[k] = this.multiProductFunctionList[j];
                    k++;
                }
                derivative.multiSumFunctionList[i] = multiProduct;
            }
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

