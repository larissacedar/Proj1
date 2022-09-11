package Model;

public class Customer {
    public int id;
    public String name;
    public String petname;

    public Customer(){

    }

    public Customer(int id, String name, String petname) {
        this.id = id;
        this.name = name;
        this.petname = petname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    @Override
    public String toString() {
        return "Customer: " +
                "id: " + id +
                ", name: " + name +
                ", petname: " + petname + "\n";
    }
}
