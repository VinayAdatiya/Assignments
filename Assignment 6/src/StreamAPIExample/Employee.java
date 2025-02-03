package StreamAPIExample;

public class Employee {
    private String empId;
    private String department;
    private double salary;

    public Employee(String empId, String department, double salary) {
        this.empId = empId;
        this.department = department;
        this.salary = salary;
    }

    public Employee(String department, double salary) {
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "StreamAPIExample.Employee{" +
                "empId='" + empId + '\'' +
                ", Department='" + this.department + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
