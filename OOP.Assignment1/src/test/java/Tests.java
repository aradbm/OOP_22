import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import observer.ConcreteMember;
import observer.GroupAdmin;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);

    @Test
    public void TestGroupAdmin() {
        GroupAdmin gad = new GroupAdmin();
        gad.append("hello world");
        ConcreteMember cr1 = new ConcreteMember(gad);
        ConcreteMember cr2 = new ConcreteMember(gad);
        ConcreteMember cr3 = new ConcreteMember(gad);
        ConcreteMember cr4 = new ConcreteMember(gad);
        gad.register(cr1);
        gad.register(cr2);
        gad.register(cr3);
        gad.register(cr4);
        gad.register(cr4);

        assertEquals(cr2.getUsb().toString(), "hello world");
        gad.unregister(cr4);
        gad.delete(2, 4);
        gad.append("!");
        assertEquals(cr3.getUsb().toString(), "heo world!");
        assertEquals("", cr4.getUsb().toString());
        assertEquals(cr2.getUsb(), cr1.getUsb());
        gad.unregister(cr2);

        // logger.info(() -> JvmUtilities.objectFootprint(cr4));
        // logger.info(() -> (cr4.getUsb().toString()));
        // logger.info(() -> JvmUtilities.objectFootprint(cr1));
        // logger.info(() -> JvmUtilities.objectFootprint(cr2));
        // logger.info(() -> JvmUtilities.objectTotalSize(cr1));
        // logger.info(() -> JvmUtilities.objectTotalSize(cr2));
        // logger.info(() -> JvmUtilities.objectTotalSize(cr1, cr2));
        // logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    public void TestConcreteMember() {

    }
}