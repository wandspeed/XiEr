package Animal;



public class Cat extends Pet {


    public Cat(String name, String sex, int age,double price) {
        super(name, sex, age,price);
    }

    public static void main(String[] args) {

    }
    @Override
    public void show() {
        System.out.println(this.toString());
    }
    @Override
    public String toString() {
        return "Cat [ name=" + name + ", sex=" + sex + ", age=" + age + ",price="+price+"]";
    }

}
