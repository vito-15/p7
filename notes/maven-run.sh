#!/bin/bash
export PATH=/usr/local/apache-maven-3.3.9/bin:$PATH
cd /home/sadmin/devel/p7
mvn exec:java -Dexec.mainClass="com.p7.Solution"