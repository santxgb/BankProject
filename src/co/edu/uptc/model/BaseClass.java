package co.edu.uptc.model;

public class BaseClass {
    protected int id;
    private static int autoId = 0;

    public BaseClass() {
        super();
        this.id = ++autoId;
    }

    public BaseClass(int id) { this.id = id; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }
}
