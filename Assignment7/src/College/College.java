/* 
* To change this license header, choose License Headers in Project Properties. 
* To change this template file, choose Tools | Templates 
* and open the template in the editor. 
*/ 
package College;

import Department.Department;
import Persona.StudentDirectory;
import java.util.ArrayList;

public class College {
    private String name;
    private ArrayList<Department> departments;
    private StudentDirectory studentDirectory;

    public College(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.studentDirectory = new StudentDirectory(); // 初始化共享目录
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public String getName() {
        return name;
    }
}
