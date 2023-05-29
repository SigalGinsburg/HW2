public class MultiSum extends Function {

    private Function[] multiSumFunctionList;

    public MultiSum(Function... functions) {
        int listLength = functions.length;
        this.multiSumFunctionList = new Function[listLength];
        int i = 0;
        for (Function f : functions) {
            multiSumFunctionList[i] = f;
            i++;
        }
    }
}

