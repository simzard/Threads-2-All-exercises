# Threads-2-All-exercises

## Exercise 1

**Explanation**: It looks like the parallel computation is 4 times as fast as the sequential computation. That makes good sense, since I have four cores in my CPU. I ran the program like 10 times, and 7 out of 10 it was probably AT LEAST factor 4 :)

## Exercise 4

**Question**: Does the program behave as expected?

**Answer**: No! The last lines of the program is not printed and it just sits waiting...probably a deadlock has occured!

**Question**: Identify the problems

**Answer** : The problem is that the two Thread classes: RessourceUser1 and RessourceUser2 aquire the ressource in a different order - thus causing a deadlock: They are started almost simultaneously (we never know if t1 or t2 will be executed first). When fx. t1 is started it blocks the Words[] and then at the same time (almost) t2 starts and it blocks the Numbers[] - and then t1 wants the Numbers[] which is locked by t2 and then t2 wants the Words[] which is blocked by t1. 

One **solution** is to aquire and release the critical ressources in the same order 

## Exercise 5
**a)** The code fails . It is supposed to go on forever - and at some point a deadlock must have occured

**b)** See code implementation

**c)** There is a problem with the supplied code: Because pickUpLeftChopstick() and pickUpRightChopstick() are on each their line. Phil. X could invoke pickUpLeftChopstick() while Phil. Y could invoke pikupRightChopStick ... this will make Phil. X unable to putDownChopsticks() and that is also the case with Phil. Y. At some point no philosophers 
could not put down any of the chopsticks - becuase they only have (at most) one - and they are all waiting for the others to put down the right chopstick.

A solution could be that you could only pick up BOTH chopsticks or NONE. But then you should always be alowed to put down ONE chopstick. Another solution could be that we should have a waiter - and then a philisopher must request a chopstick and if there's none available right now, the philosopher must wait patiently. I have tried to implement the latter solution. The waiter should then be implemented as trylock() invoactions...
