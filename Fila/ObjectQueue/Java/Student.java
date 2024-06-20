package ObjectQueue.Java;

public class Student {
    public int registration;
    public String name;

    public Student(int registration, String name) {
        this.registration = registration;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Aluno [registration=" + registration + ", name=" + name + "]";
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
        if (registration != other.registration)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    
}
 
    

