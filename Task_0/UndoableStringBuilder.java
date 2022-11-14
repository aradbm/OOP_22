import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author Arad Ben Menashe & Neta Cohen
 * @version 1.0.0
 */
public class UndoableStringBuilder {
    private StringBuilder STR;
    private Stack<StringBuilder> STR_STACK;

    /**
     * Constructor of UndoableStringBuilder.
     */
    public UndoableStringBuilder() {
        STR = new StringBuilder("");
        STR_STACK = new Stack<StringBuilder>();
    }

    /**
     * This method undoes last change on string.
     * 
     * @exception EmptyStackException if stack is empty
     */
    public void undo() {
        try {
            STR_STACK.pop();
            this.STR = new StringBuilder(STR_STACK.peek());
        } catch (EmptyStackException e) {
            STR = new StringBuilder("");
            System.err.println("Too many undoes! " + e);
        }
    }

    /**
     * This method adds given string to current stringbuilder.
     * 
     * @param add_str string to add
     */
    public UndoableStringBuilder append(String add_str) {
        this.STR.append(add_str);
        STR_STACK.push(new StringBuilder(this.STR));

        return this;
    }

    /**
     * This method delete string in current stringbuilder in given range.
     * 
     * @param start index to start delete
     * @param end   index to stop delete
     * @exception StringIndexOutOfBoundsException if start is negative or greater
     *                                            than.
     */
    public UndoableStringBuilder delete(int start, int end) {
        try {
            this.STR.delete(start, end);
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("input for index is incorrect " + e);
        }
        return this;
    }

    /**
     * This method adds string in given index
     * 
     * @param offset insex to start insert
     * @param str    string to add
     * @exception StringIndexOutOfBoundsException if start is negative or greater
     */
    public UndoableStringBuilder insert(int offset, String str) {
        STR_STACK.push(new StringBuilder(this.STR));
        try {
            this.STR.insert(offset, str);
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("input for index is incorrect" + e);
        }
        return this;
    }

    /**
     * This method replaces given string in given range
     * 
     * @param start start of replace
     * @param end   end of replace
     * @param str   string to replace
     * @exception StringIndexOutOfBoundsException if index is illegal
     */
    public UndoableStringBuilder replace(int start, int end, String str) {

        try {
            this.STR.replace(start, end, str);
            STR_STACK.push(new StringBuilder(this.STR));
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("input for index is incorrect" + e);
        }
        return this;
    }

    /**
     * This method reverses the string in stringbuilder.
     */
    public UndoableStringBuilder reverse() {
        this.STR.reverse();
        STR_STACK.push(new StringBuilder(this.STR));
        return this;
    }

    /**
     * This method returns string of current string builder.
     * 
     * @return current string
     */
    @Override
    public String toString() {
        return this.STR.toString();
    }
}