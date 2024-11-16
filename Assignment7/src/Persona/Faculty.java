package Persona;

public class Faculty {
    private String name;
    private String facultyId;

    public Faculty(String name, String facultyId) {
        this.name = name;
        this.facultyId = facultyId;
    }

    public String getName() {
        return name; // 返回 faculty 的名称
    }
}