scala is a statically typed language.
a class can model data through it's parameters, objects contain utility methods and works as a companion object.

### Note
go through the commits history to follow concepts step by step 

## Class
- representation of an entity

## ADTs
- ADTs are way to create data types
- An algebra contains symbols, operations, and laws
#### Cardinality
- no of elements in a grouping
- a number of possible values a type can have
- e.g. 
<pre>
Boolean (True, False) : cardinality = 2 
TaskStatus (Pending, InProgress, Completed) : cardinality = 3
Pair of (Boolean, TaskStatus): cardinality = 2*3=6
</pre>

the number of possible values depend on product of individual cardinalities
hence called **Product types**, created using case class in scala.

<pre>
case class Task(isPriority: Boolean, status:TaskStatus)
</pre>

Now consider a type: "Boolean or TaskStatus"
cardinality = 2+3 = 5

In scala, a **sum type** can be written as Either type
<pre>
Either[Boolean, TaskStatus]
</pre>

Observe that TaskStatus in itself is a Sum Type
<pre>
sealed trait TaskStatus
case object Pending extends TaskStatus
case object InProgress extends TaskStatus
case object Completed extends TaskStatus
</pre>