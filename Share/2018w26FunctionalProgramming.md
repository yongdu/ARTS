## Functional programming

Functional programming uses *internal iteration*
 * Specify what you want to accomplish
 e.g. to sum up array's elements, "here is the data source, give me the sum of its elements"

 Advantage:
 * no iteration specified
 * no mutable variables
 * library figure out how to accompish goal
 * easier to parallelize for multi-core and improved performance

Java fucntional programming focues on immuatbality

#### Lambda expressions
Lambda expression is an anoymous method that implements a functional interface.

Syntax:
`(parameter list) -> {statement}`

e.g. sum two ints
`(int x, int y) -> {return x+y;}` 

Shortcut: parameter type could be ommitted, complier determines types by the lambda's context.
1. For one expression body, the *return* keyword and curly braces may be ommitted and result iis implicitely returned.
`(x,y) -> x+y`
2. For only one parameter, the parentheses may be omitted
`value -> System.out.printf("%d ", value)`
3. Lambda with an empty parameter list
`() ->System.out.printf("Hello World!")`


#### Streams
**Streams** are objects that implement interface "Stream" (from package `java.util.stream`) to perform function programming tasks.

**Stream pipeline** is to move elements through a sequence of processing step.
```List<String> myList =
    Arrays.asList("a", "b", "c", "d", "e");

myList
    .stream()
    .filter(s -> s.startsWith("a"))
    .map(String::toUpperCase)
    .sorted()
    .forEach(System.out::println);
```
e.g this code snippet performs a chain of stream operation with data source *myList*, this is called *pipeline*.

Steam pipeline begins with a data source, performs various intermediate operations on the data sources's elements and end with a termination operation. 

*Streams don't have their own storage*. Once processed, a stream cannot be reused.

**Intermediate operation** specifies tasks to perform on the steam's elements and always results in a new stream.
* lazy, not get preformed until a termial operation is invoked.

| Intermediate operation | Description    |
|:-----------------------|:---------------|
|`filter`  | Result in a stream containning only the elements that satisfy a condition|
|`distinct`| Result in a stream containning only the unique elements |
|`limit`   | Result in a stream with the specified number of elements from the beginning of the original stream |
|`sorted`  | Result in a stream in which the elements are in sorted order. The new steam has the same number of elements as the orginal stream |
|`map`     | Result in a stream in which each elements of the original stream is mapped to a new value (possibly of a different type) e.g., mapping numeric values to the squares of the numeric values. The new stream has the same number of elements as the original stram. |



**Terminal operation** initiates processing of a stream pipeline's intermediate operations and produce a result.
* eager - they perform the requested operation as soon as they are called.



| Terminal  operation    | Description    |
|:-----------------------|:---------------|
|`forEach`  | Performs processing on every element in a stream|

3 different categories of  terminal operation
1.  *Reduction operations* take all values in the stream and return a single value


| Reduction operation    | Description    |
|:-----------------------|:---------------|
|`average`  | Calculates the averge of the elements in a numeric stream|
|`count`    | Returns the number of elements in the stream|
|`max`      | Locates the largest  value  in a numeric stream|
|`min`      | Locates the smallest value  in a numeric stream|
|`reduce`   | Reduces the elements of a collection to a single value using an associatived accumulation function e.g.,a lambda that add two elements|

2. *Mutable reduction operations* create a container (such as a collection or StringBuilder)

| Mutable reduction operations   | Description    |
|:-------------------------------|:---------------|
|`collect`  | Creates a new collection of elements contains the results of the stream's prior operation|
|`toArray`  | Creates an array containing the results of the stream's prior operations|

3. *Serach operations*

| Search operation   | Description    |
|:-------------------|:---------------|
|`findFirst`   | Finds the first stream elements based on the prior intermediate operations; immediatedly terminates processing of the stream pipeline once such an element is found|
|`findAny`     | Finds any stream elements based on the prior intermediate operations; immediatedly terminates processing of the stream pipeline once such an element is found|
|`anyMatch`    | Determins whether any stream elements match a specified condition; immediatedly terminates processing of the stream pipeline once if an element matches |
|`allMatch`    | Determins whether all of the elements in the stream match a specified condition|


```java
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
public class IntStreamOperations {
	public static void main(String[] args) {
		int[] values = {2,3,4,5,6,9,7,13,17,76,88};
		IntStream.of(values)
				 .forEach(value -> System.out.printf("%d ", value));
		System.out.println();
		
		System.out.printf("%nCount: %d%n", IntStream.of(values).count());
		System.out.printf("Min: %d%n", IntStream.of(values).min().getAsInt());
		System.out.printf("Max: %d%n", IntStream.of(values).max().getAsInt());
		System.out.printf("Sum: %d%n", IntStream.of(values).sum());
		System.out.printf("Average: %.2f%n", IntStream.of(values).average().getAsDouble());
		
		
		// sum by using reduce method
		System.out.printf("Sum: %d%n ", IntStream.of(values).reduce(0,(x,y)->x+y));
		
		// even value displayed in sorted order
		System.out.printf("%nEven values displayed in sorted order: ");
		IntStream.of(values)
				 .filter(value -> value%2 == 0)
				 .sorted()
				 .forEach(value -> System.out.printf("%d ", value));
		
		// odd vales multiplied by 10 and display in sorted order
		System.out.printf("%nOdd vales multiplied by 10 and display in sorted order: ");
		IntStream.of(values)
		 .filter(value -> value%2 == 0)
		 .map(value -> value * 10)
		 .sorted()
		 .forEach(value -> System.out.printf("%d ", value));
		
		IntPredicate even = value-> value %2 == 0;
		IntPredicate greaterThan5 = value ->value>5;
		
		// combine filter condition , even values that are greater than 5  multiplied by 10 displayed in sorted order
		System.out.printf("%nEven values that are greater than 5  multiplied by 10 displayed in sorted order: ");
		IntStream.of(values)
		 .filter(even.and(greaterThan5))
		 .map(value -> value * 10)
		 .sorted()
		 .forEach(value -> System.out.printf("%d ", value));

        System.out.println();
		// sum range of integer from 1 to 10, exclusive
		System.out.printf("Sum of integer form 1 to 9: %d%n", IntStream.range(1, 10).sum());
		
		// sum range of integer from 1 to 10, inclusive
				System.out.printf("Sum of integer form 1 to 10: %d%n", IntStream.rangeClosed(1, 10).sum());
	}
}
``` 

Output of code:
```
The orginal values: 
2 3 4 5 6 9 7 13 17 76 88 

Count: 11
Min: 2
Max: 88
Sum: 230
Average: 20.91
Sum: 230
 
Even values displayed in sorted order: 2 4 6 76 88 
Odd vales multiplied by 10 and display in sorted order: 20 40 60 760 880 
Even values that are greater than 5  multiplied by 10 displayed in sorted order: 60 760 880 
Sum of integer form 1 to 9: 45
Sum of integer form 1 to 10: 55
```