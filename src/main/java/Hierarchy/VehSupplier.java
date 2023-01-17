package Hierarchy;

public class VehSupplier {
    private int id;
    private String name;
    private int Buildings_id;

    public VehSupplier(int id, String name, int projects_id) {
        this.id = id;
        this.name = name;
        Buildings_id = projects_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getBuildings_id() {
        return Buildings_id;
    }

    public void setBuildings_id(int buildings_id) {
        Buildings_id = buildings_id;
    }

    @Override
    public String toString() {
        return "VehSuppliers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Buildings_id=" + Buildings_id +
                '}' + "\n";
    }

    public String simpleString(){
        return id + ",\"" + name + ", " + Buildings_id;
    }
}
