package Animal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    private String names;
    private String times;

    public Customer() {
    }

    public static void main(String[] args) {
        ArrayList<Customer> array = new ArrayList<Customer>();
    }

    public void Time() {
        LocalDate localDate = LocalDate.now();
        System.out.println("最后一个顾客最后光临时间： "+localDate);
    }


    public Customer(String names) {
        this.names = names;

    }

    @Override
    public String toString() {
        return "Customer{" +
                "names='" + names + '\'' +
                '}';
    }

    public  void addCustomer(ArrayList<Customer> array) {
        Scanner sc = new Scanner(System.in);
        String names;
        String times;

        System.out.println("你叫啥名儿");
        names = sc.nextLine();
        System.out.println("来了多少次");
        times = sc.nextLine();
        Customer s = new Customer();
        s.setNames(names);
        s.setTimes(times);
        array.add(s);
        System.out.println("获取用户信息成功");

    } private void setTimes(String times) {
        this.times = times;
    }
    private String getTimes() {
        return times;

    }

    private void setNames(String names) {
        this.names = names;
    }

    private String getNames() {
        return names;

    }
    public static void findAllCustomer(ArrayList<Customer> array){
        System.out.println("姓名\t次数");
        for(int i=0;i< array.size();i++){
            Customer c=array.get(i);
            System.out.println(c.getNames()+"\t"+c.getTimes()+"\t");
        }







    }
}
