import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void maxNonDecreasingLengthTest1() {
        int[] nums1 = {2, 3, 1};
        int[] nums2 = {1, 2, 1};
        int expected = 2;
        int actual = new Solution().maxNonDecreasingLength(nums1, nums2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void maxNonDecreasingLengthTest2() {
        int[] nums1 = {1, 3, 2, 1};
        int[] nums2 = {2, 2, 3, 4};
        int expected = 4;
        int actual = new Solution().maxNonDecreasingLength(nums1, nums2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void maxNonDecreasingLengthTest3() {
        int[] nums1 = {1, 1};
        int[] nums2 = {2, 2};
        int expected = 2;
        int actual = new Solution().maxNonDecreasingLength(nums1, nums2);

        Assert.assertEquals(expected, actual);
    }
}
