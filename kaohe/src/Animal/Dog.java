package Animal;

public class Dog extends Pet {


    private boolean inject;

    public Dog(String name, String sex, int age,double price,boolean inject) {
        super(name,sex, age,price);
        this.inject=inject;
    }

    public boolean isInject() {
        return inject;
    }

    public void setInject(boolean inject) {
        this.inject = inject;
    }
    @Override
    public void show() {
        System.out.println(this.toString());
    }
    @Override
    public String toString() {
        return "Dog [inject=" + inject + ", name=" + name + ", sex=" + sex + ", age=" + age + ",price="+price+"]";
    }

}

