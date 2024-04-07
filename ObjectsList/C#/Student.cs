public class Student {
  public string Name { get; set; }
  public int Age  { get; set; }
  public string Course  { get; set; }

  public Student(string Name, int Age, string Course) {
    this.Name = Name;
    this.Age = Age;
    this.Course = Course;
  }

  
  public override string ToString(){
    return "Student [" + this.Name + ", " + this.Age + ", " + this.Course + "] ";
  }

}

