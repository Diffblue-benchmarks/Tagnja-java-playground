# Project Function Play



<h3 id="content">Content</h3>

- [i18n-for-db-java-web](#ifdjw)
- file-for-upload-store-access
- logging-management



### Main

<h3 id="ifdjw">i18n For  DB, Java And Web</h3>

**i18n Solution Scheme**

- System
  - Static resource. Such as Picture.
  - Format of Time, Number, Currency.
  - Text Translation
    - GUI Text
      - Language Switch.
      - Cookie for user language.
    - Database Data
- Multiple Server
  - Application Server
  - Database Server
- Area Culture. 
  - Law. culture.

##### 1.i18n for web page field.

In JSP, using JSTL fmt.

```html
<!-- specify page locale and i18n properties file location. -->
<fmt:setLocale value="${locale}" /> <!-- setLocale must in front of setBundle -->
<fmt:setBundle basename="i18n/webPage" />
<!-- using i18n field by key-->
<fmt:message key="user.userManagement" />
```

##### 2.i18n for server end field.

```java
public class MyServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	{
        // Get client locale by httpRquest or httpHeader.

        // get need i18n field by i18nUtils 
	}
}

public class I18nUtils
{
    // Get all i18n properties files path. And creating ResourceBundle Object.
    private static List<ResourceBundle> load(Locale locale) 
    {
        List<ResourceBundle> bundleList = new ArrayList<>();
        Set<String> baseNameSet = new HashSet<>();
        File[] files = dir.listFiles();
        for (File f : files)
        {
            String baseName = PACKAGE_PATH + "." + fileName.substring(0, index);
            baseNameSet.add(baseName);
        }
        for (String baseName : baseNameSet)
        {
            ResourceBundle bundle = ResourceBundle.getBundle(baseName, locale);
            bundleList.add(bundle);
        }
    }
    // get i18n field by ResourceBundle Object.
    public static String getMessage(String code, Locale locale)
    {
        List<ResourceBundle> bundleList = load(locale);
        for (ResourceBundle b : bundleList)
        {
            if (b.containsKey(code))
            {
                String result = b.getObject(code).toString();
                return result;
            }
        } 
    }
}
```

##### 3.i18n for Database.

**Database Design**

t_language

id, name, lang, country, locale.

t_dict_locale

id, dictId, languageId, attrId, attrValue, pinyinValue.

t_dict

id, typeId, typeName, attrId, attrValue, iconUri.

```java
// Get client locale by httpRquest or httpHeader.

// Get language Object by query from database t_language passing client locale String.

// Get i18n filed by query from database t_dict_locale passing dictId and languageId
```



This paly aim is to creating a user information CRUD operation. 

- Web: Java Servlet
- Database: Entity List in Memory.


This play steps. 

- Creating a new Maven project.

- Adding dependencies in pom.xml. `servlet-api`, `jstl`, 

- Creating User entity.

- Creating UserCache to accomplish get, add, remove user.

- Creating I18nUtils.

- Creating i18n properties files. javaResource.properties, webPage.properties, and contains en and zh_CN.

- Creating UserServlet 

- Creating JSP page. index.jsp (display user list) and result.jsp (display result of add and remove user)

- Configuring servlet in web.xml.

  ```xml
  <servlet>
      <servlet-name>UserServlet</servlet-name>
      <servlet-class>com.taogen.i18nfordbjavaweb.servlet.UserServlet</servlet-class>
  </servlet>
  <servlet-mapping>
      <servlet-name>UserServlet</servlet-name>
      <url-pattern>/</url-pattern>
  </servlet-mapping>
  ```

- Visit user index page. http://localhost:8080/getAll



[`back to content`](#content)

---

