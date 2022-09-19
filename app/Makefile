run-dist:
	./build/install/app/bin/app

run-help:
	./build/install/app/bin/app --help


build:
	gradle clean build
	gradle test
	gradle checkstyleMain
	gradle checkstyleTest

.PHONY: build