package october_2024;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MeetingRoomsTest {

    MeetingRooms meetingRooms;

    @BeforeEach
    public void setup() {
        meetingRooms = new MeetingRooms();
    }

    @Test
    public void testCanSetup() {
        List<List<Integer>> intervals = new ArrayList<>();
        intervals.add(Arrays.asList(12, 14));
        intervals.add(Arrays.asList(5, 10));
        intervals.add(Arrays.asList(15, 20));

        boolean result = meetingRooms.meetingRooms(intervals);
        assertTrue(result);
        assertTrue(meetingRooms.meetingRooms2(intervals));
    }

    @Test
    public void testCanNotSetup() {
        List<List<Integer>> intervals = new ArrayList<>();
        intervals.add(Arrays.asList(0, 30));
        intervals.add(Arrays.asList(5, 10));
        intervals.add(Arrays.asList(15, 20));

        boolean result = meetingRooms.meetingRooms(intervals);
        assertFalse(result);
        assertFalse(meetingRooms.meetingRooms2(intervals));
    }

    @Test
    public void testCanJustSetup() {
        List<List<Integer>> intervals = new ArrayList<>();
        intervals.add(Arrays.asList(10, 15));
        intervals.add(Arrays.asList(5, 10));
        intervals.add(Arrays.asList(15, 20));

        boolean result = meetingRooms.meetingRooms(intervals);
        assertTrue(result);
        assertTrue(meetingRooms.meetingRooms2(intervals));
    }

}
