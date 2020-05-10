import java.lang.Math;

class circle
{
    public double radius;
    public String color;

    public circle()
    {
        this.radius=2.5;
        this.color="red";
    }

    public circle(double radius)
    {
        this.radius=radius;
        this.color="red";

    }

    public circle(double radius,String color)
    {
        this.radius=radius;
        this.color=color;

    }

    public double getRadius()
    {
        return this.radius;
    }

    public double getArea()
    {
        return Math.PI*radius*radius;
    }

    public String getColor()
    {
        return this.color;
    }

}



class cylinder extends circle
{
    public double height;

    public cylinder()
    {
        super();
        this.height=1.0;
    }

    public cylinder(double height)
    {
        super();
        this.height=height;

    }


    public cylinder(double height,double radius)
    {
        super(radius);
        this.height=height;

    }

    public cylinder(double height,double radius,String color)
    {
        super(radius,color);
        this.height=height;

    }

    public double getHeight()
    {
        return height;
    }

    public double getVolume()
    {
        return getArea()*height;
    }

    public double getArea()
    {
        return 2*Math.PI*radius*height+2*Math.PI*radius*radius;
    }


}



public class PGM3 {

    public static void main(String[] args)
    {
        cylinder c1=new cylinder(2.5);
        System.out.println("radius is:"+c1.getRadius());
        System.out.println("height is :"+c1.getHeight());
        System.out.println("color is :"+c1.getColor());
        System.out.println("base Area is:"+c1.getArea());
        System.out.println("volume is:" +c1.getVolume());

        cylinder c2=new cylinder(2.5,2.5);
        System.out.println("raduis is :" +c2.getRadius());
        System.out.println("height is :"+c2.getHeight());
        System.out.println("color is :"+c2.getColor());
        System.out.println("base Area is:"+c2.getArea());
        System.out.println("volume is:" +c2.getVolume());
        if(c1.getArea()==c2.getArea()&&c1.getVolume()==c2.getVolume()&&c1.getColor()==c2.getColor())
        {
            System.out.println("cylinders are same\n");
        }
        else
        {
            System.out.println("cylinders are different\n");

        }

    }
}
