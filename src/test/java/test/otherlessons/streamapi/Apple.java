package test.otherlessons.streamapi;

public class Apple extends Fruit {
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Apple(boolean isFresh, String toDo) {
        super(isFresh, toDo);

    }

    public void makeJam() {
        System.out.println("закатываю яблоки в банку");

    }

    @Override
    public String toString() {
        return "Apple{" +
                "isFresh=" + isFresh +
                ", toDo='" + toDo + '\'' +
                '}';
    }
}
