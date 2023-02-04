package primenumbers;

import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException; 



class semaphore {
    protected int value =0 ;
    protected semaphore() { value =0 ;} 
    protected semaphore(int intial) {value = intial ;}
    public synchronized void P() {
        value-- ;
        if(value<0)
        try{wait();}  catch(InterruptedException e)  {}
    }
    public synchronized void V(){
        value++ ;
        if(value <= 0) notify();
    }

    
}

class buffer {
    private int size = 8 ;
    private Object store[] = new Object[size] ;
    private int inptr = 0 ;   // for producer :in-pointer
    private int outptr =0 ;   // for consumer :out-pointer
    semaphore  spaces = new semaphore (size) ;
    semaphore elements = new semaphore (0) ;
  

 public void produce (Object value){
    spaces.P() ;        // we decrease the space
    store[inptr] = value ;
    inptr = (inptr + 1) % size ;  // (%) in case it was last elemet it will return to the first elemnt
    elements.V() ;       // we increase nu. of elements
 }

 public Object consume() {
    Object value ;
    elements.P() ;          // we decrease elements in the storage
    value = store[outptr] ;
    outptr = (outptr + 1) % size ;
    spaces.V() ;             // we increase the free space
    return value ;
 }

}
//buf.produce(new Integer(i));
 class producer extends Thread {                // producer thread
    buffer buf ;
    
    public producer(buffer buf) {
        this.buf = buf ;
    }

    public void run () {                     // finding prime numbers function
        System.out.print("Enter n value : ");
	    Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();
        System.out.println("Prime numbers between 1 to "+n+" are ");
        List<Integer> aList = new ArrayList();

        for (int i = 2; i <= n; i++) {
            int count = 0;
            for (int j = 2; j <= i / 2; j++) {
             if (i % j == 0) {
              count++;
              break;
             }
            }
        
            if (count == 0) {
                buf.produce(new Integer(i));
                aList.add(i);
            }
         
           }

           try {
            FileWriter myobj = new FileWriter("output.txt");
            for( int i = 0 ; i < aList.size();i++){
                myobj.write(aList.get(i).toString());
                myobj.write(" , ");
            }
            myobj.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
}    
}   
       

 class consumer extends Thread {            // consumer thread
    buffer buf ;
    public consumer(buffer buf) {
        this.buf = buf ;
    }
    public void run () {
        for(int i=0 ; i<100000 ;i++)
        {
           System.out.println(buf.consume()) ;
           
        }
 }
}


class pc {
    static buffer buf = new buffer() ;
    public static void main (String[] args){
        producer p = new producer(buf) ;
        consumer c = new consumer(buf) ;
        p.start();
        c.start();
    }
}


public class App {
    static buffer buf = new buffer() ;
    public static void main(String[] args) throws Exception {
        producer p = new producer(buf) ;
        consumer c = new consumer(buf) ;
        p.start();
        c.start();
    }
}




