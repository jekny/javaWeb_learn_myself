package com.hyw.test.entity;

/**
 * ClassName: stu
 * Description:
 *
 * @Author jekny
 * @Create 2026/4/6 21:43
 * @Version 1.0
 */
public class stu {
    private int id;
    private String name;
    private int age;

    public stu() {
    }

    @Override
    public String toString() {
        return "stu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public int getId() {
        return this.id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public stu(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
