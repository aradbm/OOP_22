package observer;

public class ConcreteMember implements Member {
    private UndoableStringBuilder usb;
    private String name;

    public ConcreteMember(String name) {
        this.name = name;
    }

    /**
     * This method update this member UndoableStringBuilder to the most recent one.
     * 
     * @param usb is the UndoableStringBuilder to update.
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        this.usb = usb;
    }

    /**
     * This method returns the corrent UndoableStringBuilder
     * 
     * @return this UndoableStringBuilder
     */
    public UndoableStringBuilder getUsb() {
        return this.usb;
    }

    /**
     * returns String of corrent undoablestringbuilder
     */
    @Override
    public String toString() {
        return this.usb.toString();
    }

    /**
     * 
     * @return name of memeber
     */
    public String getName() {
        return name;
    }
}