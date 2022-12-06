import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import observer.ConcreteMember;
import observer.GroupAdmin;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);

    // stub method to check external dependencies compatibility

    @Test
    public void TestGroupAdmin() {

    }

    @Test
    public void TestConcreteMember() {
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
        logger.info(() -> JvmUtilities.objectFootprint(cr1));
        logger.info(() -> JvmUtilities.objectFootprint(cr1, cr2));
        logger.info(() -> JvmUtilities.objectTotalSize(cr1));
        logger.info(() -> JvmUtilities.objectTotalSize(cr1, cr2));
        logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    public void test() {
        String s1 = "Alice";
        String s2 = "Bob";

        logger.info(() -> JvmUtilities.objectFootprint(s1));

        logger.info(() -> JvmUtilities.objectFootprint(s1, s2));

        logger.info(() -> JvmUtilities.objectTotalSize(s1));

        logger.info(() -> JvmUtilities.jvmInfo());
    }
}