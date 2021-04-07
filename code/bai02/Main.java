package bai02;

import bai01.BanDoc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    private static FileIOimpl fileIOimpl;
    private static List<Staff> staffList = new ArrayList<>();
    private static List<Room> roomList = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    InputInformationStaff();
                    break;
                case 2:
                    InputInformationRoom();
                    break;
                case 3:

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

    private static boolean isValidStaffAndRoom() {
        return staffList != null && roomList != null && staffList.size() > 0 && roomList.size() > 0;
    }

    public static void InputInformationStaff() {
        System.out.println("Nhập số lượng nhân viên mới: ");
        int allStaff = 0;
        boolean checked = true;
        do {
            try {
                allStaff = new Scanner(System.in).nextInt();
                checked = true;
            } catch (Exception e) {
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
            fileIOimpl.ghiFile(staffList,"DSNV.txt");
        }
        for (Staff staff : staffList){
            fileIOimpl.docFile("DSNV.txt");
        }
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
            fileIOimpl.ghiFile(roomList,"DSP.txt");
        }
    }
}
