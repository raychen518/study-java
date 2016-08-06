++++++++++++++++++++
Index
++++++++++++++++++++
Creating the JAR File
Running the JAR File
Introduction to MANIFEST.MF

====================
Creating the JAR File
====================
Note: Current directory should be the ROOT directory containing the complete compiled code (.class files instead of .java files).

------------------------------------------------------------
jar cfv D:\_Temp\jarTest.jar com\raychen518\study\java\deployment\jar
------------------------------------------------------------
\META-INF\MANIFEST.MF
--------------------------------------------------------------------------------
Manifest-Version: 1.0
Created-By: 1.8.0_66 (Oracle Corporation)
--------------------------------------------------------------------------------

------------------------------------------------------------
jar cfev D:\_Temp\jarTest.jar com.raychen518.study.java.deployment.jar.test.Application com\raychen518\study\java\deployment\jar
------------------------------------------------------------
\META-INF\MANIFEST.MF
--------------------------------------------------------------------------------
Manifest-Version: 1.0
Created-By: 1.8.0_66 (Oracle Corporation)
Main-Class: com.raychen518.study.java.deployment.jar.test.Application
--------------------------------------------------------------------------------

========================================
Running the JAR File
========================================
------------------------------------------------------------
java -jar jarTest.jar
------------------------------------------------------------
--------------------------------------------------------------------------------
Welcome to the JAR Test application.

a1.getField1(): 123
b1.getField1(): 456
c1.getField1(): 789
--------------------------------------------------------------------------------

------------------------------------------------------------
java -jar jarTest.jar a1 b2 c3
------------------------------------------------------------
--------------------------------------------------------------------------------
Welcome to the JAR Test application.

a1.getField1(): 123
b1.getField1(): 456
c1.getField1(): 789

argument[1]: a1
argument[2]: b2
argument[3]: c3
--------------------------------------------------------------------------------

========================================
Introduction to MANIFEST.MF
========================================
- A MANIFEST.MF file is a file containing metadata for a group of accompanying files.
  The term "manifest" is borrowed from a cargo shipping procedure, where a ship manifest would list the crew and/or cargo of a vessel.
- The MANIFEST.MF file in a Java project is located in the META-INF directory.
- The simplest MANIFEST.MF file contains only the following content.
  --------------------------------------
  Manifest-Version: 1.0
  --------------------------------------
