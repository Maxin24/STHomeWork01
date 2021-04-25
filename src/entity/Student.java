package entity;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Student {
    private Integer id;
    private String name;
    private Date birDate;
    private Boolean gender;

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirDate() {
        return birDate;
    }

    public void setBirDate(Date birDate) {
        this.birDate = birDate;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public void show(){
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy年MM月dd日" );
        System.out.print("学号:"+this.id+" 姓名:"+this.name+" 生日:"+sdf.format(this.birDate)+" 性别:");
        if(this.gender){
            System.out.println("男");
        }else{
            System.out.println("女");
        }
    }
}
