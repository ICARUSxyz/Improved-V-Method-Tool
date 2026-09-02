package code;

import java.util.*;

class Meeting {
    private String organizer;
    private int startTime; 
    private int duration; 

    public Meeting(String organizer, int startTime, int duration) {
        this.organizer = organizer;
        this.startTime = startTime;
        this.duration = duration;
    }

    public String getOrganizer() {
        return organizer;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return startTime + duration;
    }
}

class MeetingScheduler {
    private List<Meeting> meetings;
    private final int maxDuration;
    private List<String> meetingLog;

    public MeetingScheduler(int maxDuration) {
        this.meetings = new ArrayList<>();
        this.maxDuration = maxDuration;
        this.meetingLog = new ArrayList<>();
    }

    public boolean scheduleMeeting(String organizer, int startTime, int duration) {
        if (duration <= 0 || duration > maxDuration) {
            System.out.println("Invalid meeting duration! Must be between 1 and " + maxDuration + " hours.");
            return false;
        }

        int endTime = startTime + duration;
        for (Meeting m : meetings) {
            if (!(endTime <= m.getStartTime() || startTime >= m.getEndTime())) {
                System.out.printf("Meeting conflict detected! %s's meeting overlaps with another meeting.%n", organizer);
                return false;
            }
        }

        Meeting newMeeting = new Meeting(organizer, startTime, duration);
        meetings.add(newMeeting);
        meetingLog.add(String.format("Scheduled: %s from %d:00 to %d:00", organizer, startTime, endTime));
        System.out.printf("Meeting scheduled successfully: %s from %d:00 to %d:00%n", organizer, startTime, endTime);
        return true;
    }

    public boolean cancelMeeting(String organizer, int startTime) {
        Iterator<Meeting> iterator = meetings.iterator();
        while (iterator.hasNext()) {
            Meeting m = iterator.next();
            if (m.getOrganizer().equals(organizer) && m.getStartTime() == startTime) {
                iterator.remove();
                meetingLog.add(String.format("Cancelled: %s's meeting at %d:00", organizer, startTime));
                System.out.printf("Meeting cancelled: %s at %d:00%n", organizer, startTime);
                return true;
            }
        }
        System.out.println("No matching meeting found for cancellation.");
        return false;
    }

    public void printMeetingLog() {
        System.out.println("\nMeeting Log:");
        for (String log : meetingLog) {
            System.out.println(log);
        }
    }
}

public class c15_OnlineMeetingSystem {
    public static void main(String[] args) {
        MeetingScheduler scheduler = new MeetingScheduler(4); 

        // testcase-VT:
//        scheduler.scheduleMeeting("Alice", 9, 2); 
//        scheduler.scheduleMeeting("Bob", 11, 2);   
//        scheduler.scheduleMeeting("Charlie", 10, 2); 
//        scheduler.scheduleMeeting("David", 14, 5);
//        scheduler.scheduleMeeting("Eve", 13, 2);  
//        scheduler.cancelMeeting("Bob", 11);    
//        scheduler.cancelMeeting("Eve", 11); 
//        scheduler.scheduleMeeting("Frank", 11, 1); 
//        scheduler.cancelMeeting("Hork", 11);
//        scheduler.scheduleMeeting("Hork", 11, 0);
//        scheduler.printMeetingLog(); 
        
        // testcase-FT:
//        scheduler.scheduleMeeting("maco5", 24, 1633774996); 
//        scheduler.scheduleMeeting("?o5", 0, 0);   
//        scheduler.scheduleMeeting("", 0, 0); 
//        scheduler.scheduleMeeting("/////", 22, 791621423);
//        scheduler.scheduleMeeting("??", 0, 1766592256);  
//        scheduler.cancelMeeting("/////", 22);    
//        scheduler.scheduleMeeting("B*", 1, 100664576); 
//        scheduler.scheduleMeeting("", 10, 1697473647);
//        scheduler.scheduleMeeting("B*", 1, 100664576); 
//        scheduler.scheduleMeeting("", 17, 67109206);
//        scheduler.printMeetingLog(); 
        
        // testcase-Z3:
//        scheduler.scheduleMeeting("Alice", 9, -1); 
//        scheduler.scheduleMeeting("Bob", 11, 11);   
//        scheduler.scheduleMeeting("Charlie", 10, 10); 
//        scheduler.scheduleMeeting("David", 14, 14);
//        scheduler.scheduleMeeting("David", 14, 14);
//        scheduler.scheduleMeeting("Eve", 13, 13);  
//        scheduler.scheduleMeeting("Frank", 11, 1); 
//        scheduler.scheduleMeeting("Frank", 11, 1);
//        scheduler.scheduleMeeting("Hork", 11, 0);
//        scheduler.printMeetingLog(); 
        
        // testcase-UVT:
        scheduler.scheduleMeeting("Alice", 9, 2); 
        scheduler.scheduleMeeting("Bob", 11, 2);   
        scheduler.scheduleMeeting("Charlie", 10, 2); 
        scheduler.scheduleMeeting("David", 14, 5);
        scheduler.scheduleMeeting("Eve", 13, 2);  
        scheduler.scheduleMeeting("Charlie", 10, 2); 
        scheduler.scheduleMeeting("Eve", 13, 2);  
        scheduler.scheduleMeeting("Frank", 11, 1); 
        scheduler.cancelMeeting("Hork", 11);
        scheduler.scheduleMeeting("Hork", 11, 0);
        scheduler.printMeetingLog(); 
    }
}
