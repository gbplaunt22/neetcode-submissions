class DynamicArray {
    private int size;
    private int capacity;
    private int[] data;

    public DynamicArray(int capacity) {
        if(capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be > 0");
        }
        this.data = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public int get(int i) {
        return data[i];
    }

    public void set(int i, int n) {
        data[i] = n;
    }

    public void pushback(int n) {
        if (size == capacity) {
            resize();
        }
        data[size] = n;
        size++;
    }

    public int popback() {
        int val = data[size - 1];
        data[size - 1] = 0;
        size--;
        return val;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        int[] newData = new int[newCapacity];
        for(int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
        capacity = newCapacity;
        
        
    }

    public int getSize() {
        return size;

    }

    public int getCapacity() {
        return capacity;
    }
}
