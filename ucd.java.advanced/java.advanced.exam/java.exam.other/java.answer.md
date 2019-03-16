EXCEPTIONS AND ASSERTIONS REVIEW QUESTIONS SOLUTIONS:

1. Answer: D
Line 5 will generate an ArrayIndexOutofBoundsException, which is an unchecked exception. So, it will be thrown only at runtime when i=7.
2. Answer: B
B has the correct syntax, and you can use the keywords throw and new in the same statement. Note that the keyword to be used here is throw and not throws.
3. Answer: A, B, C, and D
The finally block is always executed except under special circumstances.
4. Answer: D
The following rule is violated: the more specific catch block should precede the less specific catch block.
5. Answer: B and D
The support for assertions is enabled by default when compiling code in J2SE 5.0. The assert statement asserts that the number of command arguments is not equal to 0. Therefore, an AssertionError will be thrown if the number of arguments is 0.
6. Answer: B and E
A, C, and D are false statements about assertions.
7. Answer: A
The finally block can exist with the catch block, and the finally block is always executed instead under extreme circumstances such as a return or an exit statement.
8. Answer: B
The try block must be followed by either a catch block or a finally block.
9. Answer: A
The code is just fine. The execution will stop at the System.exit(1) statement.
 
10. B, E, F. The exception causes a jump out of the try block, so the message Success from line 6 is not printed. The first applicable catch is at line 8, which is an exact match for the thrown exception. This results in the message at line 9 being printed, so B is one of the required answers. Only
one catch block is ever executed, so control passes to the finally block, which results in the message at line 18 being output; so E is part of the correct answer. Execution continues after
the finally block. This results in the output of the message at line 20, so F is also part of the correct answer.
11. A, E, F. With no exceptions, the try block executes to completion, so the message Success from line 6 is printed and A is part of the correct answer. No catch is executed, so B, C, and D are incorrect. Control then passes to the finally block, which results in the message at line 18 being output, so E is part of the correct answer. Because no exception was thrown, execution continues after the finally block, resulting in the output of the message at line 20; so F is also part of the correct answer.
12. E. The thrown error prevents completion of the try block, so the message Success from line 6 is not printed. No catch is appropriate, so B, C, and D are incorrect. Control then passes to the finally block, which results in the message at line 18 being output; so option E is part of the correct answer. Because the error was not caught, execution exits the method and the error is rethrown in the caller of this method; so F is not part of the correct answer.
13. B, C, D. Assertions should not be used to check preconditions of a public method.
14. B, D. The 1.4 compiler only treated assert as a keyword (and not an ordinary identifier) if the -source 1.4 flag appeared in the command line. However, 5.0 does not require a -source flag. So A is not a requirement. If the application is not run with assertions explicitly enabled, all assert statements will be ignored. If the args array does not have exactly zero arguments, no AssertionError will be thrown.
15. B. Assertions should not be used to check preconditions in a public method. Some kind of runtime exception should be thrown, and IllegalArgumentException is the most appropriate class name for this situation. There is no such thing as java.lang.InvalidArgumentException.
16. D. Unless execution terminates abnormally, the finally block will always eventually execute. 
17. B. Exception chaining is appropriate when an exception is being thrown in response to catching
a different exception type.
18. B. Runtime exceptions don‟t have to be caught. Errors should never be caught.
19. A. The stack trace is recorded when the exception is constructed.
20. E. It is never appropriate for application programmers to construct and throw errors.


----------------------


1. Answer: B, C, and D
There is no method available to change the current working directory. You can create and delete a file by using the createNewFile() and delete() methods, respectively. You can also change the security on a file to read-only by invoking the method setReadOnly().
2. Answer: B
Creating an instance of the File class does not create a file on the system. However, you can invoke an appropriate method of the File instance to create the file if you want to.
3. Answer: A
You need DataInputStream chained to FileInputStream in order to read primitive data types from a file; just one of these streams will not do the job. FileInputStream reads bytes and passes them to DataInputStream, which converts them into data types. The FileReader class is used to read 16- bit characters, and not primitive data types.
4. Answer: A, C, and D
FileInputStream and FileOutputStream are limited to reading only 8-bit bytes; they cannot read 16-bit characters.
5. Answer: A
You need ObjectOutputStream chained to FileOutputStream in order to write an object from your program into a file; just one of these streams will not do the job.
6. Answer: A
The ObjectOutputStream can be used to write strings to a file.
7. Answer: B
The byte is 1 byte long and the float is 4 bytes long.
8. Answer: B
The high-level classes such as BufferedReader cannot be directly connected to I/O devices such as files.
 9. Answer: E
When an object is serialized, the class name, non-static data, and non-transient data are saved. FileInputStream and FileReader are low-level streams and can be directly connected to a file. FileInputStream reads the data in binary format, but it can read the text files.
10. Answer: B
Only the Serializable objects are serialized. Although the class Car extends Vehicle, Vehicle is not Serializable. So, when the object of Car is retrieved, the constructor of Vehicle is executed and the make variable is reset to Lexus although it was stored as Nissan.
11. Answer: D.
UTF characters are as big as they need to be. Unicode characters are all 16 bits. There is no
such thing as a bytecode character; bytecode is the format generated by the Java compiler.
12. Answer: D.
A, B, and C are all false. The File constructor doesn‟t check the file-naming semantics. Construction and garbage collection of a File have no effect on the local file system.
13. Answer: D.
The File class does not provide a way to change the current working directory.
14. Answer: A.
The list() method returns an array of strings.
15. Answer: C.
The writeInt() call writes out an int, which is 4 bytes long; the writeDouble() call writes
out a double, which is 8 bytes long. The total is 12 bytes. 
16. Answer: B.
All the code is perfectly legal, so no exceptions are thrown. The first byte 
in the file is 10, the next byte is 11, the next is 12, and so on. The byte 
at file position 10 is 20, so the output is i = 20.
17. Answer: A, D.
Option A chains a data input stream onto a file input stream. D simply uses the RandomAccessFile
class. B fails because the FileReader class has no readInt() method; readers and writers handle only text. C fails because the PipedInputStream class has nothing to do with file I/O. (Piped input and output streams are used in inter-thread communication.) E fails because you cannot chain a data input stream onto a file reader. Readers read chars, and input streams handle bytes
18. Answer: E.
Readers and writers deal only with character I/O.
19. Answer: E.
Constructing an instance of the File class has no effect on the local file system.
20. Answer: A.
Compilation fails at lines 4 and 5, because there is no constructor for BufferedOutputStream that
takes a RandomAccessFile object as a parameter. You can be sure of this even if you are not familiar with buffered output streams, because random-access files are completely incompatible with the stream/reader/writer model.
21. Answer: D.
Default serialization is bypassed only if the writeObject() method has private access.

22. Answer:D.
Default deserialization is bypassed only if the readObject() method has private access.
23. Answer: B.
The lowest-level non-serializable superclass of the object being deserialized must have a no-args
constructor.
24. Answer: C.
An externalizable object must have a no-args constructor.
25. Answer: A, B, E.
Default serialization writes all non-static non-transient fields.
26. Answer: E.
The createNewFile() method creates a new empty file.
27. Answer: A, B, C, D.
Both System.out and System.err are instances of PrintStream, which has a println() method and (as
of version 5.0) a format() method.
28. Answer: B.
The writeObject() method is declared to take an Object argument. At runtime, there is a
precondition check to make sure the argument implements Serializable, which Object doesn‟t do.
29. Answer: A, C, D, E.
Only “ro” is not valid. “r” opens for reading only. “rw” opens for reading and writing. “rws” opens
for reading and writing, with immediate updating of data and metadata changes. “rwd” opens for reading and writing, with immediate updating of data (but not metadata) changes.
30. Answer: C.
A DataInputStream reads bytes from its data source, which must be an InputStream. 
The only valid option is C, FileInputStream.
