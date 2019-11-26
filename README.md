# attendance-system

1. Installation
2. About
3. Setup
4. Documentation
5. Support
6. Input
7. Output


Installation
	- All the code required to get started.
	

Clone
	- Clone this repo to your local machine using https://https://github.com/shubhamujain/attendance-system
	
About
	- This project uses spring-boot 2 and gives student's attendance records by his SID and also it gives students attendance by date.
	

Setup
	1. Java 8 or above.
	2. Spring Tool Suite 4 or above.
	3. Maven 3.6 or above.
	4. Postman 7 or above.
	
Documentation
	- Find JavaDoc in doc directory in the project.
	
Input
	- SID of student to getStudentById() method.
	- Date to detailsByDate
	
Output
	- Student's attendance records by his SID
	- students attendance by date
	
Records By ID:

![Screenshot (15)](https://user-images.githubusercontent.com/25982691/69494628-fa6c7b80-0ee3-11ea-99be-0f6a12602281.png)


Records By Date:

![Screenshot (16)](https://user-images.githubusercontent.com/25982691/69494637-1a9c3a80-0ee4-11ea-99ae-5250293d1fbb.png)

![Screenshot (17)](https://user-images.githubusercontent.com/25982691/69494638-1a9c3a80-0ee4-11ea-983d-fab9a420f724.png)

![Screenshot (18)](https://user-images.githubusercontent.com/25982691/69494639-1a9c3a80-0ee4-11ea-82db-63dbe0a0cfea.png)

Approach to fix the issue:
	1. I checked the logs and analyzed my code.
	2. Then I itrated through my code(dry run) and found the exact issue.
	3. Followed below steps to fix the issue.

Changes to fix the issue:
	1. was adding the student object to the list outside the if condition specified.
	2. viz. if (attendance.getAttendanceDate().equals(date) && student.getId().equals(attendance.getStudentId())) on line 65 of StudentService Class.
	3. so now adding the student object to list inside the if condition which is specified above.
	4. for avoiding duplicate records, written the for loop which is comparing the student object with whole list and if contains the student object already then does not add.
