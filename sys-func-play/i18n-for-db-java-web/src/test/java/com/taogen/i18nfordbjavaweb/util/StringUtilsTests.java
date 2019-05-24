package com.taogen.i18nfordbjavaweb.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTests {

    @Test
    public void testIsEmptyString() {
        Assert.assertTrue(StringUtils.isEmpty(""));
        Assert.assertTrue(StringUtils.isEmpty((String) null));

        Assert.assertFalse(StringUtils.isEmpty("foo"));
    }

    @Test
    public void testIsEmptyArray() {
        Assert.assertTrue(StringUtils.isEmpty(new String[]{}));
        Assert.assertTrue(StringUtils.isEmpty((String[]) null));

        Assert.assertFalse(StringUtils.isEmpty(new String[]{""}));
        Assert.assertFalse(StringUtils.isEmpty(new String[]{"foo", "bar"}));
    }

    @Test
    public void testNullToEmpty() {
        Assert.assertEquals("", StringUtils.nullToEmpty(""));
        Assert.assertEquals("", StringUtils.nullToEmpty(null));
        Assert.assertEquals("foo", StringUtils.nullToEmpty("foo"));
    }

    @Test
    public void testStr2Int() {
        Assert.assertEquals(1, StringUtils.str2Int(null, 1));
        Assert.assertEquals(2, StringUtils.str2Int("foo", 2));
        Assert.assertEquals(123, StringUtils.str2Int("123", 4));
    }

    @Test
    public void testStr2Float() {
        Assert.assertEquals(1, StringUtils.str2Float(null, 1), 0);
        Assert.assertEquals(2, StringUtils.str2Float("foo", 2), 0);
        Assert.assertEquals(123, StringUtils.str2Float("123", 4), 0);
    }

    @Test
    public void testStr2Boolean() {
        Assert.assertTrue(StringUtils.str2Boolean(null, true));
        Assert.assertFalse(StringUtils.str2Boolean("foo", true));
        Assert.assertFalse(StringUtils.str2Boolean("false", true));
    }

    @Test
    public void testStr2Double() {
        Assert.assertEquals(1.2, StringUtils.str2Double(null, 1.2), 0);
        Assert.assertEquals(2.3, StringUtils.str2Double("foo", 2.3), 0);
        Assert.assertEquals(12.3, StringUtils.str2Double("12.3", 4.4), 0);
    }

    @Test
    public void testStr2Long() {
        Assert.assertEquals(1L, StringUtils.str2Long(null, 1L));
        Assert.assertEquals(2L, StringUtils.str2Long("foo", 2L));
        Assert.assertEquals(21111, StringUtils.str2Long("21111", 4L));
    }

    @Test
    public void testIsEmail() {
        Assert.assertFalse(StringUtils.isEmail("foobar"));
        Assert.assertFalse(StringUtils.isEmail("foobar.com"));

        Assert.assertTrue(StringUtils.isEmail("foo12@bar.com"));
    }

    @Test
    public void testIsMobile() {
        Assert.assertFalse(StringUtils.isMobile("foobar"));

        Assert.assertTrue(StringUtils.isMobile("13331999999"));
    }

    @Test
    public void testEncodeMobile() {
        Assert.assertEquals("foo", StringUtils.encodeMobile("foo"));
        Assert.assertEquals("133****9999",
                StringUtils.encodeMobile("13331999999"));
    }

    @Test
    public void testEncodeBankCard() {
        Assert.assertEquals("133  **** ****  189",
                StringUtils.encodeBankCard("133 1349 153 180 189"));
        Assert.assertEquals("foob **** **** obar",
                StringUtils.encodeBankCard("foobarbazfoobar"));
    }

    @Test
    public void testControlTextLength() {
        Assert.assertEquals("foo", StringUtils.controlTextLength("foo"));
        Assert.assertEquals("foobarbazfooba......",
                StringUtils.controlTextLength("foobarbazfoobarfoobar"));
        Assert.assertEquals("12345678901234......",
                StringUtils.controlTextLength("1234567890123456789"));
    }

    @Test
    public void testIsPhone() {
        Assert.assertFalse(StringUtils.isPhone("foobar"));

        Assert.assertTrue(StringUtils.isPhone("4444-7777777"));
    }

    @Test
    public void testEmojiConvert() {
        Assert.assertNull(StringUtils.emojiConvert(null));
        Assert.assertEquals(":)", StringUtils.emojiConvert(":)"));
    }

    @Test
    public void testEmojiRecovery() {
        Assert.assertNull(StringUtils.emojiRecovery(null));
        Assert.assertEquals(":)", StringUtils.emojiRecovery(":)"));
    }

    @Test
    public void testToNotNull() {
        Assert.assertEquals("", StringUtils.toNotNull(null));
        Assert.assertEquals("", StringUtils.toNotNull(""));
        Assert.assertEquals("foo", StringUtils.toNotNull("foo"));
    }

    @Test
    public void testBuilderString() {
        Assert.assertEquals("", StringUtils.builderString(null));
        Assert.assertEquals("", StringUtils.builderString(""));
        Assert.assertEquals("foo", StringUtils.builderString("foo"));
        Assert.assertEquals("foobarbaz",
                StringUtils.builderString("foo", "bar", "baz"));
    }
}
