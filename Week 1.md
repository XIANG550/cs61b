Java Basics:
1. All code must live inside a class; code inside the main function executes; variables have their static types; function must return a type e.g int, ..., void; class is an user-defined type
2. Static Typing: Types are checked before compilation. This ensure the compiled program to be free of any type errors
3. Compiling a java program: javac(program.java) -> java(program) -> executing the program
static vs non-static(class):
![[Pasted image 20230807135439.png]]

1. Static: Dog.makeNoise();    The invocation == Calling is via the class name
2. Non-static:   maya=newDog(100);
                         maya.makeNoise();
    The invocation is via the object of type class
3. You can have a mixture of static and non-static methods for a class
![[Pasted image 20230807140116.png]]
-In this figure, we want to compare the size of two different dogs. We dont want each of the dogs to perform comparison. The God "Dog" will be the judge.
-In summary: A static type variable or function is shared by the objects of the name class simultaneously.
-Rule of Thumb: Just use class name for any variables or methods.
-Any variable or functions under the class are called the members of the class.
Class methods = static methods
Instance methods = non-static methods
![[Pasted image 20230807141953.png]]

![[Pasted image 20230807142709.png]]

My solution:
i = 0 : bark!
i = 1: wooof!
i = 2: wooof!
i = 3:  NullPointerException Error. Why? manyDogs[3] = null, hence if we try to access any member of manyDogs[3], it will result in java.lang.NullPointerException error.

Java Libraries:
why?
1. Existing libararies probably less buggy
2. Builtin Java Libararies (eg. Math, String, Integer, List, Map)
How to use?
1. Know the existence of such a library
2. Know how that library works 
3. ![[Pasted image 20230807160456.png]]
Notice the "static" keyword, we call method by class name: Integer.parseInt()

Something to remember:
1. Integer.parseInt() : converts String to int

Proj0
1. Refer to https://introcs.cs.princeton.edu/java/stdlib/javadoc/In.html for class In.
2. When doublebuffering() is used, the show() means that drawing get copied from the offscreen canvas to the onscreen canvas




