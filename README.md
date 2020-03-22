### COMPX202 -  Mobile Computing and Software Architecture
Assignment 3 - Java Generics and Testing
========================================

#### Due on **Friday 3rd April at 8pm**

-------------------------

**Purpose**: The main purpose of this assignment is to experiment with
the object-oriented features of Java and with generics. The secondary
purpose is to give you some experience with the important modern
software engineering practice of unit testing.

**Tests**: You are required to write JUnit tests for all your code
demonstrating that it follows the assignment specifications.

**Git**: Remember to use Git throughout. Commit regularly with
descriptive messages.

Introduction
------------

A queue is a collection that supports adding elements to one end and
removing elements from the other end (i.e. a first-in-first-out data
structure). Queues have a wide range of applications, for example
passing messages.

For this assignment you will implemented a bounded (fixed-capacity)
queue and use it in the setting of a "game". The game has some state
(player's location and score) and there are actions which change the
game state. The actions are sent to the game through a queue.

Using a fixed-capacity queue limits memory usage. When the queue is
full items will start getting dropped, which allows the game to
recover if the actions can't be processed quickly enough. There are
two strategies for dropping items: drop the item which has been in the
queue the longest, or drop the most recent item which is currently
being added.

(In a more realistic setting the queue might be concurrent, but that
is beyond the scope of this assignment.)

Instructions
------------

### Part A: Setup
[See PDF for more detailed instructions]
1. Clone this repository using the button at the top of the project
    page

2. Import the project into IntelliJ from Version Control (pasting the URL of the project)

3. On GitHub, create a new **Private**, empty repository named COMPX202-assignment3-3170000 (**Use your student ID instead of 3170000**)
 **Set the visibility of your project to Private** 

4. Invite the teachers (azanibellato, samminweng) to your Private repository

5. Change the remotes in IntelliJ to point to the new repository (from VCS > Git > Remotes...)

6. Push the files to the new repository (VCS > Git > Push)

4. Try running the example test in GameTest.java. It should pass.
    IntelliJ IDEA: Right click the file and choose _Run 'GameTest'_ (JUnit should already be configured)
    
5. Try running the tests in BoundedQueueTest.java. They should fail
    because BoundedQueue is not implemented.

### Part B: Bounded Queue

There are a few different ways to implement the queue. You may choose
any way that you like, but you **must not** use any of the Java
collection classes. You may use arrays; if you do, the provided method
_makeArray_ will be useful (Java does not support generic array
creation using `new T[size]` where T is a type parameter).

BoundedQueue.java contains a skeleton for you to fill out. Replace the
lines `throw new RuntimeException("Not yet implemented");` with your
own code (but don't change the method signatures). You may add members
as required.

Write the tests in any order you like (before or after you write the
code). I suggest using String as the element type for the tests, but
be aware that in Java strings should be compared using
`str1.equals(str2)` rather than `str1 == str2`.

You should not use casts, e.g. `(String) someVariable`, in any of the
code for this assignment. The method _makeArray_ is exempt from this
requirement.

### Part C: Reporting Statistics

Add a static method to BoundedQueue called _reportStats_ which prints
to standard out (i.e. _System.out.println_) the following statistics,
measured from when the program started running:

 - the number of BoundedQueue instances that have been created
 - the total number of items dropped from BoundedQueue instances due
   to a full queue

You are not required to write a unit test for this method. Instead,
create a static method in BoundedQueueTest which calls _reportStats_
and annotate it with `@AfterEach` instead of `@Test` so that it will
run after all the test cases. Manually check that the statistics look
reasonable.

### Part D: Game

The provided Game class represents the state of the game and the
player. Action classes modify the state of the game. For example, the
ScoreAction class (provided in Game.java) changes the player's score.

1. Write a MoveAction class that inherits from Action and updates the
    player's location. Example:

        Game game = new Game();
        // ...
        // suppose the player's location is (x=75, y=120)
        Action move = new MoveAction(5, -3);
        move.actOn(game);
        // the player's location should now be (x=80, y=117)

2. Add a method _process_ to Game that takes a `BoundedQueue<Action>`
    and runs all the actions. Then make it more general so it also
    accepts e.g. `BoundedQueue<MoveAction>` (you may find bounded
    wildcards useful).

3. Add a method _generateMovements_ to Game that takes a
    `BoundedQueue<MoveAction>`, creates two MoveActions, and adds them
    to the `BoundedQueue<MoveAction>`. Then make it more general so it
    also accepts e.g. `BoundedQueue<Action>` (you may find bounded
    wildcards useful).

4. For simplicity, write a single test in GameTest.java that tests
     _generateMovements_ and _process_ together (it can also cover
     _MoveAction_).

### Part E: Alternative Implementations

Describe in two or three paragraphs another way to implement the
bounded queue which is different from the one you used.

> Write your answer here

Submitting
----------

Push your commits to your Private GitHub repository (see Part A). Ensure that you can see
your changes on GitHub. Export your project to ZIP (File > Export to Zip File...) and submit it to Blackboard.

Grading
-------

| Weighting | Allocated to |
|:----------:|------|
| 10% | Correct repository usage and settings |
| 20% | BoundedQueue implementation |
| 20% | BoundedQueue tests |
| 10% | Part C: _reportStats_ |
| 30% | Part D: MoveAction, _process_, _generateMovements_, test |
| 10% | Part E: alternative implementations |

Advice and clarifications
-------

**General Advice**

Work in small steps. Write simple tests to check things work (maybe by printing debugging output).

The simplest starting step is to keep track of the number of elements in the queue without storing the elements themselves. The MoveAction class is very easy to implement.</p>

**Behaviour of dropOldest**

*Example 1.*

Suppose ```q``` is a ```BoundedQueue<String>``` with capacity 3 and dropOldest set to true, and that the elements "Alice", "Bob", and "Charlie" have been put in the queue (in that order). 
If ```q.put("David")``` is executed, then "Alice" will be dropped and the contents of the queue will be "Bob", "Charlie", "David".

*Example 2.*

As before, but with dropOldest set to false. 
If ```q.put("David")``` is executed, then "David" will be dropped and the contents of the queue will be "Alice", "Bob", "Charlie".

**generateMovements()**

This method should have exactly one parameter. 
The MoveActions can be generated in any way, but I suggest creating MoveActions with fixed x and y values so they can be tested.

**Generalising process() and generateMovements()**
The instructions say ```process``` should take a ```BoundedQueue<Action>``` at first, and then it should be made more general and also accept e.g. ```BoundedQueue<MoveAction>```. 
This means the following code should compile:

```
public class Example {
    public static void main(String[] args) {
        Game game = new Game();
        BoundedQueue<Action> q1 = new BoundedQueue<Action>(3, false);
        game.process(q1);
        BoundedQueue<MoveAction> q2 = new BoundedQueue<MoveAction>(3, false);
        game.process(q2); // this line will only compile when you make process() general
    }
}
```

A similar thing applies to ```generateMovements```.

If you get the first part working but can't make the method general, keep both versions and comment out the one that doesn't work.

**instanceof**

You should not have to use ```instanceof``` in this assignment.

**BoundedQueue.reportStats()**

"Number of BoundedQueue instances that have been created" refers to the total number of instances of the BoundedQueue class, not the number of items that have been added. 
For example, consider the following program:

```
public class Example {
    public static void main(String[] args) {
        BoundedQueue&lt;String&gt; q1 = new BoundedQueue&lt;String&gt;(3, false);
        BoundedQueue&lt;String&gt; q2 = new BoundedQueue&lt;String&gt;(3, false);
        q1.put("Alice"); q1.put("Bob"); q1.put("Charlie"); q1.put("David");
        q2.put("xyz"); q2.put("123");
        BoundedQueue.reportStats();
    }
}
```


If this is the only code that runs (none of the tests run etc.) the output might look like this:

```
number of BoundedQueue instances: 2
number of dropped items: 1
```


**How many tests?**

The tests don't need to be exhaustive, but they should be enough to demonstrate the code meets the assignment specifications. 
As a rough guide, aim for 1-3 short tests for each method. Some aspects of the tests will be discussed again in the lecture of week 5.
