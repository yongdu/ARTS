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


Under what situation the auto-boxing and unboxing is used?
* use them in generics. Java generic types only accepts object. 

```

List<Long> longList = new ArrayList<>();      
long i = 4;
longList.add( i ); //autoboxing      
long j = longList.get( 0 ); //unboxing
```