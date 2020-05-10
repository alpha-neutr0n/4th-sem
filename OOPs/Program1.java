//Constructor and method overloading

package com.company;
import java.util.*;

class Mycomplex
{
    int real;
    int img;
   Mycomplex() {
    real=0;
    img=0;
   }
   Mycomplex(int r,int i) {
    real=r;
    img=i;
   }
   Mycomplex addcomplex(Mycomplex c1,Mycomplex c2){
       Mycomplex temp=new Mycomplex();
       temp.real=c1.real+c2.real;
       temp.img=c1.img+c2.img;
       return temp;
   }
    Mycomplex subcomplex(Mycomplex c1,Mycomplex c2){
        Mycomplex temp=new Mycomplex();
        temp.real=c1.real-c2.real;
        temp.img=c1.img-c2.img;
        return temp;
    }
    void display(){
       System.out.print("The complex number is "+real+"+"+img+"i");
        System.out.println();
    }
}

public class complex {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the real and imaginary part of first complex number");
        int r1 = s.nextInt();
        int i1 = s.nextInt();
        System.out.println("Enter the real and imaginary part of second complex number");
        int r2 = s.nextInt();
        int i2 = s.nextInt();
        Mycomplex c1 = new Mycomplex(r1,i1);
        Mycomplex c2 = new Mycomplex(r2,i2);
        Mycomplex c3 = new Mycomplex();
        c3 = c3.addcomplex(c1, c2);
        c3.display();
        c3 = c3.subcomplex(c1, c2);
        c3.display();
        }
}
