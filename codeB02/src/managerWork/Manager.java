package managerWork;

import companyPerson.Staff;
import companyRoom.Room;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Manager {
    private Staff staff;
    private Room room;
    private int day;
//    List<ManagerPair> managerDS = new ArrayList<>();

    public Manager() {
    }

    public Manager(Staff staff, List<ManagerPair> managerDS) {
        this.staff = staff;
        this.managerDS = managerDS;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public List<ManagerPair> getManagerDS() {
        return managerDS;
    }

    public void setManagerDS(List<ManagerPair> managerDS) {
        this.managerDS = managerDS;
    }

    public void ghiFile() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("DSCC  .txt", true))) {
            objectOutputStream.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Manager{" +
                "staff=" + staff +
                ", managerDS=" + managerDS +
                '}';
    }
}
