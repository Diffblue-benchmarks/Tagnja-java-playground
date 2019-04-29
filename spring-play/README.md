# Spring Play



<h3 id="content">Content</h3>

- About Dependency
- Spring Core
  - IOC
    - [spring-ioc-by-xml](#sibx)
    - [spring-ioc-by-annotation](#siba)
    - [spring-ioc-by-java](#sibj)
    - [spring-ioc-inject-dependency](#siid)
    - [spring-ioc-with-servlet-startup](#siwss)
  - AOP
- Web Application
  - Spring MVC
  - REST APIs
- Working with Data 
  - JdbcTemplate
  - Spring Data JPA
  - Transaction
  - spring-integrate-orm
- Reactive Programming
  - Spring WebFlux
- Spring Boot
- Spring Security
  - spring-security
- Spring Integration Spring Batch
- Spring Deploy with Docker
- Spring Test
- Spring Cloud



---

### Main

### About Dependency

Description of modules

- `spring-beans`, `spring-core`, `spring-context` is the most important dependencies in spring. It accomplish the IOC function.

Usage

- the `spring-context` dependency contains `spring-beans` , `spring-core `. Just add the one dependency in your `pom.xml` when you using IOC.

- the `spring-web` dependency when you are developing a web application.

<h3 id="sibx">Spring IOC by xml</h3>

Steps with this play

- Creating a new blank maven project
- Add spring-context Dependency in pom.xml.  

    pom.xml

    ```xml
    <properties>
        <spring.version>5.1.5.RELEASE</spring.version>
    </properties>
    <dependencies>
        <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-context</artifactId>
          <version>${spring.version}</version>
        </dependency>
    </dependencies>
    ```

- Add a Java Class file of my bean.

    MyBean.java

    ```java
    public class MyBean
    {
        private String name;
        public MyBean() {}
        public MyBean(String name)
        {
            this.name = name;
        }
        public void sayHello()
        {
            System.out.println("hello by " + name);
        }
    }
    ```

- Creating a file of Spring bean configuration. To configuring bean.

    applicationContext.xml

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://www.springframework.org/schema/beans 
                               http://www.springframework.org/schema/beans/spring-beans.xsd">
        <bean id="MyBean" class="com.taogen.springiocbyxml.MyBean">
            <constructor-arg value="HelloBean"></constructor-arg>
        </bean>
    </beans>
    <!-- 
    // notice content
    xsi:schemaLocation="http://www.springframework.org/schema/beans 
    <bean id="MyBean" class="com.taogen.springiocbyxml.MyBean">
    -->
    ```

- Writing Main Class to Test. Getting bean by ClassPathXmlApplicationContext Object.

    Main.java

    ```java
        public static void main(String[] args)
        {
            BeanFactory beanFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
            MyBean bean = (MyBean) beanFactory.getBean("MyBean");
            bean.sayHello();
        }
    ```

[`back to content`](#content)

---


<h3 id="siba">Spring IOC by Annotation</h3>

Steps with this play

- Creating a new blank maven project.

- Adding spring-context dependency in pom.xml

    pom.xml

    ```xml
    <properties>
        <spring.version>5.1.5.RELEASE</spring.version>
    </properties>
    <dependencies>
        <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-context</artifactId>
          <version>${spring.version}</version>
        </dependency>
    </dependencies>
    ```

- Creating a Java Class file of my bean with annotation @Repository.

    MyBean.java

    ```java
    @Repository
    public class MyBean
    {
        private String name;
        public MyBean() {}
        public MyBean(String name)
        {
            this.name = name;
        }
        public void sayHello()
        {
            System.out.println("hello by " + name);
        }
    }
    ```

- Creating  a file of Spring Bean Configuration. To configuring context:componet-scan

    applicationContext.xml

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:context="http://www.springframework.org/schema/context"
           xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/context
           http://www.springframework.org/schema/beans/spring-context.xsd">

        <context:component-scan base-package="com.taogen.springiocbyannotation">
        </context:component-scan>
    </beans>
    <!--
    // notice content
    http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/context
    <context:component-scan base-package="com.taogen.springiocbyannotation">
    -->
    ```

- Writing Main class to test. Getting bean by AnnotationConfigApplicationContext Object.

    Main.java

    ```java
        public static void main(String[] args)
        {
            AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
            ctx.register(MyBean.class);
            ctx.refresh();
            MyBean myBean = (MyBean) ctx.getBean("MyBean");
            myBean.sayHello();
        }
    ```

[`back to content`](#content)

---


<h3 id="sibj">Spring IOC by Java</h3>

Steps with this play

- Creating a new blank maven project.
- Adding spring-context dependency in pom.xml
- Creating a Java Class file of my bean.
- Create a Java-based configuration file. 

    AppConfig.java

    ```java
    /**
     * The AppConfig class above would be equivalent to the following Spring <beans/> XML:
     * <beans>
     *   <bean id="myBean" class="com.taogen.springiocbyjava.MyBean"/>
     * </beans>
     */
    @Configuration
    public class AppConfig
    {
        @Bean
        public MyBean myBean()
        {
            return new MyBean();
        }
    }
    ```

- Creating  a file of Spring Bean Configuration. To configuring context:componet-scan

	applicationContext.xml

    ```xml
    <context:component-scan base-package="com.taogen.springiocbyjava"></context:component-scan>
    ```

- Writing Main class to test. Get bean by AnnotationConfigApplicationContext Object.

	```java
    public static void main(String[] args)
    {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        MyBean myBean = ctx.getBean(MyBean.class);
        myBean.sayHello();
    }
	```

[`back to content`](#content)

---


<h3 id="siid">Spring IOC Inject Dependency</h3>



[`back to content`](#content)

---


<h3 id="siwss">Spring IOC with Servlet Startup</h3>

Steps of this play

- Creating a new webapp maven project.

    Idea -- menu bar -- File -- New -- Project -- Select Maven in left of new window -- Create from archietype -- Select org.apache.maven.archetypes:maven-archetype-webapp -- Next -- fill your GroupId, Artifactid -- Next -- Maven home directory don't care, just click Next -- Fill your project name -- Finish.

- Adding dependencies. Such as `javax.servlet-api `, `spring-context`, `spring-web`.

  ```xml
    <properties>
        <spring.version>5.1.5.RELEASE</spring.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.0.1</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>${spring.version}</version>
        </dependency>
    </dependencies>
  ```

- Writing a servlet class file.
  MyServlet.java

  ```java
  public class MyServlet extends HttpServlet
  {
      @Override
      public void doGet(HttpServletRequest request, HttpServletResponse response)
      {
          try {
              PrintWriter pw = response.getWriter();
              pw.write("Hello by MyServlet");
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  }
  ```
  
- Configuring servlet map in web.xml

  web.xml

  ```xml
    <servlet>
      <servlet-name>MyServlet</servlet-name>
      <servlet-class></servlet-class>
    </servlet>
    <servlet-mapping>
      <servlet-name>MyServlet</servlet-name>
      <url-pattern>/MyServlet</url-pattern>
    </servlet-mapping>
  ```

- Deploying and Running Servlet with tomcat

  (1) Running maven package

  Idea --> menu bar --> Run --> Edit Configurations --> click + --> Maven --> fill your Name: package, command line: package --> apply --> OK.

  menu bar --> run package(your just configured)

  (2) Configuring tomcat

  Idea --> menu bar --> Run --> Edit Configurations --> click + --> Select Tomcat Server --> Local --> Fill your server Name -- > Configure --> find tomcat path or select choice exist added server --> switch to "Deployment" tab --> click + --> Select Artiface --> select one of Your artifact --> OK --> Apply --> OK

  (3) Run tomcat

  menu bar --> run tomcat (your just configured)

  (4) Visiting your servlet

  Your http://localhost:8080 + Application Context + Servlet Name

  example http://localhost:8080/MyServlet

- Creating your bean.

    MyBean.java

    ```java
    public class MyBean
    {
        private String name;
        public MyBean() {}
        public MyBean(String name)
        {
            this.name = name;
        }
        public void sayHello()
        {
            System.out.println("hello by " + name);
        }
    }
    ```

- Creating a bean configuration file. 

  applicationConext.xml
  
  ```xml
  <bean id="MyBean" class="com.taogen.springiocwithservlet.bean.MyBean">
      <constructor-arg value="My Bean 1"></constructor-arg>
  </bean>
  ```
  
- Creating Main.java to test Spring IOC 

    Main.java

    ```java
    public static void main (String[] args)
    {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyBean myBean = (MyBean) beanFactory.getBean("MyBean");
        myBean.sayHello();
    }
    ```

- add contextLoaderListener in `web.xml`.  **When servlet application running, the spring ioc will instantiated？**

    ```xml
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:applicationContext.xml</param-value>
    </context-param>
    
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    ```

- Using Spring bean in Servlet

TODO...





[`back to content`](#content)

---



--END--