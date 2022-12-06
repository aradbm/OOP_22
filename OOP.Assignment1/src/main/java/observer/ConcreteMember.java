package observer;

public class ConcreteMember implements Member {
    UndoableStringBuilder usb;

    /**
     * Constructor
     * 
     * @param obj is the given subscription service.
     */
    public ConcreteMember(GroupAdmin obj) {
        subscribe(obj);
    }

    /**
     * This method subscibes this concrete user to the given subscription service.
     * 
     * @param obj is the subscription service
     */
    public void subscribe(GroupAdmin obj) {
        obj.register(this);
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
}