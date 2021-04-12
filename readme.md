# Zivver Assignment

## [OPTIONAL] Have a look at https://github.com/emilybache/GildedRose-Refactoring-Kata.
How would you address a programming problem like this? Could you give an adequate
solution in a language of choice?
### Answer
First thing I wrote unit testing and then I thought that I could break the problem with Template Method 
Design Pattern. every kind of drinks/items has its own implementation and its own way of updating the quality 
Then I used a factory pattern to decide which implementation should be used in the run-time. the only problem 
with this design it that if we want to change the calculations we have to change the implementation of 
calculation itself. plz find the solution at com/gildedrose.

## How would you implement a binary search tree (BST) in Scala? Give the trait, (case) class and/or subclass definitions that you would write, without the functions for manipulating the tree: just the data model.



```c++

class BST[V] (implicit ord:Ordering[V]) {

  private sealed trait Tree[V]

  private case object Leaf extends Tree[V]

  private case class Branch[V](left: Tree[V], right: Tree[V], v: V) extends Tree[V]

  private var root: Tree[V] = Leaf

}
```

### Would this class structure be different if you would have implemented them in a non-functional language like Java, Python, Go or C? In what sense?

the structure itself will not vary much however the implementation of the algorithms itself will be very different. For example some languages like haskell will enforce and ensure immutability it won't let you change values, all the elements must be copied to be changed. but on the other hand with Java you can actually change the values it is not immutable by nature and this will result a big difference between both.

### Tree traversal can be done in two ways: recursive and iterative. Which one do you favor? What are the pro's and cons of both ways?

for this specific problem I would choose tail recursion, I have implemented find method please take a look at com/scala/bst.scala.

Usually iteration is faster than recursion but its hard to read code, recursion is slower because its allocating the values in the stack not the heap but on the other hand its easier to read code, so I think tail recursion is the best since its taking the best from both
its easier to read code and there is no task nor calculations needed after the recursive call so it won't use the stack like non-tail recursion.

#### Recursion

pros
1 -  More clear and reduces time needed for debugging
2 -  Smaller code size
3 -  Can reduced time complexity if implemented right using the heap not the stack
4 -  Better for tree traversal

cons
1 - it could be very slow if not implemented right
2 - it could also consume a lot of memory if it used the stack

#### Iteration

pros

1 - Relatively lower time complexity(generally polynomial-logarithmic)

cons

1 - Larger Code Size.
2 - hard to read code comparing to recursion


## Imagine that you have to process a large unsorted CSV file in Java/Scala/Clojure or Kotlin
with two columns: productId (Int) and availableIn (ISO2 String, e.g. &quot;US&quot;, &quot;NL&quot;). The goal
is to group the file sorted by productId together with a list where the product is available.

#### Answer

it throws out of memory exception because probably the code was trying to put the while file in memory at once,
I have made some research and did some code attempts first one was breaking the large file into chunks and process
the chunks in parallel mode by using ExecutorService but I realized that using NIO MappedBufferByte is better tool for that.

So basically I read the file in the buffer and then parse the content and do the grouping in a map and after that I write back
on the target file.

How MappedByteBuffer works :

###### Memory-mapped I/O uses the filesystem to establish a virtual memory mapping from user space directly to the applicable filesystem pages.
With a memory-mapped file, we can pretend that the entire file is in memory and that we can access it by simply treating
it as a very large array. This approach greatly simplifies the code we write in order to modify the file.
#### To Do

1 - unit testing

2 - performance/stress testing specially on (OutOfMemory Exception)

3 - we can also break the file in chunks with this approach as well depending on the file size,

I used approx 700 MB file and I think this approach is good up to 2 GB file, it really depends on the
desk space as well.


## Name both a good and a bad use case for using MongoDB (or some other document/objectstore).

As per CAP theory it depends on what is critical for my design consistency, availability and partition tolerance.

Bad Case :

Lets say we are building a phone directory app or something that we know it will not have big data, and it probably it will fit 
into single machine with no need to scale later on, and we don't know how to use noSql, and we want to learn it, so we decided to build that application with mongodb.
Good Case :

Lets say we are building a big digital platform, and we are supporting millions of people 
who want to find a product and complete checkout process. with this number of users and this number  of
QPS NoSQL would outperform SQl hanks to their distributed architecture,
deliver the sub-millisecond responsiveness and elastic scalability that digital communication applications require.

## You are  about to start your new job at a cool Amsterdam startup. What do you favor the most?
Pick one 1 .
a. Choose your own hardware, be forced to work with a company supplied operating
system image.
b. You are offered a standard piece of mediocre hardware. Free to pick your own
software.

I Have been in both places, I will go with (A) choose my own hardware 

## When a user logs in on our API, a JWT token is issued and our webapp uses this token for every request for authentication. Here's an example of such a token:

eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IjxuYW1lPiIsImFkbWluIjpmYWxzZX0.Hjrg9Ntw6qUjTeRbYM_-PL5Bnh6dVZHfQJ6Ou_BWhRk

Why and when is it (or isn't it) safe to us

## Answer

I have noticed that the above token is like that

following {
  "sub": "1234567890",
  "name": "<name>",
  "admin": false
}

it contains user roles information which is might be not safe in some cases.
 lets imagine we are on a production environment and once you created and signed the token you grant a permission to a
  user and until this permission expires the user is out there on the system lets assume that we made a mistake granting the permission or th
  e permission has changed,that wouldn't be consistent because  the user still have the permission until it expires.

  Now for how we make it safe I assumed that the above scenario is important to handle so there is two solutions and of course they come with a cost

  1 - add roles to JWT and use blacklist
  we add the roles to JWT and and we make a blacklist which contains the changed roles tokens, and for every request we validate the token against this list
  2 - JWT without roles
  We don't add roles to JWT and we fetch them on demand from the database but this also comes with a price of querying on the database each time


   ## License
[MIT](https://choosealicense.com/licenses/mit/)