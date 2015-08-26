# Threads-2-All-exercises

## Exercise 1

**Explanation**: It looks like the parallel computation is 4 times as fast as the sequential computation. That makes good sense, since I have four cores in my CPU. I ran the program like 10 times, and 7 out of 10 it was probably AT LEAST factor 4 :)

## Exercise 4

**Question**: Does the program behave as expected?

**Answer**: No! The last lines of the program is not printed and it just sits waiting...probably a deadlock has occured!

**Question**: Identify the problems

**Answer** : The problem is that the two Thread classes: RessourceUser1 and RessourceUser2 aquire the ressource in a different order - thus causing a deadlock: They are started almost simultaneously (we never know if t1 or t2 will be executed first). When fx. t1 is started it blocks the Words[] and then at the same time (almost) t2 starts and it blocks the Numbers[] - and then t1 wants the Numbers[] which is locked by t2 and then t2 wants the Words[] which is blocked by t1. 

One **solution** is to aquire and release the critical ressources in the same order 
