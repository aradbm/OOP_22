package observer;

public class ConcreteMember implements Member {
    private UndoableStringBuilder usb;
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
     * This method returns the corrent usb
     * 
     * @return this UndoableStringBuilder
     */
    public UndoableStringBuilder getUsb() {
        return usb;
    }
}