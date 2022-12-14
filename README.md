# Object Oriented Programming 2022 Winter

<!-- TABLE OF CONTENTS -->
### Tasks
* [Task 0 - UndoableStringBuilder](#task-0---undoablestringbuilder)
* [Task 1 - Observer design pattern](#task-1---observer-design-pattern)

## Task 0 - UndoableStringBuilder
#### about
The UndoableStringBuilder is a StringBuilder that can use the undo method to go back to his previous state before his last change.
#### Included files
 * UndoableStringBuilder
 * Tests.java
#### Tests
For the UndoableStringBuilder we are testing each method to see if the correct exeption is happening, if needed, and that the methods are working correctly.


## Task 1 - Observer design pattern
#### about
In this task we are asked to implement observer design pattern with Undoable string builder from first assingment.
First, we build ConcreteMember class with a UndoableStringBuilder as his only field of data he contains, who implements the Member interface with the function update - to update his pointer of UndoableStringBuilder.
Secondly, we are implementing GroupAdmin that implements the sender interface, with all his functions. GroupAdmin contains a list of members and corrent UndoableStringBuilder as his data fields. We use a list of memebers we want to update on any change within the corrent UndoableStringBuilder of GroupAdmin, those are basicly our subscribers and the UndoableStringBuilder is our content we want to publish.
#### Included files
* java/observer
  * ConcreteMember.java
  * GroupAdmin.java
  * Sender.java
  * Member.java
  * UndoableStringBuilder
 
* test/java
  * JvmUtilities.java
  * Tests.java
#### How to use the project
First, clone the git repository and open it as a project in your IDE.
Than, use the tests we created OR create new GroupAdmin, and ConcreteMembers and see how the GroupAdmin as the sender, updates his ConcreteMembers as the Members when we change the UndoableStringBuilder.
Also it is recommnded to check if the maven dipendencies are up to date.

#### Tests
In the task we are using assertEquals mainly to check if the changes are going as planned, while also using JvmUtilites class to check the heap size of the objects to check that we indeed changed the GroupAdmin or the ConcreteMember. For example, after adding 4 Concrete Members in the GroupAdmin test, and than adding another Concrete memeber that already exists, we can see in the heap size and number of items in the linked list, that the member did not add twice and the GroupAdmin stayed the same.
