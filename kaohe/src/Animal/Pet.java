package Animal;

public abstract class Pet {
    protected String name;
    protected String sex;
    protected int age;
    protected double price;

    public Pet(String name, String sex, int age,double price) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.price=price;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }public abstract void show();



}