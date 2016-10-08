import java.util.List;

public class Main {

    public static void main(String[] args) {
        FindSimilarDoctor findDoctor = new FindSimilarDoctor();
        List<Doctor> doctors = findDoctor.init();
        // randomly select a doctor from doctor list
        int random = (int) (Math.random() * doctors.size());
        System.out.println("Doctor:");
        findDoctor.printDoctor(doctors.get(random));
        System.out.println("Search Result:");
        // search the similar doctor
        List<Doctor> recommendation = findDoctor.find(doctors.get(random), doctors);
        findDoctor.printDoctorList(recommendation);
    }
}
