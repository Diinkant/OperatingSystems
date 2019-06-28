
package os;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore; 
import static os.Constants.BUFFER_SIZE;

/**
 *
 * @author Diinkant (ID: 1385134)
 */
public class Buffer {
    
    private Semaphore empty;
    private Semaphore full;
    private Semaphore mutex;
    ArrayBlockingQueue<Object> list = new ArrayBlockingQueue<Object>(BUFFER_SIZE);  //stores elements internally FIFO (first in first out)
    
    public Buffer(){
        setEmpty(new Semaphore(BUFFER_SIZE));   //Set permit num of empty semaphore to BUFFER size	
    	setFull(new Semaphore(0));  //Set permit num of full semaphore to 0				
    	setMutex (new Semaphore(1));    //Set permit num of mutex semaphore to 1			
    } 
    
    /**
     * insert_item method inserts item into queue. Return 0 indicating an error condition
     * and returns 1 if successful, released and insert into queue
     * (same with remove_item, instead removes the item that has been
     * in the queue the longest)
     * 
     * @param item
     * @return 
     */
    
     public int insert_item(Object item) {
        try {
            //acquire semaphores
            this.empty.acquire();
            this.mutex.acquire();

        } catch (InterruptedException ex) {
             System.out.println("Semaphore not acquired");
             return 0;
        }
        
        //critical section
        //inserts the item
        list.add(item);
        
        //releases the semaphore
        mutex.release();
        full.release();
        return 1;
     }
     
     public Object remove_item() {
         try {
            this.full.acquire();
            this.mutex.acquire();
	} catch (InterruptedException ex) {
            System.out.println("Semaphore not acquired.");
            return 0;
	}
        
         //critical section
        Object item = list.remove();
        
        //release semaphores
        mutex.release();
        empty.release();
        
        //return the item
        return item;
     }
    
    /**
     * 
     * appropriate getters and setters for the variables/for encapsulation
     */
    
    public Semaphore getEmpty() {
		return empty;
	}

	public void setEmpty(Semaphore empty) {
		this.empty = empty;
	}

	public Semaphore getFull() {
		return full;
	}

	public void setFull(Semaphore full) {
		this.full = full;
	}

	public Semaphore getMutex() {
		return mutex;
	}

	public void setMutex(Semaphore mutex) {
		this.mutex = mutex;
	}
    
}
