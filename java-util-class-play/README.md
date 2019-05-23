# Java Util Class Play

Content

- Java util class basic
  - [StringUtils](#stru)
  - [LogUtils](#logu)
  - [DateUtils](#dateu)
  - [TimeUtils](#timeu)
  - [HttpUtils](#httpu)
  - [JsonUtils](#jsonu)
  - [XmlUtils](#xmlu)
  - [EncryptUtils](#encpu)
  - [Md5Utils](#md5u)
  - [FileUtils](#fileu)
  - [IpUtils](#ipu)
  - [PinyinUtils](#pyu)
  - [PropertyUtils](#propu)



### Main

<h3 id="stru">StringUtils</h3>

Dependencies: 

```
java.lang.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
```

Methods

- Convert
  - int str2Int (String str, int defaults)   // str2Long, str2Float, str2Double, Str2Boolean
- Verify
  - boolean isEmail (String email)   // isMobile, isMatch(String email,  String regex)
- Handle
  - String encodeMobile (String mobile)  // encodeBankCard
  - String emojiConvert (String str) // emojiRecovery
  - String jointString (String... strs)
  - String toNotNull (String str)

[`back to content`](#content)

---

<h3 id="logu">LogUtils</h3>

Dependencies

```
import org.apache.log4j.Logger;
```

Methods

- void debug (String message)
- void info (String message)
- void warn (String message)
- void error (String message)

[`back to content`](#content)

---

<h3 id="dateu">DateUtils</h3>

Dependencies

Methods

- Convert
  - int getDateIntByStr (String dateStr)
  - int getDateIntByDate (Date date)
  - String getDateStrByInt (int dateInt)
  - Date getDateByStr (String dateStr)
  - String getDateFormatStr (Date date, String format)  // getDateStr(Date date)
  - Int  getDateFormatInt (Date date, String format)  // yyyyMMdd, yyyyMM, MMdd
- Calculate
  - int getDayDiff (String startDate, String endDate)
  - List<String\> getBetweenDates (String startDate, String endDate)
  - List<String\> getBetweenMonths (String startDate, String endDate)
  - Date getAddDate (Date date, int addtion)
  - Date getFirstDayOfMonth (Date date) // getFirstDayOfWeek
  - Date getLastDayOfMonth (Date date)  // getLastDayOfWeek
  - getWeekNumofMonth (Date date)  // getWeekNumOfYear

[`back to content`](#content)

---

<h3 id="timeu">TimeUtils</h3>

Dependencies

Methods

- Timestamp getCurrentTime()
- int getHourDiff (long startTime, long endTime)
- String getTimeZone()

[`back to content`](#content)

---

<h3 id="httpu">HttpUtils</h3>

Dependencies

Methods

[`back to content`](#content)

---

<h3 id="jsonu">JsonUtils</h3>

Dependencies

```
import java.lang.reflect.Type;
import com.google.gson.Gson;
```

Methods

- String toJson (Object obj)
- T fromJson (String str, Type type)
- T fromJson (String str, Class<T\> type)

[`back to content`](#content)

---

<h3 id="xmlu">XmlUtils</h3>

Dependencies

Methods

[`back to content`](#content)

---

<h3 id="encpu">EncryptUtils</h3>

Dependencies

```
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
```

Methods

- String encryptBASE64 (String source)
- String decryptBASE64 (String str)

[`back to content`](#content)

---

<h3 id="md5u">Md5Utils</h3>

Dependencies

Methods

[`back to content`](#content)

---

<h3 id="fileu">FileUtils</h3>

Dependencies

Methods

[`back to content`](#content)

---

<h3 id="ipu">IpUtils</h3>

Dependencies

```
import javax.servlet.http.HttpServletRequest;
```

Methods

- String getIpAddr (HttpServletRequest request)
- String getRealIpAddr (HttpServletRequest request)

[`back to content`](#content)

---

<h3 id="pyu">PinyinUtils</h3>

Dependencies

```
import net.sourceforge.pinyin4j.PinyinHelper;
```

Methods

- String getPinyin (String str)
- String getPinyinHeadChar (String str)

[`back to content`](#content)

---

<h3 id="propu">PropertyUtils</h3>

Dependencies

```
import java.io.InputStream;
import java.util.Properties;
```

Methods

- void load(String filePath)
- String getString (String key)
- int getInt (String key, int def)
- long getLong (String key, long def)

[`back to content`](#content)

---

--END--