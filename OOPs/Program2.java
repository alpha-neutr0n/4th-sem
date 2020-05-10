//Passing object as parameter to the constructor

package com.company;
import java.util.*;

class address
{
    int street_num;
    String city,state,country;
    address(int street_num,String city,String state,String country)
    {
        this.street_num=street_num;
        this.city=city;
        this.state=state;
        this.country=country;
    }
}

class student
{
    String usn,name;
    address addr;
    student(String usn,String name,address addr)
    {
        this.usn=usn;
        this.name = name;
        this.addr = addr;
    }

}
class college
{
    String name;
    address addr;
    college(String name,address addr){
        this.name =name;
        this.addr=addr;
    }
}

class employee
{
    String EmpID,name;
    address addr;
    employee(String EmpID,String name,address addr){
        this.EmpID=EmpID;
        this.name=name;
        this.addr=addr;
    }
}

public class PGM2{
    public static void main(String[] args)
    {
        int n;
        System.out.println("Enter the number of objects\n");
        Scanner obj=new Scanner(System.in);
        n=obj.nextInt();
        address Addr[]=new address[20];
        student stud[]=new student[20];
        college coll[]=new college[20];
        employee emp[]=new employee[20];
        for(int i=0;i<n;i++) {
            System.out.println("Enter the address details as street number,city, state and country");
            Addr[i] = new address(obj.nextInt(), obj.next(), obj.next(), obj.next());
        }
        for(int i=0;i<n;i++){
            System.out.println("Enter the USN name and address");
            stud[i]=new student(obj.next(), obj.next(), Addr[i]);
        }
        for(int i=0;i<n;i++){
            System.out.println("Enter name and address of the college");
            coll[i]=new college(obj.next(), Addr[i]);
        }
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the employee details as employeee name and address");
            emp[i] = new employee(obj.next(), obj.next(), Addr[i]);
        }
    }
}
