package managerWork;

import companyRoom.Room;

public class ManagerPair {
    private Room room;
    private int day;

    public ManagerPair() {
    }

    public ManagerPair(Room room, int day) {
        this.room = room;
        this.day = day;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "ManagerD{" +
                "room=" + room +
                ", day=" + day +
                '}';
    }
}
