package ro.redeul.google.go.lang.psi.visitors;

public class GoElementVisitorWithData<T> extends GoElementVisitor {
    protected T data;

    public GoElementVisitorWithData(T data) {
        this.data = data;
    }

    public GoElementVisitorWithData() {
        this(null);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
