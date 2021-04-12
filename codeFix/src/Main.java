import entity.Department;
import entity.Staff;
import service.FileUntil;
import timekeeping.TimeKeeper;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    private final static String Staff_List_File = "Staff.txt";
    private final static String Department_List_File = "Department.txt";
    private final static String TimeKeeper_List_File = "TimeKeeper.txt";

    private static List<Staff> staffList = new ArrayList<>();
    private static List<Department> departmentList = new ArrayList<>();
    private static List<TimeKeeper> timeKeeperList = new ArrayList<>();
    private static List<Double> income = new ArrayList<>();

    public static void main(String[] args) {
        // đọc dữ liệu từ file ra và khởi tạo data cho các list
        menu();
    }

    public static void menu() {
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    inputNewStaff();
                    outputNewStaff();
                    break;
                case 2:
                    inputDepartment();
                    outputDepartment();
                    break;
                case 3:
                    timeKeeping();
                    outputTimeKeeper();
                    break;
                case 4:
                    sortTimeKeeperList();
                    break;
                case 5:
                    staffIncome();
                    break;
                case 6:
                    System.exit(0);
            }
        } while (true);
    }

    public static int functionChoice() {
        System.out.println("-------QUẢN LÝ NHÂN SỰ-----------");
        System.out.println("1.Nhập danh sách nhân viên mới");
        System.out.println("2.Nhập danh sách phòng ban");
        System.out.println("3.Lập bảng danh sách chấm công");
        System.out.println("4.Sắp xếp danh sách");
        System.out.println("5.Thống kê doanh thu");
        System.out.println("6.thoát");
        System.out.print("Nhập lựa chọn của bạn: ");
        int functionChoice = 0;
        boolean check = true;
        do {
            try {
                functionChoice = new Scanner(System.in).nextInt();
                check = true;
            } catch (InputMismatchException e) {
                System.out.println("Không được có ký tự khác ngoài số!");
            }
            if (functionChoice <= 0 || functionChoice > 6) {
                System.out.print("Nhập số từ 1 đến 6! Nhập lại: ");
                check = false;
            } else {
                break;
            }
        } while (!check);
        return functionChoice;
    }

    public static void inputNewStaff() {
        System.out.println("Nhập số lượng nhân viên mới: ");
        int allStaff = 0;
        boolean checkStaff = true;
        do {
            try {
                allStaff = new Scanner(System.in).nextInt();
                checkStaff = true;
            } catch (InputMismatchException e) {
                System.out.println("Không được có ký tự khác ngoài số! Nhập lại: ");
                continue;
            }
            if (allStaff <= 0) {
                System.out.print("Số lượng nhân viên mới phải lớn hơn 0! Nhập lại: ");
                checkStaff = false;
            }
        } while (!checkStaff);

        for (int i = 0; i < allStaff; i++) {
            Staff staff = new Staff();
            staff.inputStaffInfo();
            staffList.add(staff);
        }
        FileUntil.writeDataToFile(staffList, Staff_List_File);
    }

    public static void outputNewStaff() {
        staffList.forEach(staff -> System.out.println(staff));
    }

    public static void inputDepartment() {
        System.out.print("Nhập số lượng phòng ban: ");
        int affDepartment = 0;
        boolean checkDepartment = true;
        do {
            try {
                affDepartment = new Scanner(System.in).nextInt();
                checkDepartment = true;
            } catch (InputMismatchException e) {
                System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                continue;
            }
            if (affDepartment <= 0) {
                System.out.print("Số lượng phòng ban phải lớn hơn 0! Nhập Lại: ");
                checkDepartment = false;
            }
        } while (!checkDepartment);

        for (int i = 0; i < affDepartment; i++) {
            Department department = new Department();
            department.inputDepartmentInfo();
            departmentList.add(department);
        }
        FileUntil.writeDataToFile(departmentList, Department_List_File);
    }

    public static void outputDepartment() {
        departmentList.forEach(department -> System.out.println(department));
    }

    private static boolean isValidStaffAndDepartment() {
        return staffList != null & departmentList != null & !staffList.isEmpty() & !departmentList.isEmpty();
    }

    public static void timeKeeping() {
        if (!isValidStaffAndDepartment()) {
            System.out.println("Bạn cần nhập danh sách nhân viên và phòng ban trước khi chấm công!");
            return;
        }
        for (int i = 0; i < staffList.size(); i++) {
            System.out.println("----Thực hiện chấm công cho nhân viên " + staffList.get(i).getName() + "-----");
            System.out.println("Nhập id phòng ban mà nhân viên " + staffList.get(i).getName() + " làm việc: ");
            int departmentId;
            int workingDay = 0;
            Department tmpdepartment;
            do {
                departmentId = new Scanner(System.in).nextInt();
                tmpdepartment = searchDepartment(departmentId);
                if (tmpdepartment != null) {
                    System.out.println("Nhập số ngày làm việc của nhân viên " + staffList.get(i).getName() + " :");
                    boolean checkDay = true;
                    do {
                        try {
                            workingDay = new Scanner(System.in).nextInt();
                            checkDay = true;
                        } catch (Exception e) {
                            System.out.print("Nhập lỗi! Nhập lại: ");
                            continue;
                        }
                        if (workingDay <= 0 || workingDay > 22) {
                            System.out.print("Số ngày làm việc trong khoảng từ 0 đến 22! Nhập lại: ");
                            checkDay = false;
                        }
                    } while (!checkDay);
                    break;
                } else {
                    System.out.print("Không có id phòng vừa nhập! Nhập lại: ");
                }
            } while (true);
            TimeKeeper timeKeeper = new TimeKeeper(staffList.get(i), tmpdepartment, workingDay);
            timeKeeperList.add(timeKeeper);
        }
        FileUntil.writeDataToFile(timeKeeperList, TimeKeeper_List_File);
    }

    public static void outputTimeKeeper() {
        timeKeeperList.forEach(new Consumer<TimeKeeper>() {
            @Override
            public void accept(TimeKeeper timeKeeper) {
                System.out.println(timeKeeper.toString());
            }
        });
    }

    private static Department searchDepartment(int id) {
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getId() == id) {
                return departmentList.get(i);
            }
        }
        return null;
    }

    public static void sortTimeKeeperList() {
        if (timeKeeperList == null || timeKeeperList.size() == 0) {
            System.out.println("Nhập bảng chấm công trước khi sắp xếp!");
            return;
        }
        do {
            System.out.println("---------- SẮP XẾP DANH SÁCH CHẤM CÔNG ---------");
            System.out.println("1. Sắp xếp theo tên nhân viên");
            System.out.println("2. Sắp xếp theo tên phòng ban.");
            System.out.println("3. Thoát chức năng sắp xếp.");
            System.out.print("Xin mời chọn chức năng: ");
            int sortChoice = 0;
            boolean check = true;
            do {
                try {
                    sortChoice = new Scanner(System.in).nextInt();
                    check = true;
                } catch (InputMismatchException e) {
                    System.out.println("Không được có ký tự khác ngoài số!");
                }
                if (sortChoice <= 0 || sortChoice > 6) {
                    System.out.print("Nhập số từ 1 đến 3! Nhập lại: ");
                    check = false;
                } else {
                    break;
                }
            } while (!check);
            switch (sortChoice) {
                case 1:
                    sortTimeKeeperListByStaffName();
                    break;
                case 2:
                    sortTimeKeeperListByDepartmentName();
                    break;
                case 3:
                    return;
            }
        } while (true);
    }

    public static void sortTimeKeeperListByStaffName() {
        for (int i = 0; i < timeKeeperList.size(); i++) {
            for (int j = i + 1; j < timeKeeperList.size(); j++) {
                if (timeKeeperList.get(i).getStaff().getName().compareTo(timeKeeperList.get(j).getStaff().getName()) > 0) {
                    TimeKeeper tmp = timeKeeperList.get(i);
                    timeKeeperList.set(i, timeKeeperList.get(j));
                    timeKeeperList.set(j, tmp);
                }
            }
        }
        timeKeeperList.forEach(timeKeeper -> System.out.println(timeKeeper.toString()));
    }

    public static void sortTimeKeeperListByDepartmentName() {
        for (int i = 0; i < timeKeeperList.size(); i++) {
            for (int j = i + 1; j < timeKeeperList.size(); j++) {
                if (timeKeeperList.get(i).getDepartment().getName().compareTo(timeKeeperList.get(j).getDepartment().getName()) > 0) {
                    TimeKeeper temp = timeKeeperList.get(i);
                    timeKeeperList.set(i, timeKeeperList.get(j));
                    timeKeeperList.set(j, temp);
                }
            }
        }
        timeKeeperList.forEach(timeKeeper -> System.out.println(timeKeeper.toString()));
    }

    public static void staffIncome() {
        if (timeKeeperList == null || timeKeeperList.size() == 0) {
            System.out.println("Nhập bảng chấm công trước khi thống kê!");
            return;
        }
        for (int i = 0; i < timeKeeperList.size(); i++) {
            System.out.println("Thống kê thu nhập cho nhân viên " + staffList.get(i).getName() + " :");
            double staffIncome;
            staffIncome = 850000 * (2 + (double) staffList.get(i).getSalary() / 3) * departmentList.get(i).getWorkNumber() * ((double) timeKeeperList.get(i).getTimeWork() / 22);
            income.add(staffIncome);
            System.out.println(income.get(i));
        }
    }
}
