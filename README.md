# OOP_2022
## Object Oriented Programming - Tasks

### Task 0 - UndoableStringBuilder
#### about
The UndoableStringBuilder is a StringBuilder that can use the undo method to go back to his previous state before his last change.


### Task 1 - Observer design pattern
#### about
In this task we are asked to implement observer design with Undoable string builder from first assingment.
First, we build ConcreteMember class with a UndoableStringBuilder as his only field of data he contains, who implements the Member interface with the function update - to update his pointer of UndoableStringBuilder.
Secondly, we are implementing GroupAdmin that implements the sender interface, with all his functions. GroupAdmin contains a list of members and corrent UndoableStringBuilder as his data fields. We use a list of memebers we want to update on any change within the corrent UndoableStringBuilder of GroupAdmin, those are basicly our subscribers and the UndoableStringBuilder is our content we want to publish.

#### How to use the project
First, clone the git repository and open it as a project in your IDE.
Than, use the tests we created OR create new GroupAdmin, and ConcreteMembers and see how the GroupAdmin as the sender, updates his ConcreteMembers as the Members when we change the UndoableStringBuilder.
