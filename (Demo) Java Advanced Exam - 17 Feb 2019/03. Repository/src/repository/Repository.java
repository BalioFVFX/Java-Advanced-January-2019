package repository;

import java.util.NoSuchElementException;
import java.util.TreeMap;

public class Repository {
    private TreeMap<Integer, Person> data;

    public Repository() {
        this.data = new TreeMap<>();
    }

    public void add(Person person) {
        try{
            int id = this.data.lastKey();
            id++;
            this.data.put(id, person);
        }
        catch (NoSuchElementException e){
            this.data.put(0, person);
        }
    }

    public Person get(int id) {
        return this.data.get(id);
    }

    public boolean update(int id, Person newPerson) {
        if (this.data.get(id) == null) {
            return false;
        }
        this.data.put(id, newPerson);
        return true;
    }

    public boolean delete(int id) {
        if (this.data.get(id) == null) {
            return false;
        }
        this.data.remove(id);
        return true;
    }

    public int getCount() {
        return this.data.size();
    }

}
