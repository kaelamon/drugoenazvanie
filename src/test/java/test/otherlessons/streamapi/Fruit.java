package test.otherlessons.streamapi;

public abstract class Fruit {
    public boolean isFresh;
    public String toDo;

    public Fruit(boolean isFresh, String toDo) {
        this.isFresh = isFresh;
        this.toDo = toDo;
    }

    public void setFresh(boolean fresh) {
        isFresh = fresh;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
    }

    public Fruit() {
    };

}