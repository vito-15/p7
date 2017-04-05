#!/bin/bash
export PATH=/usr/local/apache-maven-3.3.9/bin:$PATH
# cd /home/sadmin/devel/todolist
mvn exec:java -Dexec.mainClass="com.app.Solution"