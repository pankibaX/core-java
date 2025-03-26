#### **Generics**

- Stronger type checks at compile time
- Enables to implement generic algorithms
- Elimination of casts
- Bounded wildcards are extremely useful in making flexible generic APIs
- Use of wildcards to increase API flexibility
	- Unbounded Wildcards
	- Upper Bounded Wildcards - **? extends Type**
		- restricts the unknown type to be a specific type or sub-type. As explained in [PlayWithUpperBoundedWildCard](src/main/java/com/pankiba/generics/boundedwildcards/PlayWithUpperBoundedWildCard.java)
	- Lower Bounded Wildcards - **? super Type**
		- restricts the unknown type to be a specific type or super-type. As explained in [PlayWithLowerBoundedWildCard](src/main/java/com/pankiba/generics/boundedwildcards/PlayWithLowerBoundedWildCard.java), function **numsUpTo** can accept Number and its super types. So this function accepts List<Integer> & List<Number> but NOT List<Double>
	- Multiple bounds
- The get-put principle can be used to determine which should be used. **GET - Extends, PUT - Super**
