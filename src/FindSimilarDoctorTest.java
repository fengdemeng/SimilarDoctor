import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by PaiGe on 2016/10/7.
 */
public class FindSimilarDoctorTest {
    List<Doctor> doctors;
    FindSimilarDoctor test;

    /**
     * initialize the test
     */
    @Before
    public void setUp() {
        test = new FindSimilarDoctor();
        doctors = test.init();
    }

    /**
     * test find()
     */
    @Test
    public void testFind() {
        List<Doctor> result = test.find(doctors.get(1), doctors);
        assertEquals(result.size(), 2);
        assertEquals(result.get(0).getFirstName(), "Martin");
        assertEquals(result.get(0).getLastName(), "Anderson");
        assertEquals(result.get(0).getSpeciality().contains("Pediatrics"), true);
        assertEquals(result.get(0).getHospital(), "Mattel Children's Hospital UCLA");
        assertEquals(result.get(0).getCity(), "Los Angeles");
        assertEquals(result.get(0).getRate(), 5);
        assertEquals(result.get(1).getFirstName(), "Jennifer");
        assertEquals(result.get(1).getLastName(), "Yeung");
        assertEquals(result.get(1).getSpeciality().contains("Pediatrics"), true);
        assertEquals(result.get(1).getHospital(), "Ronald Reagan UCLA Medical Center");
        assertEquals(result.get(1).getCity(), "Los Angeles");
        assertEquals(result.get(1).getRate(), 3);
    }

}