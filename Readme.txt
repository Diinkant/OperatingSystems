A) Individual Work
Diinkant Ravichandran (ID: 1385134)

B) My work contains:
-Main.java
-Buffer.java
-Producer.java
-Consumer.java
-Constants.java
-Readme.txt

C) Running the source code program
To complie and run the program, you can use either eclipse IDC or Netbeads (which I personally used). Create 
a new project and call it "OS". Then, create a package called "OS" inside the source package. Unzip the assignment
folder and copy all 5 java files into the "OS" package. Open the Main.java file and click the green play button on 
the toolbar to run the program.

D)
1. 
How long do you want the program to sleep before terminating? (in seconds)
10
The number of producer threads you want?
1
The number of consumer threads you want?
1

Producer 12 produced 8
The buffer now contains 1 items
Consumer 11 consumed 8
The buffer now contains 4 items

Explanation: There is one producer thread with the threadID of 12 and one consumer thread with the threadID of 11. 
During the 10 seconds of run time, the thread produces 1 item, which is "produced 8" and consumer consumes
1 item "consumed 8". Consumer can only consume once something is produced and therefor the producer went first
and produced 1 item and consumer consumed 1 item.

2.
How long do you want the program to sleep before terminating? (in seconds)
10
The number of producer threads you want?
5
The number of consumer threads you want?
5

Producer 19 produced 1
The buffer now contains 1 items
Consumer 12 consumed 1
Producer 18 produced 1
The buffer now contains 1 items
The buffer now contains 0 items
Consumer 13 consumed 1
The buffer now contains 0 items
Producer 16 produced 3
The buffer now contains 1 items
Consumer 11 consumed 3
Producer 17 produced 3
Consumer 14 consumed 7
The buffer now contains 0 items
Producer 20 produced 7
The buffer now contains 1 items
The buffer now contains 0 items
The buffer now contains 1 items
Consumer 15 consumed 3
The buffer now contains 0 items

Explanation:

3.
How long do you want the program to sleep before terminating? (in seconds)
10
The number of producer threads you want?
5
The number of consumer threads you want?
5

Producer 16 produced 1
Consumer 15 consumed 1
The buffer now contains 1 items
The buffer now contains 9 items
Producer 17 produced 7
The buffer now contains 1 items
Consumer 13 consumed 7
The buffer now contains 9 items
Producer 18 produced 9
Consumer 15 consumed 9
The buffer now contains 8 items
The buffer now contains 1 items

Explanation:
