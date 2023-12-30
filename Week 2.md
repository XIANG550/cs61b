Declaring a variable(simplified):
1. int x; creates a box of 32 bits
2. double y; creates a box of 64 bits
Primitive Type:
1. There are 8 primitive types in java: 1.byte 2. short 3. int 4. long 5. float 6. double 7. boolean 8. char
2. Java creates an internal table that maps each variable name to a location
3. Java does not write anything into the reserved boxes.
Bits: Think of this as encoding of values
1. int requires 32 bits to store
2. double requires 64 bits to store 
Simplified Box Notation:
![[Pasted image 20230808130452.png]]
Box Notation:
![[Pasted image 20230808130511.png]]
Consider the following:
int y; // initialize a box of y
y = 10; // fill the bit representation of 10 into the box
int x; // initialize a box of x
x = y; //  By golden rule of equal, replaces the value in box of x with the value in box of y == copies all bits from y into x.

Note: In addition to setting aside memory, the Java interpreter also creates an entry in an internal table that maps each variable name to the location of the first bit in the box. You do not know the position of the box (e.g it could be 32 and 64 for int type or 77 and 99 as well). 

In summary: You do not know the actual address of the box unlike in C++.

Reference Types:
![[Pasted image 20230808132452.png]]
Two things happening: 1. Copies the arrow, hence a & b are pointing to the same Walrus instance
![[Pasted image 20230808133448.png]]

Parameter Passing(GROE still applies):

1. main scope and average scope
![[Pasted image 20230808133728.png]]

2.  ![[Pasted image 20230808134237.png]]
Instantiation of Arrays:
1. When the reference to an object is lost, then that object will be cleaned by the object collector in Java

IntList Class:
![[Pasted image 20230808135442.png]]

Recursive and iterative function pratices:
1. Practice writing the size() function
2. Practice writing the iterativeSize() function
3. Practice writing the get() function
![[Pasted image 20230810185920.png]]
Suppose we want to get the third item in the IntList. That item is the third item for the current node but the second item for the next node, and so on... The relative position of the item to the current item is of fundamental importance.

![[Pasted image 20230810191127.png]]
Why is the code above failing?
If this exists, then this is not null. And this.rest can be invalid because this can be null.

Remark: 
1. When you implement the functions under IntList class, you should never set the reference "this" to something else. However, you can use "this" or "this.rest" with no problem. B

Lab1 Setup:
1. Install student version of IntelliJ for free (This is an IDE)
2. Install CS 61B package
3. Browse under C:\Program Files\Java\jdk9.0.4 for path to java SDK

Lecture-3 by Jonathan Schewchuk
Defining Classes(Differentiate between field call and method call):

Fields (instance variables with no "()"):
1. Variables stored in objects
2. Used to store data aka instance variables
3. variable should not contain "()" under class
	e.g a) kayla.introduce(); is a method call 
	   b) kayla.age; is a field call

Think of class as a newly create "box template":

Human reference  vs new Human() object: two different concepts!

class Human {
	public int age;
	public String name;

	public Human(String givenName) {
		age = 12; // simply copies the bits
		name = givenName; // both reference to the givenName object
	}
	/* Default constructor */
	public Human() {
		age = 0;
		name = "Untitled";
	}
	public void introduce() {
		System.out.prinln("I'm" + name + "and I'm" + age + "years old");
	}
	public void copy(Human original) {
		age = original.age;
		name = original.name;
	}

}

Each human object can have different values of age and name.
1. Human kayla = new Human();
![[Pasted image 20230815125205.png]]
2. kayla.age = 12;
    kayla.name = "Kayla";
![[Pasted image 20230815125321.png]]
The this keyword:
1. kayla.introduce() implicitly passes an object (kayla) as a parameter called "this".
2. public void change(int age) {
	String name = "Change";
	this.age = age;
	this.name = name;
	} // Priority here is that the age is local
3. kayla.change(8); // check below
![[Pasted image 20230815154718.png]]
Remark: 
1. You CANNOT change the value of  "this"! (compiler does not allow you to change this)
2. Static field: a single variable shared by a whole class or object"s" (shared) aka class variables
3.  public static int numberOfHumans; // increment 1 each time an object of human is constructed.
	public Human() {
		numberOfHumans++;
	}
4. main() is always static; In a static method, THERE IS NO THIS! (Becareful!) Compiler error will occur
Lifetimes of avariables:
1. A local variable is gone when the method ends
2. An instance variable(non-static field) lasts as long as object exits

Primitive Types vs Reference Types:

"Switch" statements:

switch (month) { //  The month "no floating point number can be used"
	case 2:
		days = 28;
		break;
	...
	default:
		days = 31;
		break; // break jumps to the end of the switch statement
}

Multi-dimensional arrays:
1. Two-dimensional array: an array of references to arrays (Pascal Triangle example)


SLLists vs . IntLists:
![[Pasted image 20230815162502.png]]
Physical looking picture of a SLLists:
![[Pasted image 20230815201636.png]]
Remark: 
1. In the second type implementation, the users do not have to worry about referencing at all.

private vs public:
1. The purpose of private is to prevent the users from modifying the object's internal data
2. The method should be made public to the users, otherwise we can not use it.
![[Pasted image 20230815163259.png]]
![[Pasted image 20230815163434.png]]
1. A subordinate class nested inside a boss class
2. Often called nested classes
3. Useful when A class uses another class
4. If only boss class access the subordinate class, then we can use private void static. Otherwise, if subordinate class also needs to access the boss class, then we have to make it non-static

Note: 
1.Explain why can you write private static class IntNode {} clearly.
2.Private subordinate class prevent users from modifying its data from object of SLList class.

Implementation #5: Fast size() by caching:
![[Pasted image 20230815191953.png]]

Implementation #6: The Empty List
![[Pasted image 20230815202506.png]]
Remark:
1. If p were a null pointer, then p.next will immediately give you a nullpointer exception.

 Improvement #6b: Adding a sentinel node
![[Pasted image 20230815210302.png]]
By adding a sentinel node, the first item(if it exsits) will be sentinel.next.

Invariance:
![[Pasted image 20230815212338.png]]
Summary:
![[Pasted image 20230815212521.png]]

DLLists:

Here, we cached on the last node
![[Pasted image 20230815213844.png]]
Removing the last node still requires us to search linearly for the second to the last node so that the last can reference to that node.


Improvement #7: Looking back (.last and .prev)
![[Pasted image 20230815215827.png]]
![[Pasted image 20230815215858.png]]
One solution: Double sentinel nodes
Second solution: Circular sentinel
![[Pasted image 20230815220505.png]]

 Generic DLLists:
![[Pasted image 20230815221947.png]]

 When doing instantiation of primitive type: use capital
 ![[Pasted image 20230815222045.png]]
 
 
 ![[Pasted image 20230815230425.png]]
 When you write a parameterized class, the nested class can not be static.



