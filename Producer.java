
package os;

import java.util.Random;

/**
 * producer class, is a thread, produce random items to array queue which is
 * in the buffer class
 * 
 * @author Diinkant (ID: 1385134)
 */
public class Producer implements Runnable {
    
    private Buffer buffer;
    protected int count = 0;    //items currently in the buffer
    
    public Producer(Buffer _buffer) {
        setBuffer(_buffer);
    }
     
    public void run(){
        int number = new Random().nextInt(10)+1;   //To figure out sleep time, rand num 1-10 as max 1000ms couldn't figure it out
        int time = number * 1000;  //convert random number to milliseconds
        long threadID = Thread.currentThread().getId(); //Gets the Thread ID
        try {
            Thread.sleep(time); //Sleeps for a random time in milliseconds
            //Thread.sleep((long) (1000 * Math.random()));
        } catch (InterruptedException ex) {
            System.out.println("Sleep Exception");
        }
        //double randomDouble = Math.random();
        //buffer.insert_item(randomDouble, threadId);
               
        if(getBuffer().insert_item(number) == 1){   //insert random number, return 1 then do following
            System.out.println("Producer "+threadID+" produced "+number+"\n");
        } else {
            System.out.println(+threadID+" producer produced nothing\n");
        }
        
        //whats left inside the buffer
        ++this.count;   //increase count by 1
        if (this.count == Constants.BUFFER_SIZE){   //count = buffer size aka full
            System.out.println("The buffer now contains "+count+ " items\n");
        } else {
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
