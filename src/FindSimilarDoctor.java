import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by PaiGe on 2016/10/7.
 */
public class FindSimilarDoctor {
    /**
     * initial the doctor list
     * @return a list of doctors
     */
    public List<Doctor> init() {
        List<Doctor> doctorList = new ArrayList<>();
        doctorList.add(new Doctor.DoctorBuilder("Alice", "Agzarian")
                .setSpeciality("Internal Medicine").setHospital("Ronald Reagan UCLA Medical Center")
                .setCity("Los Angeles").setRate(5).build());
        doctorList.add(new Doctor.DoctorBuilder("Blake", "Alban")
                .setSpeciality("Pediatrics").setHospital("Mattel Children's Hospital UCLA")
                .setCity("Los Angeles").setRate(3).build());
        doctorList.add(new Doctor.DoctorBuilder("Martin", "Anderson")
                .setSpeciality("Pediatrics").setHospital("Mattel Children's Hospital UCLA")
                .setCity("Los Angeles").setRate(5).build());
        doctorList.add(new Doctor.DoctorBuilder("Sonya", "Brown")
                .setSpeciality("Family Medicine").setSpeciality("Hospitalist")
                .setSpeciality("Internal Medicine").setHospital("Mattel Children's Hospital UCLA")
                .setCity("Los Angeles").setRate(4).build());
        doctorList.add(new Doctor.DoctorBuilder("Grace", "Chen")
                .setSpeciality("Medicine").setSpeciality("Geriatric Medicine").setHospital("UCLA Medical Center, Santa Monica")
                .setCity("Los Angeles").setRate(2).build());
        doctorList.add(new Doctor.DoctorBuilder("Jennifer", "Yeung")
                .setSpeciality("Medicine").setSpeciality("Cardiac Congenital").setSpeciality("Pediatrics").setHospital("Ronald Reagan UCLA Medical Center")
                .setCity("Los Angeles").setRate(3).build());
        doctorList.add(new Doctor.DoctorBuilder("Thomas", "Bush")
                .setSpeciality("Medicine").setSpeciality("Rheumatology").setHospital("Santa Clara Valley Medical Center")
                .setCity("Santa Clara").setRate(4).build());
        doctorList.add(new Doctor.DoctorBuilder("Andrew", "Ho")
                .setSpeciality("Internal Medicine").setSpeciality("Gastroenterology").setHospital("Santa Clara Valley Medical Center")
                .setCity("Santa Clara").setRate(5).build());
        doctorList.add(new Doctor.DoctorBuilder("Christopher", "Elliott")
                .setSpeciality("Urology").setHospital("Santa Clara Valley Medical Center")
                .setCity("Santa Clara").setRate(5).build());
        return doctorList;
    }

    /**
     * find doctors with similar specialty in the same city
     * @param doc
     * @param doctors
     * @return a list of doctors
     */
    public List<Doctor> find(Doctor doc, List<Doctor> doctors) {
        List<Doctor> findResult = new ArrayList<>();
        for (Doctor curDoctor : doctors) {
            if (curDoctor == doc) {
                continue;
            }
            // find doctors in the same city
            if (curDoctor.getCity().equals(doc.getCity())) {
                // find doctors with same specialty
                for (String spec : doc.getSpeciality()) {
                    if (curDoctor.getSpeciality().contains(spec)) {
                        findResult.add(curDoctor);
                        continue;
                    }
                }
            }
        }
        Collections.sort(findResult);
        return findResult;
    }

    /**
     * print doctor information
     * @param doc
     */
    public void printDoctor(Doctor doc) {
        if (doc == null) {
            return;
        }
        System.out.println("Name: " + doc.getFirstName() + " " + doc.getLastName());
        System.out.print("Specialties: ");
        for (String spec : doc.getSpeciality()) {
            System.out.print(spec + " ");
        }
        System.out.println();
        System.out.println("Hospital: " + doc.getHospital());
        System.out.println("City: " + doc.getCity());
        System.out.println("Rating: " + doc.getRate());
        System.out.println();
        return;
    }

    /**
     * print doctor list
     * @param doctors
     */
    public void printDoctorList(List<Doctor> doctors) {
        if (doctors == null || doctors.size() == 0) {
            System.out.println("No search results");
            return;
        }
        for (Doctor cur : doctors) {
            printDoctor(cur);
        }
        return;
    }
}
