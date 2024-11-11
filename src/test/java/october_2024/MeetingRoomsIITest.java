package october_2024;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeetingRoomsIITest {

    MeetingRoomsII meetingRoomsII;

    @BeforeEach
    public void setup() {
        meetingRoomsII = new MeetingRoomsII();
    }

    @Test
    public void minMeetingRoomsOverlap() {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 30));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));

        assertEquals(2, meetingRoomsII.minMeetingRooms(intervals));
    }

    @Test
    public void minMeetingRoomsNoOverlap() {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(11, 14));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));

        assertEquals(1, meetingRoomsII.minMeetingRooms(intervals));
    }

    @Test
    public void minMeetingRoomsNoOverlapNoBreak() {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(10, 15));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));

        assertEquals(1, meetingRoomsII.minMeetingRooms(intervals));
    }

}
