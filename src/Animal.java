public class Animal {
    private String kind;//种类
    private String sex;//性别
    private int age;

    public Animal(){
    }
    public Animal(String kind, String sex, int age){
        this.kind = kind;
        this.sex = sex;
        this.age = age;
    }

    public String getKind(){
        return kind;
    }
    public void setKind(String kind){
        this.kind = kind;
    }

    public String getSex(){
        return sex;
    }
    public void setSex(String sex){
        this.sex = sex;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
}

