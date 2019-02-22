import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        LinkedHashMap<String, Department> departments = new LinkedHashMap<>();
        LinkedHashMap<String, Doctor> doctors = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String[] lines = input.split("\\s+");

            if (lines.length == 4) {
                String departmentName = lines[0];
                String doctorFirstName = lines[1];
                String doctorLastName = lines[2];
                String patientName = lines[3];

                Department department = null;
                Doctor doctor = null;

                if (departments.get(departmentName) == null) {
                    department = new Department(departmentName);
                    departments.put(departmentName, department);
                } else {
                    department = departments.get(departmentName);
                }

                if (doctors.get(doctorFirstName + " " + doctorLastName) == null) {
                    doctor = new Doctor(doctorFirstName, doctorLastName);
                    doctors.put(doctorFirstName + " " + doctorLastName, doctor);
                } else {
                    doctor = doctors.get(doctorFirstName + " " + doctorLastName);
                }

                if (!doctor.departments.contains(department)) {
                    doctor.departments.add(department);
                }

                boolean hasFreeBeds = false;
                for (Room room : department.rooms) {
                    for (Bed bed : room.beds) {
                        if (bed.isFree) {
                            bed.patient = new Patient(patientName, doctor);
                            bed.isFree = false;
                            hasFreeBeds = true;
                            break;
                        }
                    }
                    if (hasFreeBeds) {
                        break;
                    }
                }
            }

            if (lines[0].equals("Output")) {
                input = bufferedReader.readLine();
                while (!input.equals("End")) {
                    lines = input.split("\\s+");
                    if (departments.containsKey(lines[0])) {
                        List<Patient> patients = new ArrayList<>();
                        Department department = departments.get(lines[0]);
                        if (lines.length > 1) {
                            Room room = department.rooms[Integer.parseInt(lines[1]) - 1];
                            for (Bed bed : room.beds) {
                                if (bed.patient != null) {
                                    patients.add(bed.patient);
                                } else {

                                }
                            }
                            patients.sort((p1, p2) -> p1.name.compareTo(p2.name));
                            patients.forEach(patient -> System.out.println(patient.name));
                        } else {
                            Room[] rooms = department.rooms;
                            for (Room room : rooms) {
                                for (Bed bed : room.beds) {
                                    if (bed.patient != null) {
                                        patients.add(bed.patient);
                                    }
                                }
                            }
                            patients.forEach(patient -> System.out.println(patient.name));
                        }
                    } else if (doctors.containsKey(lines[0] + " " + lines[1])) {
                        Doctor doctor = doctors.get(lines[0] + " " + lines[1]);
                        List<Patient> patients = new ArrayList<>();
                        List<Department> doctorDepartments = doctor.departments;
                        for (Department department : doctorDepartments) {
                            for (Room room : department.rooms) {
                                for (Bed bed : room.beds) {
                                    if (bed.patient != null && bed.patient.doctor.equals(doctor)) {
                                        patients.add(bed.patient);
                                    }
                                }
                            }
                        }

                        patients.sort((p1, p2) -> p1.name.compareTo(p2.name));
                        patients.forEach(patient -> System.out.println(patient.name));
                    }
                    input = bufferedReader.readLine();
                }
                break;
            }
            input = bufferedReader.readLine();
        }
    }

    private static class Doctor {
        private List<Department> departments;
        private String firstName;
        private String lastName;

        public Doctor(String firstName, String lastName) {
            this.departments = new ArrayList<>();
            this.firstName = firstName;
            this.lastName = lastName;
        }

        private void addDepartment(Department department) {
            this.departments.add(department);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Doctor doctor = (Doctor) o;
            return Objects.equals(departments, doctor.departments) &&
                    Objects.equals(firstName, doctor.firstName) &&
                    Objects.equals(lastName, doctor.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(departments, firstName, lastName);
        }
    }

    private static class Room {
        private Bed[] beds;

        public Room() {
            this.beds = new Bed[3];
            initBeds();
        }

        private void initBeds() {
            for (int i = 0; i < this.beds.length; i++) {
                this.beds[i] = new Bed();
            }
        }
    }

    private static class Department {
        private Room[] rooms;
        private String name;

        public Department(String name) {
            this.name = name;
            this.rooms = new Room[20];
            this.initRooms();
        }

        private void initRooms() {
            for (int i = 0; i < this.rooms.length; i++) {
                this.rooms[i] = new Room();
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Department that = (Department) o;
            return Arrays.equals(rooms, that.rooms) &&
                    Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(name);
            result = 31 * result + Arrays.hashCode(rooms);
            return result;
        }
    }

    private static class Bed {
        private boolean isFree;
        private Patient patient;

        public Bed() {
            this.isFree = true;
            this.patient = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Bed bed = (Bed) o;
            return isFree == bed.isFree &&
                    Objects.equals(patient, bed.patient);
        }

        @Override
        public int hashCode() {
            return Objects.hash(isFree, patient);
        }
    }

    private static class Patient {
        private String name;
        private Doctor doctor;

        public Patient(String name, Doctor doctor) {
            this.name = name;
            this.doctor = doctor;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Patient patient = (Patient) o;
            return Objects.equals(name, patient.name) &&
                    Objects.equals(doctor, patient.doctor);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, doctor);
        }
    }
}
