package october_2024;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MeetingRooms2Test {

    MeetingRooms2 meetingRooms;

    @BeforeEach
    public void setup() {
        meetingRooms = new MeetingRooms2();
    }

    @Test
    public void testCanSetup() {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(11, 14));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));

        boolean result = meetingRooms.canAttendMeetings(intervals);
        assertTrue(result);
    }

    @Test
    public void testCanNotSetup() {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 30));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));

        boolean result = meetingRooms.canAttendMeetings(intervals);
        assertFalse(result);
    }

    @Test
    public void testCanJustSetup() {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(10, 15));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));

        boolean result = meetingRooms.canAttendMeetings(intervals);
        assertTrue(result);
    }

}
