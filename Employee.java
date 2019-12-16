public class Employee {

    private String initials;
    private String position;
    private String email;
    private long phone;
    private float salary;
    private int age;

    Employee(String initials, String position, String email, long phone, float salary, int age){
        this.initials = initials;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    @Override
    public String toString(){
        return String.format( initials, position, email, phone, salary, age);
    }

    public void print(){
        System.out.println(this);
    }


    public static void main(String[] args) {

        Employee[] persArray = new Employee[5];
        persArray[0] = new Employee("James Brown", "Singer", "j@b.com",0000000000, 100, 87);
        persArray[1] = new Employee("Naomi Campbell", "Singer", "n@c.com", 000000000, 200, 49);
        persArray[2] = new Employee("Sting", "Singer", "s@s.com", 00000000, 300, 68);
        persArray[3] = new Employee("Justin Bieber", "unknown", "j@b.com", 00000000, 400, 25);
        persArray[4] = new Employee("Justin Timberlake", "", "kv@primer,ru", 0000000, 500, 38);

        for (int i = 0; i < persArray.length; i++)
            if (persArray[i].age > 40) persArray[i].print();
    }
}






