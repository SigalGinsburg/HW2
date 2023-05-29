public class Polynomial<T extends Number> extends Function {
    private T[] polynom;

    public Polynomial(T... nums) {
        int listLength = nums.length;
        this.polynom = (T[]) new Number[listLength];
        int i = 0;
        for (T num : nums) {
            this.polynom[i] = num;
            i++;
        }
    }

    // Rest of the class implementation
}
