package Hierarchy;

public class Bulldozer {
    private int id;
    private String model;
    private int Suppler_id;
    private int Projects_id;

    public Bulldozer(int id, String model, int suppler_id, int projects_id) {
        this.id = id;
        this.model = model;
        Suppler_id = suppler_id;
        Projects_id = projects_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSuppler_id() {
        return Suppler_id;
    }

    public void setSuppler_id(int suppler_id) {
        Suppler_id = suppler_id;
    }

    public int getProjects_id() {
        return Projects_id;
    }

    public void setProjects_id(int projects_id) {
        Projects_id = projects_id;
    }

    @Override
    public String toString() {
        return "Bulldozer{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", Suppler_id=" + Suppler_id +
                ", Projects_id=" + Projects_id +
                '}' + "\n";
    }
}