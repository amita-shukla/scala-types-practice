import java.io.File

object Traits extends App {
  trait FileOps{
    // "Self-types are a way to declare that a trait must be mixed into another trait, even though it doesn’t directly extend it.
    // That makes the members of the dependency available without imports."
    // self type annotation: allows you to use file class members in the body of this trait
    // with this annotation: file ops can only be mixed into java.io.File
    self: File =>

    def isTextFile: Boolean = this.getName.endsWith("txt") //getName belongs to java.io.File, can be used here
  }

  // fooTextFile is a java.io.File object with access to all methods in FileOps
  val fooTextFile = new File("./foo.txt") with FileOps
  println(fooTextFile.getName)
  println(fooTextFile.isTextFile)

}
