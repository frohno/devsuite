/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package client.presentation.utils.credentials;

import javafx.beans.property.BooleanProperty;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Hounsvad
 */
public class CredentialContainerTest {

    public CredentialContainerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    private CredentialContainer anInstance = CredentialContainer.getInstance();

    /**
     * Test of getInstance method, of class CredentialContainer.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        CredentialContainer expResult = anInstance;
        CredentialContainer result = CredentialContainer.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCredentialReadyProperty method, of class CredentialContainer.
     */
    @Test
    public void testGetCredentialReadyProperty() {
        System.out.println("getCredentialReadyProperty");
        CredentialContainer instance = null;
        BooleanProperty expResult = null;
        BooleanProperty result = instance.getCredentialReadyProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of openLoginWindow method, of class CredentialContainer.
     */
    @Test
    public void testOpenLoginWindow() {
        System.out.println("openLoginWindow");
        CredentialContainer instance = null;
        instance.openLoginWindow();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkTimeValid method, of class CredentialContainer.
     */
    @Test
    public void testCheckTimeValid() {
        System.out.println("checkTimeValid");
        CredentialContainer instance = null;
        boolean expResult = false;
        boolean result = instance.checkTimeValid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class CredentialContainer.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        CredentialContainer instance = null;
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class CredentialContainer.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        CredentialContainer instance = null;
        instance.setUsername(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class CredentialContainer.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        CredentialContainer instance = null;
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class CredentialContainer.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        CredentialContainer instance = null;
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
