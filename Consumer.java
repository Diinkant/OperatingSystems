
package os;

import java.util.Random;

/**
 * Consumer class, is a thread, gets items from array queue which is
 * in the buffer class
 *
 * @author Diinkant (ID: 1385134)
 */

public class Consumer implements Runnable {
    private Buffer buffer;
    protected int count = Constants.BUFFER_SIZE;
    
    /**
     * object type buffer
     * 
     * @param _buffer 
     */
    
    public Consumer(Buffer _buffer) {
        setBuffer(_buffer); //used the getter and setter encapsulation instead of this.
    }
    
    public void run(){
        while(true){
            int number = new Random().nextInt(10)+1;   //To figure out sleep time, random number 1-10 as max 1000ms couldn't figure it out
            int time = number * 1000;  //convert random number to milliseconds
            long threadID = Thread.currentThread().getId(); //Gets the Thread ID
            try {
                Thread.sleep(time); //Sleeps for a random time in milliseconds
                //Thread.sleep((long) (1000 * Math.random()));
            } catch (InterruptedException ex) {
		System.out.println("Sleep Exception");
            }
            
            Object item = new Object();
            item = getBuffer().remove_item();
            //item = this.buffer.remove_item(threadId);
            if(item != (Object)0){	//No 0 then consume
                System.out.println("Consumer "+threadID+" consumed "+item+"\n");
            }   else {
                System.out.println(+threadID+" consumed nothing\n");
            }
            //how many items are inside the buffer
            --this.count;
            System.out.println("The buffer now contains "+count+ " items\n");
        }
    }
   
     /**
     * 
     * appropriate getters and setters for the variables/for encapsulation
     */
    
    public Buffer getBuffer() {
		return buffer;
	}

	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}
    
}
