package observer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Arad Ben Menashe
 * @version 1.0.0
 */
public class GroupAdmin implements Sender {
    private List<Member> members;
    private UndoableStringBuilder usb;

    /**
     * Constructor
     */
    public GroupAdmin() {
        this.members = new LinkedList<>();
        this.usb = new UndoableStringBuilder();
    }

    /**
     * This method updates all the members with the newest UndoableStringBuilder
     */
    public void updateMembers() {
        for (Member o : this.members) {
            o.update(usb);
        }
    }

    /**
     * This method adds given member to the members list.
     * 
     * @param obj is the member to add
     */
    @Override
    public void register(Member obj) {
        if (members.contains(obj)) {
            System.out.println("This member already exist in the members list.");
        } else {
            members.add(obj);
            obj.update(usb);
        }
    }

    /**
     * This method removes given member off the members list.
     * 
     * @param obj is the member to remove
     */
    @Override
    public void unregister(Member obj) {
        if (members.contains(obj)) {
            // obj.update(new UndoableStringBuilder()); // stops the member from pointing to GroupAdmin's usb.
            members.remove(obj);
        } else {
            System.err.println("This member already isn't a member.");
        }
    }

    /**
     * Inserts the string into this character sequence. And updates all members.
     * 
     * @param offset insex to start insert
     * @param str    string to add
     * @exception StringIndexOutOfBoundsException if start is negative or greater
     */
    @Override
    public void insert(int offset, String obj) {
        usb.insert(offset, obj);
        updateMembers();
    }

    /**
     * Appends the specified string to this character sequence. And updates all
     * members.
     * 
     * @param obj is the string to add
     */
    @Override
    public void append(String obj) {
        usb.append(obj);
        updateMembers();
    }

    /**
     * Removes the characters in a substring of this sequence. And updates all
     * members.
     * 
     * @param start index to start delete
     * @param end   index to stop delete
     * @exception StringIndexOutOfBoundsException if start is negative or greater
     *                                            than.
     */
    @Override
    public void delete(int start, int end) {
        usb.delete(start, end);
        updateMembers();
    }

    /**
     * Erases the last change done to the document, reverting it to an older state.
     * And updates all members.
     * 
     * @exception EmptyStackException if stack is empty
     */
    @Override
    public void undo() {
        usb.undo();
        updateMembers();
    }
}