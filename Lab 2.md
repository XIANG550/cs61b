Why Debugging should be learnt?
1. The method of adding print statements requires that you modify your code. You must explicitly state what you want to know. (Timing consuming and inefficiency)
2. It takes less time and mental effort to find a bug if you use a debugger. The IntelliJ debugger allows you to pause the code in the middle of execution, step the code line by line, and visualize the organization of complex data structures like linked lists.

Scientific Debugging:
1. Formulate hypotheses about how segments of your code should behave
2. Use the debugger to see whether those hypotheses are true.
3. Refine your hypotheses until you can not help but stumble right into the bug.

Debugging :

Example:
![[Pasted image 20230814202706.png]]
![[Pasted image 20230814202659.png]]

Conclusion: An uncareful user accidently typed a "-" in front of the quantity. Therefore, we should use Math.asb() to fix this error:

int numAvailable = Math.abs(in.readInt());

Destructive vs. Non-Destructive:

Destructive: Yes changes in internal data
![[Pasted image 20230814221557.png]]
Non-Destructive: No changes in internal data
![[Pasted image 20230814221605.png]]

Important Note: (Java is strictly pass by value although the data can be modified):
![[Pasted image 20230814221729.png]]

![[Pasted image 20230814222134.png]]

![[Pasted image 20230815010322.png]]


