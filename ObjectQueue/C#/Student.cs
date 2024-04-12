class Student {
    public int Registration {get ; set;}
    public string Name {get ; set;}

    public Student(int Registration, string Name) {
        this.Registration = Registration;
        this.Name = Name;
    }

    
    public override string ToString() {
        return "Aluno [Registration=" + Registration + ", Name=" + Name + "]";
    }

    
    public override bool Equals(object obj) {
     
        
        Student other = (Student) obj;
        if (Registration != other.Registration)
            return false;
        if (Name == null) {
            if (other.Name != null)
                return false;
        } else if (!Name.Equals(other.Name))
            return false;
        return true;
    }
}