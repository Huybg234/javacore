package run;

import companyPerson.Staff;
import companyRoom.Room;
import managerWork.Manager;
import managerWork.ManagerPair;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main implements Serializable {
    private static List<Staff> staffList = new ArrayList<>();
    private static List<Room> roomList = new ArrayList<>();
    private static List<Manager> managerList = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    InputInformationStaff();
                    OutStaffList();
                    break;
                case 2:
                    InputInformationRoom();
                    OutputRoomList();
                    break;
                case 3:
                    ManagerWork();
                    outputManager();
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    System.exit(0);
            }
        } while (true);
    }

    public static int functionChoice() {
        System.out.println("--------Phần mềm quản lý nhân sự-----------");
        System.out.println("1.Nhập danh sách nhân viên mới");
        System.out.println("2.Nhập danh sách phòng ban");
        System.out.println("3.Quản lý chấm công");
        System.out.println("4.Sắp xếp danh sách phân công");
        System.out.println("5.Thống kê thu nhập cho mỗi nhân viên");
        System.out.println("6.Thoát");
        System.out.print("Xin mời chọn chức năng: ");
        int functionChoice;
        do {
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice >= 1 && functionChoice <= 6) {
                break;
            }
            System.out.println("Nhập không hợp lệ! Vui lòng nhập lại");
        } while (true);
        return functionChoice;
    }

    public static void InputInformationStaff() {
        System.out.println("Nhập số lượng nhân viên mới: ");
        int allStaff = 0;
        boolean checked = true;
        do {
            try {
                allStaff = new Scanner(System.in).nextInt();
                checked = true;
            } catch (Exception ignored) {
            }
            if (allStaff <= 0) {
                System.out.print("Số nhân viên mới lớn hơn 0 và không có chữ! Nhập lại: ");
                checked = false;
            }
        } while (!checked);

        for (int i = 0; i < allStaff; i++) {
            Staff staff = new Staff();
            staff.inputStaffInformation();
            staffList.add(staff);
//            staff.ghiFile();
        }
        // ghi cả list
    }

    public static void OutStaffList() {
        staffList.forEach(new Consumer<Staff>() {
            @Override
            public void accept(Staff s) {
                s.OutputStaffInformation();
            }
        });
    }

    public static void InputInformationRoom() {
        System.out.println("Nhập số lượng phòng: ");
        int allRoom = 0;
        boolean checked = true;
        do {
            try {
                allRoom = new Scanner(System.in).nextInt();
                checked = true;
            } catch (Exception e) {
            }
            if (allRoom <= 0) {
                System.out.print("Số phòng lớn hơn 0 và không có chữ! Nhập lại: ");
                checked = false;
            }
        } while (!checked);
        for (int i = 0; i < allRoom; i++) {
            Room room = new Room();
            room.inputRoomInformation();
            roomList.add(room);
//            room.ghiFile();
        }
        // ghi cả list
    }

    public static void OutputRoomList() {
        roomList.forEach(new Consumer<Room>() {
            @Override
            public void accept(Room r) {
                r.outputRoomInformation();
            }
        });
    }

    private static boolean isValidStaffAndRoom() {
        return staffList != null && roomList != null && staffList.size() > 0 && roomList.size() > 0;
    }

    public static void ManagerWork() {
        if (!isValidStaffAndRoom()) {
            System.out.println("Bạn cần nhập danh sách nhân viên và phòng ban khi cho quản lý!");
            return;
        }
        List<ManagerPair> managerDS = new ArrayList<>();
        for (int i = 0; i < staffList.size(); i++) {
            System.out.println("Chấm công cho nhân viên " +(i+1) + " : ");
            System.out.println("Nhập tên phòng ban của nhân viên " + (i+1) + " : ");
            String tempName;
            do {
                tempName = new Scanner(System.in).nextLine();
                Room room = searchRoom(tempName);
                if (room != null) {
                    System.out.println("Nhập số ngày làm việc trong tháng: ");
                    int d = 0;
                    boolean check = true;
                    do {
                        try {
                            d = new Scanner(System.in).nextInt();
                            check = true;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (d <= 0 || d > 22) {
                            System.out.print("Nhập không hợp lệ! Nhập lại: ");
                            check = false;
                        }

                    } while (!check);
                    managerDS.add(new ManagerPair(room,d));
                    break;
                }
               else {System.out.println("Không có tên phòng ban vừa nhập! Nhập lại:");}
            } while (true);
        Manager manager = new Manager(staffList.get(i),managerDS);
        managerList.add(manager);
    }
}
    private static void outputManager(){
        System.out.println("Danh sách quản lý nhân viên hiện tại là:");
        for (int i = 0; i < managerList.size(); i++) {
            System.out.println(managerList.get(i));
        }
    }

    private static Room searchRoom(String name) {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getName().equals(name)) {
                return roomList.get(i);
            }
        }
        return null;
    }

}
