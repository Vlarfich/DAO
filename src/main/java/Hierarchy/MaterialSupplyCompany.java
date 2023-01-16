package Hierarchy;

public class MaterialSupplyCompany {
    private int id;
    private String name;
    private String phone;
    private String email;
    private int Buildings_id;
    private int Projects_id;

    public MaterialSupplyCompany(int id, String name, String phone, String email, int buildings_id, int projects_id) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        Buildings_id = buildings_id;
        Projects_id = projects_id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBuildings_id() {
        return Buildings_id;
    }

    public void setBuildings_id(int buildings_id) {
        Buildings_id = buildings_id;
    }

    public int getProjects_id() {
        return Projects_id;
    }

    public void setProjects_id(int projects_id) {
        Projects_id = projects_id;
    }

    @Override
    public String toString() {
        return "MaterialSupplyCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", Buildings_id=" + Buildings_id +
                ", Projects_id=" + Projects_id +
                "}\n";
    }
}
