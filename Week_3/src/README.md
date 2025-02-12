This is the code for Fees Management

1. Main.java is the initializing code
2. It calls the LogPage.java where you need to choose whether Admin or Accountant to sign in
3. If the Credential is right it moves to Admin.java or Accountant.java else InvalidCredential Exception occurs
4. In Admin.java the command to control the Accountants present
5. In Accountant.java there is a method AccountantPage which controls the command for Student database
6. Student.java has the details of Student
7. For every phase the need of jdbc is done by JDBC.java which has methods to handle jdbc connectivity and execute MYSQL command
8. Multithreading is implemented for fast and independent execution



// UserExecption has all the Exception classes