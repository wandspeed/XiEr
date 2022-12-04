package Animal;


import java.util.ArrayList;
import java.util.Scanner;

public class Test{

    static Scanner sc = new Scanner(System.in);
    PetShop petShop = new PetShop("蔡老板", 1000);
    Customer customer = new Customer();
    public ArrayList<Customer> array = new ArrayList<>();


    public ArrayList<Customer> getArray() {
        return array;
    }

    public void setArray(ArrayList<Customer> array) {
        this.array = array;
    }

    public Test() {
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.start();
    }

    private void start() {
        while (true) {
            System.out.println(petShop.getName() + " 余额：" + petShop.getRest() + "说：你是要买宠物（1）？还是要出售宠物（2）？还是查看所有宠物（3）？还是随便看看然后离开（4）？歇业（5）？");
            int choise = sc.nextInt();
            switch (choise) {
                case 1:
                    this.buyPetView();
                    customer.addCustomer(array);
                    break;
                case 2:
                    this.purchasePetView();
                    customer.addCustomer(array);
                    break;
                case 3:
                    petShop.showPets();
                    break;
                case 4:
                    System.out.println("谢谢惠顾");
                    break;
                case 5:
                    customer.findAllCustomer(array);
                    customer.Time();
                    System.out.println("余额：" + petShop.getRest());
                    System.exit(0);

                default:
                    System.out.println("你干嘛!!!输错了!!!");
                    break;
            }
        }

    }

    private void purchasePetView() {
        int choise = inputInt("你的宠物是？狗（1），猫（2）");
        switch (choise) {
            case 1:
                purchaseDogView();
                break;
            case 2:
                purchaseCatView();
                break;

            default:
                break;
        }
    }

    private void purchaseCatView() {

        String sex = inputStr("是什么性别的猫？");
        int age = inputInt("猫年龄多大？");
        String name = inputStr("猫取什么名字？");
        int price = inputInt("猫的价格为？");
        Cat cat = new Cat(name, sex, age, price);
        boolean purchasePet = petShop.purchasePet(cat);
        System.out.println(purchasePet ? "收购成功！" : "收购失败！");

    }


    private void purchaseDogView() {

        String sex = inputStr("是什么性别的狗？");
        String name = inputStr("狗取什么名字？");
        int age = inputInt("狗的年龄多大？");
        int price = inputInt("狗的价格为多少");
        boolean inject = Boolean.parseBoolean(inputBoo("是否打疫苗"));

        Dog dog = new Dog(name, sex, age, price, inject);
        boolean purchasePet = petShop.purchasePet(dog);
        System.out.println(purchasePet ? "收购成功！" : "收购失败！");
    }

    private void buyPetView() {
        switch (inputInt("需要买什么宠物？狗（1），猫（2）")) {
            case 1:
                buyDogView();
                break;
            case 2:
                buyCatView();
                break;

            default:
                break;
        }
    }

    private void buyCatView() {
        while (true) {
            String name = inputStr("想要哪只猫咪");
            boolean hasCatName = petShop.hasCatName(name);
            if (!hasCatName) {
                System.out.println("你选择的猫咪本店没有，请重新输入！");
                continue;
            }
            Pet buyCat = petShop.buyCat(name);
            buyCat.show();
            return;
        }
    }

    private void buyDogView() {
        while (true) {
            String name = inputStr("要哪条的狗？");
            boolean hasDogName = petShop.hasDogName(name);
            if (!hasDogName) {
                System.out.println("你选择的狗本店没有，请重新输入！");
                continue;
            }
            Pet buyDog = petShop.buyDog(name);
            buyDog.show();
            return;
        }
    }


    public int inputInt(String tip) {
        System.out.println(tip);
        return sc.nextInt();
    }

    public String inputStr(String tip) {
        System.out.println(tip);
        return sc.next();
    }

    public String inputBoo(String tip) {
        System.out.println(tip);
        return sc.next();
    }
    public class RuntimeException extends Exception {
        public void RuntimeException() {

        }

    }
    public void InsufficientBalance(double rest) throws InsufficientBalanceException {
        if (rest < 0) {
            System.out.println("余额不足无法购买");
        }
    }

    public class InsufficientBalanceException extends RuntimeException {
    }
}
