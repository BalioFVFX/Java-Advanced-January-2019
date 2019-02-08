import java.util.function.Consumer;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 4;

    private int[] data;
    private int size;
    private int capacity;

    public SmartArray(){
        this.data = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
        this.size = 0;
    }

    public void add(int element){
        if(this.size == this.capacity){
            this.resize();
        }

        this.data[size++] = element;
    }

    public int removeAt(int index){
        if(index < 0 || index > this.size - 1){
            throw new IndexOutOfBoundsException("Index out of bounds for SmartArray with size of " + this.size);
        }
        int element = this.data[index];
        this.shift(index);
        if(this.size * 4 <= this.capacity){
            this.shrink();
        }

        return element;
    }

    public void insert(int index, int element){
        if(index < 0 || index > this.size - 1){
            throw new IndexOutOfBoundsException("Index out of bounds for SmartArray with size of " + this.size);
        }

        if(this.size == this.capacity){
            this.resize();
        }
        this.shiftRight(index);
        this.data[index] = element;
        this.size++;
    }

    public void forEach(Consumer<Integer> consumer){
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }

    public boolean contains(int element){
        for (int i = 0; i < this.size; i++) {
            if(this.data[i] == element){
                return true;
            }
        }
        return false;
    }

    private void shrink() {
        this.capacity /= 2;

        int[] newData = new int[this.capacity];

        for (int i = 0; i < this.size; i++) {
            newData[i] = this.data[i];
        }

        this.data = newData;
    }

    private void shift(int index){
        for (int i = index; i < this.size; i++) {
            this.data[i] = this.data[i + 1];
        }

        this.data[size - 1] = 0;
        this.size--;
    }

    private void shiftRight(int index){
        for (int i = this.size; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
    }

    private void resize(){
        this.capacity = this.capacity * 2;

        int[] newData = new int[this.capacity];

        for (int i = 0; i < this.data.length; i++) {
            newData[i] = this.data[i];
        }

        this.data = newData;
    }
}
