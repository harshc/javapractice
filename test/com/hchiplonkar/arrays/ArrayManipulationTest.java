package com.hchiplonkar.arrays;


import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayManipulationTest {
    @Test
    public void testisUniqueCharacters() {
        String uniqueCharString = "acbdefghi";
        String nonUniqueCharString = "abcddefgh";

        Assert.assertTrue(ArrayManipulation.IsUniqueCharacters(uniqueCharString));
        Assert.assertFalse(ArrayManipulation.IsUniqueCharacters(nonUniqueCharString));
    }

    @Test
    public void testCompressString() {
        String validString = "abbcccdddd";
        String invalidString = "abc";

        Assert.assertEquals(ArrayManipulation.CompressString(validString), "a1b2c3d4");
        Assert.assertEquals(ArrayManipulation.CompressString(invalidString), "abc");
    }

    @Test
    public void testIsPermutation() {
        Assert.assertTrue(ArrayManipulation.IsPermutation("abcd", "dcba"));
        Assert.assertTrue(ArrayManipulation.IsPermutation("aa", "aa"));
        Assert.assertFalse(ArrayManipulation.IsPermutation("aa", "dcba"));
    }
}
