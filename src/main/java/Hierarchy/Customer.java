package Hierarchy;

public class Customer {
    private int id;
    private String name;
    private String phone;
    private String email;
    private int Projects_id;

    public Customer(int id, String name, String phone, String email, int projects_id) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
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

    public int getProjects_id() {
        return Projects_id;
    }

    public void setProjects_id(int projects_id) {
        Projects_id = projects_id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", Projects_id=" + Projects_id +
                "}\n";
    }
}
