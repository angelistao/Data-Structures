package Listas.ObjectsList.Java;

class Student {
    String name, course;
    int age;

    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return this.course;
    }
    
    public void setCourse(String course) {
        this.course = course;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Student other = (Student) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (age != other.age)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", course=" + course + ", age=" + age + "]";
    }

    
    
    
    
}