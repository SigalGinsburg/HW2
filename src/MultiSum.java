public class MultiSum extends Function {

    private Function[] multiSumFunctionList;

    public MultiSum(Integer[] functions) {
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MultiSumIterator();
    }
}