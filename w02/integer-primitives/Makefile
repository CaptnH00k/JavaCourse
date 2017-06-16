PKG=integerprimitives

all: clean compile run
compile:
		mkdir -p classes
		javac src/$(PKG)/*.java -d classes
run:
		java -cp classes $(PKG).Main
clean:
		rm -rf classes
