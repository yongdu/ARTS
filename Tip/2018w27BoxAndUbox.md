### Auto-Box and Unbox in Java

 * Autoboxing
   automatic conversion of a primitive data type into its wrapper class 
  * Unboxing 
   converting a wrapper class into its primitive data type 


|Primitive type|	Wrapper class|
|--------------|-----------------|
|boolean	|Boolean|
|byte	|Byte|
|char|	Character|
|float	|Float|
|int|	Integer|
|long|	Long|
|short|	Short|
|double|	Double|


Why auto-boxing and unboxing are used?
* use them in generics. Java generic types only accepts object. 
* A primitive type cannot be put into a collection as collections can only hold object references. So as to put a primitive type to collections a programmer would have to always box a primitive type and put into collections. And then on retrieval of the value, he/she would have to unbox it. 
```

> Autoboxing does create objects which are not clearly visible in code and cause performance suffers.


List<Long> longList = new ArrayList<>();      
long i = 4;
longList.add( i ); //autoboxing      
long j = longList.get( 0 ); //unboxing
```

When autoboxing and unboxing happen?
* a method is expecting a warapper class, the caller pass corresponding primitive type
```java
 public static void display(Integer i){
     System.out.print(i);
 }

 int a = 10;
 display(a) //autoboxing
```
* a primitive data is assigned to its corresponding wrapper class, then autoboxing happens, for unboxing, the vice versa.
```java
long a = 10l;
Long b = a; //autoboxing
Integer c = new Integer(1);
int d = c;//unboxing
```
* once a n unary or a conditional operation is performanced on a wrapper class object, unboxing is performed.

```java
Integer = new Integer(10);
i++; // unboxing

int sum =0;
if(i%2 ==0 ){ //unboxing
    sum +=i;//unboxing
}
```


#### Method overloading

*Widening -->Boxing --> Varargs*

Widening is transforming a variable to a wilder type. e,g.,`byte -> int`, `int ->long`etc.
 If overloading comes in a case where one method has *widened* parameter, the other method has `boxed` parameter, then Widening method takes priority than boxing. 
 The same situation for varargs method and boxing method, Boxing takes priority than varargs. 

```java
public class AutoBoxingAndUnboxing {

	
	 public static void display(long i) {
         System.out.print("long");
       }
	
       public static void display(Integer i) {
         System.out.print("Integer");
       }
       
       public static void display(Integer... i) {
           System.out.print("Integer...");
         } 
       
       public static void display(Long i) {
           System.out.print("Integer...");
         }
	public static void main(String[] args) {
		int a = 10;
		display(a);
	}
}
```
the result of above code snippet:
`long`

Widening is performed. `int->long`. 


*  

**Confused Equals**

```
Long longWrapperVariable=2L ;
System.out.println(longWrapperVariable.equals(2));
System.out.println(longWrapperVariable.equals(2L));
```

Output:
```

false
true

2 was boxed to Integer and henceequals could not compare it with Long. And 2L was boxed to Long and hence returned true.
```

**Caching of Primitive by Wrapper Classes**
>  If the value p being boxed is true, false, a byte, or a char in the range \u0000 to \u007f, or an int or short number between -128 and 127 (inclusive), then let r1 and r2 be the results of any two boxing conversions of p. It is always the case that r1 == r2.


```
System.out.println(Integer.valueOf("127")==Integer.valueOf("127"));
System.out.println(Integer.valueOf("128")==Integer.valueOf("128"));
```

Result of above code:
```
true
false
```


#### Ref
1. http://edayan.info/java/autoboxing-and-unboxing-in-java