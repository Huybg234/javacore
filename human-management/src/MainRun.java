import entity.Department;
import entity.Staff;
import service.FileUtil;
import timekeeping.TimeKeeper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainRun {

    private static final String STAFF_LIST_FILE = "Staff.dat";
    private static final String TIME_SHEET = "TimeKeeper.dat";

    private static List<Staff> staffs = new ArrayList<>();
    private static List<Department> departments = new ArrayList<>();
    private static List<TimeKeeper> timeKeepers = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    inputStaffInfo();
                    showStaffInfo();
                    break;
                case 2:
//                    InputInformationRoom();
//                    OutputRoomList();
                    break;
                case 3:
                    createTimeKeepingTable();
//                    outputManager();
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
            // TODO - xử lý nhập chữ!!!
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice >= 1 && functionChoice <= 6) {
                break;
            }
            System.out.println("Nhập không hợp lệ! Vui lòng nhập lại");
        } while (true);
        return functionChoice;
    }

    public static void inputStaffInfo() {
        System.out.print("Nhập số lượng nhân viên mới: ");
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
            staff.inputInfo();
            staffs.add(staff);
//            staff.ghiFile();
        }
        // ghi cả list
        FileUtil.writeDataToFile(staffs, STAFF_LIST_FILE);
    }

    public static void showStaffInfo() {
        staffs.forEach(s -> System.out.println(s));
    }


    private static void createTimeKeepingTable() {

        // TODO check xem đã nhập list nhân viên và phòng ban chưa --> chưa thì bắt nhập rồi mới đưiọc chấm công

        for (int i = 0; i < staffs.size(); i++) {
            System.out.println("---THỰC HIỆN CHẤM CÔNG CHO NHÂN VIÊN " + staffs.get(i).getName());
            System.out.println("Nhập id phòng ban mà nhân viên " + staffs.get(i).getName() + " làm việc: ");
            int deptId, workingDay = 0;
            Department tmpDepartment;
            do {
                deptId = new Scanner(System.in).nextInt();
                tmpDepartment = searchDept(deptId);
                if (tmpDepartment != null) {
                    System.out.println("Nhập số ngày làm việc trong tháng: ");
                    boolean check = true;
                    do {
                        try {
                            workingDay = new Scanner(System.in).nextInt();
                            check = true;
                        } catch (Exception e) {
                            //TODO - in ra lỗi bắt nhập lại
                        }
                        if (workingDay <= 0 || workingDay > 22) {
                            System.out.print("Nhập không hợp lệ! Nhập lại: ");
                            check = false;
                        }
                    } while (!check);
                    break;
                } else {
                    System.out.println("Không có tên phòng ban vừa nhập! Nhập lại:");
                }
            } while (true);
            TimeKeeper timeKeeper = new TimeKeeper(staffs.get(i), tmpDepartment, workingDay);
            timeKeepers.add(timeKeeper);
        }
        FileUtil.writeDataToFile(timeKeepers, TIME_SHEET);
    }

    private static Department searchDept(int deptId) {
        for (Department department : departments) {
            if (department.getId() == deptId) {
                return department;
            }
        }
        return null;
    }


//    public static void InputInformationRoom() {
//        System.out.println("Nhập số lượng phòng: ");
//        int allRoom = 0;
//        boolean checked = true;
//        do {
//            try {
//                allRoom = new Scanner(System.in).nextInt();
//                checked = true;
//            } catch (Exception e) {
//            }
//            if (allRoom <= 0) {
//                System.out.print("Số phòng lớn hơn 0 và không có chữ! Nhập lại: ");
//                checked = false;
//            }
//        } while (!checked);
//        for (int i = 0; i < allRoom; i++) {
//            Room room = new Room();
//            room.inputRoomInformation();
//            roomList.add(room);
////            room.ghiFile();
//        }
//        // ghi cả list
//    }
//
//    public static void OutputRoomList() {
//        roomList.forEach(new Consumer<Room>() {
//            @Override
//            public void accept(Room r) {
//                r.outputRoomInformation();
//            }
//        });
//    }

//    private static boolean isValidStaffAndRoom() {
//        return staffs != null && roomList != null && staffs.size() > 0 && roomList.size() > 0;
//    }
//
//    public static void ManagerWork() {
//        if (!isValidStaffAndRoom()) {
//            System.out.println("Bạn cần nhập danh sách nhân viên và phòng ban khi cho quản lý!");
//            return;
//        }
//        List<ManagerPair> managerDS = new ArrayList<>();
//        for (int i = 0; i < staffs.size(); i++) {
//            System.out.println("Chấm công cho nhân viên " + (i + 1) + " : ");
//            System.out.println("Nhập tên phòng ban của nhân viên " + (i + 1) + " : ");
//            String tempName;
//            do {
//                tempName = new Scanner(System.in).nextLine();
//                Room room = searchRoom(tempName);
//                if (room != null) {
//                    System.out.println("Nhập số ngày làm việc trong tháng: ");
//                    int d = 0;
//                    boolean check = true;
//                    do {
//                        try {
//                            d = new Scanner(System.in).nextInt();
//                            check = true;
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                        if (d <= 0 || d > 22) {
//                            System.out.print("Nhập không hợp lệ! Nhập lại: ");
//                            check = false;
//                        }
//
//                    } while (!check);
//                    managerDS.add(new ManagerPair(room, d));
//                    break;
//                } else {
//                    System.out.println("Không có tên phòng ban vừa nhập! Nhập lại:");
//                }
//            } while (true);
//            Manager manager = new Manager(staffs.get(i), managerDS);
//            managerList.add(manager);
//        }
//    }
//
//    private static void outputManager() {
//        System.out.println("Danh sách quản lý nhân viên hiện tại là:");
//        for (int i = 0; i < managerList.size(); i++) {
//            System.out.println(managerList.get(i));
//        }
//    }
//
//    private static Room searchRoom(String name) {
//        for (int i = 0; i < roomList.size(); i++) {
//            if (roomList.get(i).getName().equals(name)) {
//                return roomList.get(i);
//            }
//        }
//        return null;
//    }

}
