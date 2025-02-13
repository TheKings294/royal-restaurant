import java.util.Date;

public class Employe {
    public static int number = 0;
    private int id;
    private String firstName;
    private String lastName;
    private String role;
    private Date dateOfStartingJob;
    private double salary;

    public Employe(String firstName, String lastName, String role, Date dateOfStartingJob, double salary) {
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
    public Date getDateOfStartingJob() {
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
    public void setDateOfStartingJob(Date dateOfStartingJob) {
        this.dateOfStartingJob = dateOfStartingJob;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
}