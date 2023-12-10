package Parser;

public class ModelConfiguration {
    enum StateType {
        q, b, f, e;
    }

    private StateType state;
    private Integer index;
    private StackWrapper workingStack;
    private StackWrapper inputStack;

    public ModelConfiguration(StateType state, int index, StackWrapper workingStack, StackWrapper inputStack) {
        this.state = state;
        this.index = index;
        this.workingStack = workingStack;
        this.inputStack = inputStack;
    }

    // Getter methods
    public StateType getState() {
        return state;
    }

    public Integer getIndex() {
        return index;
    }

    public StackWrapper getWorkingStack() {
        return workingStack;
    }

    public StackWrapper getInputStack() {
        return inputStack;
    }

    // Setter methods
    public void setState(StateType state) {
        this.state = state;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public void setWorkingStack(StackWrapper workingStack) {
        this.workingStack = workingStack;
    }

    public void setInputStack(StackWrapper inputStack) {
        this.inputStack = inputStack;
    }

    // Other methods
    public void incIndex() {
        index++;
    }

    public void decIndex() {
        index--;
    }
}
