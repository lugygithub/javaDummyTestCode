all:
	@if [ ! -d build ]; then mkdir build; fi
	@javac -d build *.java
run:
	@java -cp build caller
clean: 
	rm -rf ./build
