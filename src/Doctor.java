import java.util.HashSet;
import java.util.Set;

/**
 * Created by PaiGe on 2016/10/7.
 */
public class Doctor implements Comparable<Doctor>{
    private final String firstName;
    private String lastName;
    private Set<String> speciality;
    private String hospital;
    private String city;
    private int rate;

    private Doctor(DoctorBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.speciality = builder.speciality;
        this.hospital = builder.hospital;
        this.city = builder.city;
        this.rate = builder.rate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<String> getSpeciality() {
        return speciality;
    }

    public String getHospital() {
        return hospital;
    }

    public String getCity() {
        return city;
    }

    public int getRate() {
        return rate;
    }

    @Override
    public int compareTo(Doctor doc) {
        if (this.rate == doc.rate) {
            return 0;
        }
        return this.rate > doc.rate ? -1 : 1;
    }

    /**
     * builder pattern for Doctor
     */
    public static class DoctorBuilder {
        private final String firstName;
        private String lastName;
        private Set<String> speciality = new HashSet<>();
        private String hospital = "";
        private String city = "";
        private int rate = 0;

        public DoctorBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public DoctorBuilder setSpeciality(String speciality) {
            this.speciality.add(speciality);
            return this;
        }

        public DoctorBuilder setHospital(String hospital) {
            this.hospital = hospital;
            return this;
        }

        public DoctorBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public DoctorBuilder setRate(int rate) {
            this.rate = rate;
            return this;
        }

        public Doctor build() {
            return new Doctor(this);
        }
    }
}
