
#### Java function doc

Collectors.groupingBy()
public static <T,K,D,A,M extends Map<K,D>> Collector<T,?,M> groupingBy(Function<? super T,? extends K> classifier,
                                                                       Supplier<M> mapFactory,
                                                                       Collector<? super T,A,D> downstream)

Returns a Collector implementing a cascaded "group by" operation on input elements of type T, grouping elements according to a classification function, and then performing a reduction operation on the values associated with a given key using the specified downstream Collector. The Map produced by the Collector is created with the supplied factory function. 
The classification function maps elements to some key type K. The downstream collector operates on elements of type T and produces a result of type D. The resulting collector produces a Map<K, D>. 

For example, to compute the set of last names of people in each city, where the city names are sorted: 
```java

Map<City, Set<String>> namesByCity
         = people.stream().collect(groupingBy(Person::getCity, TreeMap::new,
                                              mapping(Person::getLastName, toSet())));
```
     
 
Implementation Note:The returned Collector is not concurrent. For parallel stream pipelines, the combiner function operates by merging the keys from one map into another, which can be an expensive operation. If preservation of the order in which elements are presented to the downstream collector is not required, using groupingByConcurrent(Function, Supplier, Collector) may offer better parallel performance.Type Parameters:T - the type of the input elementsK - the type of the keysA - the intermediate accumulation type of the downstream collectorD - the result type of the downstream reductionM - the type of the resulting MapParameters:classifier - a classifier function mapping input elements to keysdownstream - a Collector implementing the downstream reductionmapFactory - a function which, when called, produces a new empty Map of the desired typeReturns:a Collector implementing the cascaded group-by operationSee Also:groupingBy(Function, Collector), groupingBy(Function), groupingByConcurrent(Function, Supplier, Collector)
