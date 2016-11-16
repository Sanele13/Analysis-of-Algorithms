#!/bin/tcsh

JAVAC=javac
JFLAGS=-g

*.class:*.java
	$(JAVAC) $(JFLAGS) *.java
clean:
	rm *.class
