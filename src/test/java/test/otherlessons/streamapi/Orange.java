package test.otherlessons.streamapi;

public class Orange extends Fruit {
    public Orange(boolean isFresh, String toDo) {
        super(isFresh, toDo);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void eatOrange() {
        System.out.println("ем апельсин");
    }

    @Override
    public String toString() {
        return "Orange{" +
                "isFresh=" + isFresh +
                ", toDo='" + toDo + '\'' +
                '}';
    }
}
