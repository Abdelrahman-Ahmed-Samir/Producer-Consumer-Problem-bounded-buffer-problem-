# Producer-Consumer-Problem-bounded-buffer-problem-

Producer and Consumer are two separate processes. Both processes share a common buffer or queue. The producer continuously produces certain data and pushes it onto the buffer, whereas the consumer consumes those data from the buffer.

-We have defined a separate class for each entity of the problem.

-Used Semaphore and Threads

 - a Semaphore: maintains a set of permits. Each acquire blocks if necessary until a permit is available, and then takes it. Each release adds a permit, potentially releasing a blocking acquirer.
 (Created from scratch)
 
 -Threads allows a program to operate more efficiently by doing multiple things at the same time.
  Threads can be used to perform complicated tasks in the background without interrupting the main program.

- Program Description:

Given N numbers and one file, our system simulates a real-life of how
buffering is run where a user will decide N to get the prime numbers from
0 to N. Somehow, the producer schedules the primes in a queue and
consumer will use this queue to write them in the file, so do an
application using multiple threads to do multiple actions simultaneously
which will reduce the time elapsed.

-GUI (real time update of this GUI) was created by using Eclipse IDE (MainFrame.java)

Notes:
(1)-the text files in the folder as : 

1-bye

2-dudi

3-hello

4-last

5-output

6-outputFile

are just results from testing the program in the GUI

(2)-When running the GUI to create the output file you need to add (.txt) after the name of the file for an example make it like this: (myfile.txt)

