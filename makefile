TinyJava:
	cup -parser TinyJavaParserST -symbols Symbol -expect 20 TinyJavaST.cup
	jflex TinyJava.jflex
	javac -cp .:java-cup-11a-runtime.jar TinyJavaLexer.java
	javac -cp .:java-cup-11a-runtime.jar TinyJavaParsST.java

Test1:
	java -cp .:java-cup-11a-runtime.jar TinyJavaParsST < Tests/Test1.java

Test2:
	java -cp .:java-cup-11a-runtime.jar TinyJavaParsST < Tests/Test2.java

Test3:
	java -cp .:java-cup-11a-runtime.jar TinyJavaParsST < Tests/Test3.java

Test4:
	java -cp .:java-cup-11a-runtime.jar TinyJavaParsST < Tests/Test4.java

Test5:
	java -cp .:java-cup-11a-runtime.jar TinyJavaParsST < Tests/Test5.java

Test6:
	java -cp .:java-cup-11a-runtime.jar TinyJavaParsST < Tests/Test6.java

Test7:
	java -cp .:java-cup-11a-runtime.jar TinyJavaParsST < Tests/Test7.java

clean:
	rm -f *.class Symbol.java TinyJavaLexer.java TinyJavaParserST.java