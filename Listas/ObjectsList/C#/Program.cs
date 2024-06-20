using System;
using System.Collections.Generic;

class Program {

  public static void Main(String[] args) {

        List<Student> StudentsList = new List<Student>();
              
        string Name, Course;
        int Age;
        Student obj;

        for (int i = 0; i < 3; i++) 
        {
            Console.Write("Name: ");
            Name = Console.ReadLine();            
            Console.Write("Age: ");
            Age = int.Parse(Console.ReadLine());
            Console.Write("Course: ");
            Course = Console.ReadLine();

            obj = new Student (Name, Age, Course);
            if (!StudentsList.Contains(obj)) {
                StudentsList.Add(obj);
                StudentsList.Sort((student1, student2) => student1.Name.CompareTo(student2.Name));
            } else {
                Console.WriteLine("Student already registered.");
            }
        }
        
        foreach (var student in StudentsList)
        {
            Console.WriteLine(student.ToString());
        } 


  }

  

}