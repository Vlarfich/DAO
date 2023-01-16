package Hierarchy;

public class ProjectManager {
    private int id;
    private String name;
    private int age;
    private int Projects_id;

    public ProjectManager(int id, String name, int age, int projects_id) {
        this.id = id;
        this.name = name;
        this.age = age;
        Projects_id = projects_id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getProjects_id() {
        return Projects_id;
    }

    public void setProjects_id(int projects_id) {
        Projects_id = projects_id;
    }

    @Override
    public String toString() {
        return "ProjectManager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", Projects_id=" + Projects_id +
                '}' + "\n";
    }
}