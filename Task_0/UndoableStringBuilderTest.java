import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UndoableStringBuilderTest {
    @Test
    public void undoTester() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.undo();
        assertEquals("", usb.toString());

        usb.append("to eat or not to eat");
        usb.replace(2, 3, "dsfsdf");
        usb.undo();
        usb.undo();
        usb.undo();
        usb.undo();
        assertEquals("", usb.toString());
    }

    @Test
    public void deleteTester() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("to eat or not to eat");
        usb.delete(-300, 6);
        assertEquals("to eat or not to eat", usb.toString());

        usb.delete(0, 0);
        assertEquals("to eat or not to eat", usb.toString());
    }

    @Test
    public void insertTester() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.insert(0, "to eat or not to eat");
        assertEquals("to eat or not to eat", usb.toString());

        usb.undo();
        usb.insert(70, "to eat or not to eat");
        assertEquals("", usb.toString());

        usb.undo();
        usb.insert(-10, "to eat or not to eat");
        assertEquals("", usb.toString());
    }

    @Test
    public void replaceTester() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.replace(0, 0, "to eat or not to eat");
        assertEquals("to eat or not to eat", usb.toString());

        usb.undo();
        usb.replace(-12, 1, "dsfdsf");
        assertEquals("", usb.toString());

        usb.append("null");
        usb.replace(22, 30, "dsfdsf");
        assertEquals("null", usb.toString());
    }

    @Test
    public void reverseTester() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.reverse();
        assertEquals("", usb.toString());
    }
}