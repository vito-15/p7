Simple task manager.
Add new, edit, remove, mark as done, mark as undone.
Show tasks: all, complited, not complited with pagination

Used:
Intellij Idea, Java 8, Git, Mysql, Maven, Spring MVC, Hibernate, Tomcat 8, Bootstrap

Database
mysql-server with database "test"
../sql/test.sql - Created with "mysqldump -u root -p test > test.sql". Contains table "Task" with test data.

To restore db test from test.sql you need to run:
mysql -u root -p test < test.sql
!!!Warning: this command will drop table "Task" from db "test" and create new from .sql file.


File dispatcher-servlet.xml contains connection data.
You may change it to your db  connection.
<beans:bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource"
                destroy-method="close">
        <beans:property name="driverClassName" value="com.mysql.jdbc.Driver" />
        <beans:property name="url" value="jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8" />
        <beans:property name="username" value="root" />
        <beans:property name="password" value="root" />
    </beans:bean>
