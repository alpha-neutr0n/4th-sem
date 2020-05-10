// Demonstration of multithreading in java

import java.util.ArrayList;
import java.util.Scanner;

class Market {
    ArrayList<String> fruits = new ArrayList<>();
    int fruitsNumber;

    // make a constructor to get set the fruit number on initializing the
    public Market(int fruitsNumber) {
        if (fruitsNumber > 0) {
            this.fruitsNumber = fruitsNumber;
            System.out.println(fruits.size());
            System.out.println(fruitsNumber);
        } else {
            throw new IllegalArgumentException("NV");
        }
    }

    // check if their is no place or its full //
   /* private synchronized boolean isFull() {
        boolean b = fruits.size() == this.fruitsNumber;
        System.out.println(b);
        return b;
    }*/
   /* private synchronized boolean isEmpty() {
        return fruits.isEmpty();}*/
    // consumer and producer methods // the main program
    public synchronized void farmer() {
        for (int i = 0; i < this.fruitsNumber; i++) {

            if (fruits.size() == this.fruitsNumber) {
                System.out.println("We cannot accept more fruits at the moment !!");
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Interruption");
                }
            } else
                System.out.println("Enter the fruit to be added");
            Scanner sc = new Scanner(System.in);
            String fruit = sc.next();
            fruits.add(fruit);
            System.out.printf("fruit : %s is added !!!%n", fruit);
            notify();
        }
    }

    public synchronized void consumer() {
        for (int i = 0; i < this.fruitsNumber; i++) {
            if (fruits.size() == 0) {
                System.out.println("we don't have any goods yet");
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("interruption occured !!!");
                }
            }
            String currentFruitRecusted = fruits.remove(0);
            System.out.println(" " + currentFruitRecusted);
            notifyAll();
            //return currentFruitRecusted;
        }
    }
}
class Farmer extends Thread
{
    Market m;
    Farmer (Market m)
    {
        this.m = m;
    }
    public void run()
    {
        m.farmer();
    }
}
class Customer extends Thread
{
    Market m;
    Customer (Market m)
    {
        this.m = m;
    }

    public void run()
    {
        m.consumer();
    }
}
public class Pgm7 {
    public static void main(String[] args)
    {
        Market superMarket = new Market(10);
        Farmer f  = new Farmer(superMarket);
        Customer c = new Customer(superMarket);
        f.start();
        c.start();
    }
}
