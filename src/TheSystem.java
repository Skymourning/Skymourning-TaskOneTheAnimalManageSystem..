import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class TheSystem {
    public static void main(String[] args) {
        ArrayList<Animal> list = new ArrayList<>();//创建list集合存储动物
        while(true){
            System.out.println("--------欢迎来到动物管理系统--------");
            System.out.println("         1 查看所有动物           ");
            System.out.println("         2 添加动物              ");
            System.out.println("         3 删除动物              ");
            System.out.println("         4 修改动物              ");
            System.out.println("         5 按年龄从大到小查看所有动物");
            System.out.println("         6 退出动物管理系统        ");
            System.out.println("         请输入您的选择：          ");

            Scanner sc = new Scanner(System.in);//输入
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    showAllAnimal(list);// 查看所有动物信息
                    break;
                case 2:
                    addAnimal(list);// 添加动物信息
                    break;
                case 3:
                    deleteAnimal(list); // 删除动物信息
                    break;
                case 4:
                    modifyAnimal(list);// 修改动物信息
                    break;
                case 5:
                    sortByAge(list); // 按照年龄从大到小排序查询
                    break;
                case 6:
                    System.out.println("您已退出");//退出
                    return;

                default:
                    System.out.println("您输入了些奇奇怪怪的东西");
                    break;
            }
        }
    }
    
    public static void showAllAnimal(ArrayList<Animal> list)//查看所有动物
    {
        if (list.size() == 0) {// 判断集合是否非空
            System.out.println("目前集合中没有动物信息可供查询,请重新选择操作");
            return;
        }
        System.out.println("种类\t\t性别\t\t年龄");
        for (int x = 0; x < list.size(); x++)
        {
            Animal a = list.get(x);
            System.out.println(a.getKind() + "\t"+ "\t"+a.getSex() + "\t" +"\t"+ a.getAge() );
        }
    }

    public static void addAnimal(ArrayList<Animal> list) {//添加动物
        Scanner sc = new Scanner(System.in);
        String kind;
        while (true) {
            System.out.println("请输入动物种类：");
            // String kind = sc.nextLine();
            kind = sc.nextLine();
            boolean flag = false;// 判断种类是否重复
            for (int x = 0; x < list.size(); x++) {
                Animal a = list.get(x);
                if (a.getKind().equals(kind)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("您输入的动物已经存在,请重新输入");
            }
            else {
                break; // 结束循环
            }
        }
        System.out.println("请输入动物性别：");
        String sex = sc.nextLine();
        System.out.println("请输入动物年龄：");
        int age = sc.nextInt();
        Animal a = new Animal();
        a.setKind(kind);
        a.setSex(sex);
        a.setAge(age);
        list.add(a);
        System.out.println("成功添加动物");
    }
    public static void deleteAnimal(ArrayList<Animal> list) {//删除动物
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您要删除的动物种类：");
        String kind = sc.nextLine();
        int index = -1;
        for (int x = 0; x < list.size(); x++) {//遍历集合
            Animal a = list.get(x);
            if (a.getKind().equals(kind)) {
                index = x;
                break;
            }
        }
        if (index == -1) {
            System.out.println("您要删除的动物信息不存在,请重新选择");
        } else {
            list.remove(index);
            System.out.println("删除动物成功");
        }
    }
    public static void modifyAnimal(ArrayList<Animal> list) {// 修改动物信息
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您要修改的动物的种类：");
        String kind = sc.nextLine();
        int index = -1;
        for (int x = 0; x < list.size(); x++) {
            Animal a = list.get(x);
            if (a.getKind().equals(kind)) {
                index = x;
                break;
            }
        }
        if (index == -1) {
            System.out.println("您要修改的动物信息不存在,请重新选择");
        }
        else {
            System.out.println("请输入动物新性别：");
            String sex = sc.nextLine();
            System.out.println("请输入动物新年龄：");
            int age = sc.nextInt();
            Animal a = new Animal();
            a.setKind(kind);
            a.setSex(sex);
            a.setAge(age);
            list.set(index, a);
            System.out.println("修改动物信息成功");
        }
    }
    private static void sortByAge(ArrayList<Animal> list ) {//按照年龄从大到小排序
        if (list.size() <= 0) {
            System.out.println("集合中数据为空!!！，请存入数据");
            return;
        }
        ArrayList<Animal> cList = (ArrayList<Animal>) list.clone();
        Collections.sort(cList, new Comparator<Animal>() {
            public int compare(Animal a1, Animal a2) {
                Integer age1 = new Integer(a1.getAge());
                Integer age2 = new Integer(a2.getAge());
                Integer result = age1 < age2 ? 1 : age1 > age2 ? -1 : 0;
                return result;
            }
        });
/*冒泡
            for (int i=0;i<list.size()-1;i++){
                for (int j=i+1;j<list.size()-i;j++) {
                    if (list.get(j-1) > list.get(j)) {
                        Integer tmp = list.get(j-1);
                        list.set((j-1),list.get(j));
                        list.set(j,tmp);
                    }
                }
            }
*/
        System.out.println("种类\t\t性别\t\t年龄");
        for (int x = 0; x < cList.size(); x++)
        {
            Animal a = cList.get(x);
            System.out.println(a.getKind() + "\t"+ "\t"+a.getSex() + "\t" +"\t"+ a.getAge() );
        }
    }
}
