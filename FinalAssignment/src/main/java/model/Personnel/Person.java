package model.Personnel;

public class Person {
    private static int idCounter = 1; // 用于生成唯一的 Person ID
    private String personId;          // 人员的唯一 ID
    private String name;              // 人员的名称

    // 构造函数
    public Person(String name) {
        this.name = name;
        this.personId = generatePersonId();
    }

    // 生成唯一的 Person ID
    private String generatePersonId() {
        return "P" + idCounter++;
    }

    // 获取人员 ID
    public String getPersonId() {
        return personId;
    }

    // 获取人员名称
    public String getName() {
        return name;
    }

    // 设置人员名称
    public void setName(String name) {
        this.name = name;
    }

    // 判断是否匹配某个 ID
    public boolean isMatch(String id) {
        return this.personId.equals(id);
    }

    @Override
    public String toString() {
        return "Person[ID: " + personId + ", Name: " + name + "]";
    }
}
