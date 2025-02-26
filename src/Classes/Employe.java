package Classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Employe {
    public static int number = 0;
    private int id;
    private String firstName;
    private String lastName;
    private String role;
    private LocalDate dateOfStartingJob;
    private double salary;

    public Employe(String firstName, String lastName, String role, LocalDate dateOfStartingJob, double salary) {
        Employe.number++;
        this.id = Employe.number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.dateOfStartingJob = dateOfStartingJob;
        this.salary = salary;
    }

    public String getId() {
        return Integer.toString(this.id);
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public LocalDate getDateOfStartingJob() {
        return this.dateOfStartingJob;
    }
    public String getSalary() {
        return Double.toString(this.salary);
    }
    public String getRole() {
        return this.role;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void setDateOfStartingJob(LocalDate dateOfStartingJob) {
        this.dateOfStartingJob = dateOfStartingJob;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public static String createDir(String path) {
        File dir = new File(path + "/employe");
        dir.mkdir();
        return dir.getAbsolutePath();
    }
    public void createFileEmploye(String path, String name) {
        try {
            File file = new File(createDir(path + "/" + name + ".json"));
            BufferedWriter buf = new BufferedWriter(new FileWriter(path + "/" + name + ".json"));
            buf.append("{"+
                    "\"first-name\":\"" + this.firstName + "\","
                    + "\"last-name\":\"" + this.lastName + "\","
                    + "\"role\":\"" + this.role + "\","
                    + "\"date\":\"" + this.dateOfStartingJob + "\","
                    + "\"salary\":\"" + this.salary + "\""
                    + "}");
            buf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}