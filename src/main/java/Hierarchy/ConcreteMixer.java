package Hierarchy;

public class ConcreteMixer {
    private int id;
    private String model;
    private int volume;
    private int Suppler_id;
    private int Projects_id;

    public ConcreteMixer(int id, String model, int volume, int suppler_id, int projects_id) {
        this.id = id;
        this.model = model;
        this.volume = volume;
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

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
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
        return "ConcreteMixer{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", volume=" + volume +
                ", Suppler_id=" + Suppler_id +
                ", Projects_id=" + Projects_id +
                '}' + "\n";
    }
}
