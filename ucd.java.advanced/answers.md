
- [JAVA EX](#java-ex)
  - [## Question1](#question1)
  - [## Question2](#question2)
  - [## Question3](#question3)

# JAVA EX 

## Question1 
---
```java
public class exam_paper1 {
  public static void main(String[] args) {
     //Question 1 
    int x = 15;
    int y = 1;
    
    int[] z = new int[5];
    z[1] = 0; 
    z[2] = 0;
    
    try {
      System.out.println("x/y: " + x / y); // 15 
      System.out.println("x*y: " + x * y); // 15
      System.out.println(z[1]); // 0 
      System.out.println(z[10]); // out of bounds  
      System.out.println("x-y: " + (x - y)); 
    } catch (ArithmeticException ae) {
      System.out.println("An exception occurred: " + ae);
    } catch (ArrayIndexOutOfBoundsException oe) {
      System.out.println("An exception occurred: " + oe);
    } finally {
      System.out.println("finally block must be executed!");
    }
  }
}
```

``` md
A. x/y: 15 *
B. x*y: 15 *
C. finally block must be executed!
D. x-y: 14
E: An exception occurred: java.lang.ArithmeticException: / by zero 
*/
```

## Question2
---

```java
public class exam_paper1 {
  public static void main(String[] args) {
    2. True or False: a finally block will be executed if there is no exception thrown in the
    corresponding try (assume no System.exit() statement is met).
    A. True
    B. False 
  }
}
```

```md
true
```

## Question3
---

```java
public class exam_paper1 {
  public static void main(String[] args) {
    int i=1, j=1;
    try {
    i++; // 2
    j--;  // 0 
    if(i == j)  
    i++; // does not run 
    }
    catch(ArithmeticException e) {
    System.out.println(0);
    }
    catch(ArrayIndexOutOfBoundsException e) {
    System.out.println(1);
    }
    catch(Exception e) {
    System.out.println(2);
    }
    finally {
    System.out.println(3);
    }
    System.out.println(4);  
  }
}

```md
//Which of the following is part of the output? (Choose all that apply) 
/* 
A. 0
B. 1
C. 2
D. 4
E. none of the above 
*/
```

## Question4
---
```md
4. Which of these is a legal definition of a method named m which may throw an IOException and returns void, and which does not take any arguments? (Select the correct answer)

A. void m() throws IOException{}
B. void m() throw IOException{} // this one - 
C. void m(void) throws IOException{}
D. void m() {} throws IOException
```md
on individual = throw 
on comments = throws

## Question5
---
```java
public class Logger {
  private static int loggerCount = 0;
  private final int logLevel;
  public static void main(String args[]) {
    createInstance(-1);
  }
  
  private Logger(int logLevel) throws IllegalArgumentException {
    if (logLevel < 0 || logLevel > 10) {
      throw new IllegalArgumentException("logLevel only takes values 0-10");
    }
    this.logLevel = logLevel;
  }
  
  public static Logger createInstance(int logLevel) {
    Logger retObj = null;
    try {
      retObj = new Logger(logLevel);
    } catch (IllegalArgumentException e) {
      System.out.println(e);
    } finally {
      loggerCount++;
    }
    return retObj;
  }
}
```

```md
/*
* A. java.lang.IllegalArgumentException: logLevel only takes values 0-10 
B. 0
* C. 1 
D. Code will not compile
*/

```
## Question5