package app;

import entity.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
//问题67 本项目使用的技术不包括日志 无法进行日志记录


/**
 * 问题32
 * @author liujx
 */
public class StudentManager {
//问题7    private static ArrayList<Student> studentList =  new ArrayList<>();
    /**
     * 学生list
     */
    private static ArrayList<Student> studentList =  new ArrayList<>();
    private static int id=1;

    /**
     * 问题11
     * app人口
     */
    public static void app() {
        while (true) {
            System.out.println("请选择操作：");
            System.out.println("**********************************");
            System.out.println("*              1 插入             *");
            System.out.println("*              2 查找             *");
            System.out.println("*              3 删除             *");
            System.out.println("*              4 修改             *");
            System.out.println("*              5 输出             *");
            System.out.println("*              6 退出             *");
            System.out.println("**********************************");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    findAllStudent();
                    break;
                case 6:
                    System.out.println("已退出，谢谢使用！");
                    System.exit(0);
                default:
                    System.out.println("输入有误，请重新输入！");
                    //47
                    sc.close();
                    break;
            }
        }
    }
//问题32
//    /**
//     * 问题11
//     * 检查id是否用过
//     * @param students 学生列别
//     * @param id 待检查的id
//     * @return 是否使用过
//     */
//    public static boolean isUsed(ArrayList<Student> students, Integer id) {
//        for(Student student:students){
//            if(id.equals(student.getId())){
//                return false;
//            }
//        }
//        return true;
//    }


    /**
     * 问题11
     * 增加学生
     */
    public static void addStudent() {

//        int age = 0;  问题32
//        String name = null;
//        Date birDate = null;
//        boolean gender = false;
        Scanner sc = new Scanner(System.in);
        int cnt = 1;
        while (true) {
            Student student = new Student();
            System.out.println("当前是要新增的第" + cnt++ + "个学生：");
            student.setId(id++);
            System.out.println("请输入姓名：");
            student.setName(new Scanner(System.in).nextLine());
            System.out.println("请输入生日(yyyy-MM-dd):");
            if (setNewBirDate(student)) {
                continue;
            }
            String input;
            System.out.println("请输入性别(男/女)：");
            input = new Scanner(System.in).nextLine();
            if ("男".equals(input)) {
                student.setGender(true);
            } else if ("女".equals(input)) {
                student.setGender(false);
            } else {
                System.out.println("输入错误，请重新输入。");
                continue;
            }
            studentList.add(student);
            System.out.println("是否继续新增学生信息,不是请输入0,是请输入1");
            int temp = sc.nextInt();
            if (temp == 0) {
                break;
            }
        }
        //47
        sc.close();
    }

    /**
     * 问题32
     * 为学生对象设置新的生日
     * @param student 学生对象
     * @return 设置结果
     */
    private static boolean setNewBirDate(Student student) {
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
        String input = new Scanner(System.in).nextLine();
        //Date date=null; 问题32
        Date date;
        try {
            date = sdf.parse(input);
        } catch (ParseException e) {
            System.out.println("日期格式错误，请重新输入");
            return true;
        }
        student.setBirDate(date);
        return false;
    }

    /**
     * 问题11
     * 删除学生
     */
    public static void deleteStudent() {
        if (studentList.size() == 0) {
            System.out.println("未查询到学生信息，请先添加学生信息！");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要删除的学生的姓名：");
        String input = sc.nextLine();
        //问题44
//        for (int i = 0; i < studentList.size(); i++) {
        for (Student s:studentList) {
            if (s.getName().equals(input)) {
                studentList.remove(s);
                break;
            }
        }

        System.out.println("删除成功！");
        //47
        sc.close();
    }

    /**
     * 问题11
     * 更新学生
     */
    public static void updateStudent() {
        if (studentList.size() == 0) {
            System.out.println("无学生信息，请添加学生信息");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要修改的学生姓名：");
        String input = sc.nextLine();
//问题32        int index = -1;
        boolean flag=false;
        //for (int i = 0; i < studentList.size(); i++) { 问题32
        for (Student s : studentList) {
            if (s.getName().equals(input)) {
                flag = true;
                System.out.println("请选择你要修改的内容：");
                System.out.println("1.姓名");
                System.out.println("2.生日");
                System.out.println("3.性别");
                System.out.println("0.返回主页面");
                int s1 = sc.nextInt();
                if (s1 == 0) {
                    break;
                } else if (s1 == 1) {
                    System.out.println("请输入新姓名：");
                    Scanner scc = new Scanner(System.in);
                    String name = scc.nextLine();
                    s.setName(name);
                    scc.close();
                } else if (s1 == 2) {
                    System.out.println("请输入生日(yyyy-MM-dd)：");
                    if (setNewBirDate(s)) {
                        continue;
                    }
                } else if (s1 == 3) {
                    System.out.println("请输入性别(男/女)：");
                    String temp = new Scanner(System.in).nextLine();
                    if ("男".equals(temp)) {
                        s.setGender(true);
                    } else if ("女".equals(temp)) {
                        s.setGender(false);
                    } else {
                        System.out.println("输入错误，请重新输入。");
                        continue;
                    }
                } else {
                    System.out.println("您输入的指令有误！将会返回主页面！");
                    break;
                }
//问题32
//                if (flag) {
//                    System.out.println("修改成功！");
//                }
                System.out.println("修改成功！");
                break;
            }
        }
        if(!flag){
            System.out.println("没有这个姓名的人");
        }
        sc.close();
    }

    /**
     * 问题11
     * 查找所有学生
     */
    public static void findAllStudent(){
        if (studentList.size() == 0) {
            System.out.println("未查询到学生信息，请先添加学生信息再进行查看！");
            return;
        }
        System.out.println("所有学生的信息如下：");
        for(Student student:studentList){
            student.show();
        }
    }

    /**
     * 问题11
     * 查找指定学生
     */
    public static void searchStudent(){
        boolean flag =false;
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入要查找的学生的姓名");
        String name=scanner.nextLine();
        for(Student student:studentList){
            if(student.getName().equals(name)){
                student.show();
                flag=true;
            }
        }
        if(!flag){
            System.out.println("未找到该学生");
            //问题32
//            System.out.println("");
        }
        //47
        scanner.close();
    }
}
