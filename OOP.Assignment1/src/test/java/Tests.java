import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import observer.ConcreteMember;
import observer.GroupAdmin;
import observer.UndoableStringBuilder;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);

    @Test
    public void TestGroupAdmin() {
        GroupAdmin gad = new GroupAdmin();
        logger.info(() -> JvmUtilities.objectTotalSize(gad));
        gad.append("hello world");
        logger.info(() -> JvmUtilities.objectTotalSize(gad));
        ConcreteMember cr1 = new ConcreteMember();
        ConcreteMember cr2 = new ConcreteMember();
        ConcreteMember cr3 = new ConcreteMember();
        ConcreteMember cr4 = new ConcreteMember();
        gad.register(cr1);
        gad.register(cr2);
        gad.register(cr3);
        gad.register(cr4);
        gad.register(cr4); // return err msg for duplicate
        gad.append("dfgfdg");
        // We are checkign here if the ConcreteMembers are the same size because they have the same UndoableStringBuilder pointer
        logger.info(() -> JvmUtilities.objectTotalSize(cr1));
        logger.info(() -> JvmUtilities.objectTotalSize(cr2));
        assertEquals(JvmUtilities.objectTotalSize(cr1), JvmUtilities.objectTotalSize(cr2));

        // Checking undo and delete methods on different ConcreteMembers
        gad.undo();
        assertEquals(cr2.getUsb().toString(), "hello world");
        gad.unregister(cr4);
        gad.delete(2, 4);
        assertEquals(cr3.getUsb().toString(), "heo world");
        assertEquals(cr2.getUsb(), cr1.getUsb());

        // checking heap size after unregistering a ConcreteMember
        logger.info(() -> ("Size of GroupAdmin before unrigester:"));
        logger.info(() -> JvmUtilities.objectTotalSize(gad));
        gad.unregister(cr2);
        logger.info(() -> ("Size of GroupAdmin after unrigester:"));
        logger.info(() -> JvmUtilities.objectTotalSize(gad));
    }

    @Test
    public void TestConcreteMember() {
        
        GroupAdmin gad = new GroupAdmin();
        ConcreteMember cr1 = new ConcreteMember();
        logger.info(() -> JvmUtilities.objectTotalSize(cr1));

        gad.register(cr1);
        gad.append("hello");
        assertEquals("hello", cr1.getUsb().toString());
        gad.append(" world");
        assertEquals("hello world", cr1.getUsb().toString());
        logger.info(() -> JvmUtilities.objectTotalSize(cr1));
        gad.append("!");
        gad.unregister(cr1);
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("hey!");
        cr1.update(usb);
        assertEquals("hey!", cr1.getUsb().toString());
        logger.info(() -> JvmUtilities.objectTotalSize(cr1));
    }
}