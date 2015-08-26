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

**c)** and **d)**: There is a problem with the supplied code: If all 5 philosopher threads call pickUpLeftChopstick() at the same time (which can happen), then all the 5 chopsticks is taken and all the 5 threads will then call pickUpRightChopstick() and they will wait forever in a deadlock. This could maybe be solved with a Waiter object - and then instead of just TAKING the chopsticks, the philosopher should request PERMSSION for a chopstick, and the Waiter should check if the resource(lock) is available - if not, the philosopher should wait patiently, until a chopstick is available. 

My solution is a bit different and the poor philosophers might starve because of this: I say the only ONE philosopher can eat at a time, which means I have a static volatile boolean variable that remembers if a philosopher is currently eating. When a philosopher wants to eat, he will pick up both chopsticks and eat and put them down afterwards. Thus causing the remaining 4 philosophers to wait for their turn. It's not a pretty solution, however it runs forever now...


