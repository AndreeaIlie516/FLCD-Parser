package Grammar;

public class Production {
    private String lhs;
    private String rhs;

    public Production(String lhs, String rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public String getLHS() {
        return lhs;
    }

    public String getRHS() {
        return rhs;
    }

    @Override
    public String toString() {
        return lhs + " -> " + rhs;
    }

}
