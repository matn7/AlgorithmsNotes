package october_2024;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PartitionEqualSubsetTest {

    PartitionEqualSubset partitionEqualSubset;

    @BeforeEach
    public void setup() {
        partitionEqualSubset = new PartitionEqualSubset();
    }

    @Test
    public void testCanPartition() {
        int[] nums = {1, 5, 11, 5};
        boolean result = partitionEqualSubset.canPartition(nums);
        assertTrue(result);
    }

    @Test
    public void testCanPartitionV2() {
        int[] nums = {2, 2, 1, 1};
        boolean result = partitionEqualSubset.canPartition(nums);
        assertTrue(result);
    }

    @Test
    public void testCanNotPartition() {
        int[] nums = {1, 2, 3, 5};
        boolean result = partitionEqualSubset.canPartition(nums);
        assertFalse(result);
    }

    @Test
    public void testCanNotPartitionV2() {
        int[] nums = {1, 3, 4, 4};
        boolean result = partitionEqualSubset.canPartition(nums);
        assertFalse(result);
    }

}
