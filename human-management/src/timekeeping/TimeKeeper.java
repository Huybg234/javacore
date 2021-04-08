package timekeeping;

import entity.Department;
import entity.Staff;

public class TimeKeeper {

    private Staff staff;
    private Department department;
    private int workingDay;

    public TimeKeeper() {
    }


    public TimeKeeper(Staff staff, Department department, int workingDay) {
        this.staff = staff;
        this.department = department;
        this.workingDay = workingDay;
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

    public int getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(int workingDay) {
        this.workingDay = workingDay;
    }

    @Override
    public String toString() {
        return "TimeKeeper{" +
                "staff=" + staff +
                ", department=" + department +
                ", workingDay=" + workingDay +
                '}';
    }
}
