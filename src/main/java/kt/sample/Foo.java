package kt.sample;

public class Foo {
  private String name = "";

  public Foo() {
    this("_unnamed_");
  }

  public Foo(String n) {
    name = n;
  }

  public String getMessage() {
    return "I'm an instance of Java Foo, named " + name;
  }
}
