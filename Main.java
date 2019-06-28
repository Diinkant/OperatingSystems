/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class, runs program
 *
 * @author Diinkant (ID: 1385134)
 */

public class Main {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        ArrayList<Thread> threadList = new ArrayList<Thread>(); //array of threads
        
        //The three parameters on the command line
        System.out.println("How long do you want the program to sleep before terminating? (in seconds)"); //in seconds so can * into milliseconds
        int timeSlept = scan.nextInt();
        timeSlept *= 1000;  //change into milliseconds 
        System.out.println("The number of producer threads you want?");
        int producer = scan.nextInt();
        System.out.println("The number of consumer threads you want?");
        int consumer = scan.nextInt();
        
        Buffer bufferthread = new Buffer();         
       
        for(int i=0; i<consumer; i++){
    		threadList.add(new Thread(new Consumer(bufferthread))); //stores user input into array and creates consumer thread based on that.
    	}
       
        for(int i=0; i<producer; i++){
    		threadList.add(new Thread(new Producer(bufferthread))); //stores user input into array and creates producer thread based on that.
    	}
        
        for(int i=0; i<threadList.size(); i++){
    		threadList.get(i).start();	//Starts all the threads in the ArrayList.
    	}
        try {
            Thread.sleep(timeSlept);    //base on user input
	} catch (InterruptedException ex) {
            System.out.println("Sleep Exception");
	}
        
        System.exit(0); //terminates program
    }
    
}
