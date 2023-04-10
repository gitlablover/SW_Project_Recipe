This is the Digital Cookbook Application "Recipe Box" created by Group 1 of Software Engineering II class in Technische Hochschule Lübeck, 2021.

COPYRIGHT © 2021 Group 1 (Bo Jiao, Hanzhi Zhuang & Hao Yuan) SWE II Java Project "at" Technische Hochschule Lübeck

Professor & Supervisor: Prof. Mrs. Lenka Hanesová & Mr. Guozhi Zhan

If you had any questions or constructive suggestions regarding our projects, feel free to write us an e-mail : bo.jiao@stud.th-luebeck.de



Brief Intro:

Digital Cookbook "Recipe Box" is a JavaSE-based software which can be run as a desktop application. With our software, the user can either create new recipes, edit or delete existing recipes, set/unset recipes as favorited collection.

All the functional requirements are tested by our team members without bugs.


How to run it on your PC?

1. Prerequisites about Running Environment:

-- 1. Operation System: Windows XP/7/8/10, macOS or Linux (e.g. Ubuntu).

-- 2. Java Running Environment(JREs 5.0+): Java 8.0 is recommended.

-- 3. Integrated Development Environment Tools: Eclipse or IntelliJ IDEA.

-- 4. MySQL Database Server: MySQL Server Community 5.7 and 8.0.

-- 5. MySQL Workbench or other Database Manage Software.

-- 6. Have javafx sdk installed.

2. Setting up Procedure

-- 1. Get a copy of our code.

-- 2. Import it as a project into you IDE.

-- 3. Find in package dao the BaseConnector.java, modify at line 15, 16 the user and password to your MySQL account.

-- 4. Open your Database Manage Software (e.g. MySQL Workbench). Turn off the Safe Update Function. Execute the SQL file in the project folder called data.sql.

-- 5. The Entrance of our Digital Cook book is at package entrance, the CookbookApp.java. Find and open it. Go to "Run -> Run Configurations...  -> Java Application", create a new launch configuration for the project and under "Arguments" add these VM arguments:

------------------------------------------------------------------------------------------
For Linux/Mac please add:
--module-path /path/to/javafx-sdk-15.0.1/lib --add-modules javafx.controls,javafx.fxml

For Windows please add:
--module-path "\path\to\javafx-sdk-15.0.1\lib" --add-modules javafx.controls,javafx.fxml
------------------------------------------------------------------------------------------
** Note: Please replace "/path/to/javafx-sdk-15.0.1/lib" or ""\path\to\javafx-sdk-15.0.1\lib"" to your absolute path to javafx sdk.

Warning: Make sure the checkbox "Use the -XstartOnFirstThread argument when launching with SWT" is not checked.
------------------------------------------------------------------------------------------

And then run it as Java Application.

** For this step, you can find more information here: https://openjfx.io/openjfx-docs/#IDE-Eclipse.

-- 6. When you see the Main window pops up, it means the application is running well. Enjoy yourself in our Digital Cookbook "Recipe Box".

