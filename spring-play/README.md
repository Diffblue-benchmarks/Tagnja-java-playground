# Spring Play



- IOC
  - spring-ioc-by-xml
  - spring-ioc-by-annotation
  - spring-ioc-by-java
  - spring-ioc-inject-dependency
  - spring-ioc-by-servlet-startup
- AOP
- Spring MVC
- Integration 
  - spring-integrate-orm
  - spring-integrate-test
  - spring-integrate-security



### Spring IOC by xml

Steps with this play

- Creating a new blank maven project
- Add Dependency in pom.xml.  

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

- Creating a file of Spring bean configuration. 

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

- Writing Main Class to Test. 

Main.java

```java
    public static void main(String[] args)
    {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyBean bean = (MyBean) beanFactory.getBean("MyBean");
        bean.sayHello();
    }
```



### Spring IOC by Annotation

Steps with this play

- Creating a new blank maven project.

- Adding dependency in pom.xml

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

- Creating  a file of Spring Bean Configuration.

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

- Writing Main class to test.

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

