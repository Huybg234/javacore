package timekeeping;

import entity.Department;
import entity.Staff;

import java.io.Serializable;

public class TimeKeeper implements Serializable {
    private Staff staff;
    private Department department;
    private int TimeWork;

    public TimeKeeper() {
    }

    public TimeKeeper(Staff staff, Department department, int timeWork) {
        this.staff = staff;
        this.department = department;
        TimeWork = timeWork;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getTimeWork() {
        return TimeWork;
    }

    public void setTimeWork(int timeWork) {
        TimeWork = timeWork;
    }

    @Override
    public String toString() {
        return "TimeKeeping{" +
                "staff=" + staff +
                ", department=" + department +
                ", TimeWork=" + TimeWork +
                '}';
    }
}
