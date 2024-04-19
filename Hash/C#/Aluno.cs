class Aluno {
    
    public int Matricula {get; set;}
    public string Nome {get; set;}


    public Aluno(int Matricula, string Nome) {
        this.Matricula = Matricula;
        this.Nome = Nome;
    }

    public override bool Equals(object obj)
    {
        //
        // See the full list of guidelines at
        //   http://go.microsoft.com/fwlink/?LinkID=85237
        // and also the guidance for operator== at
        //   http://go.microsoft.com/fwlink/?LinkId=85238
        //
        
        if (obj == null || GetType() != obj.GetType())
        {
            return false;
        }
        
        // TODO: write your implementation of Equals() here
        throw new System.NotImplementedException();
        return base.Equals (obj);
    }
    
    // override object.GetHashCode
    public override int GetHashCode()
    {
        // TODO: write your implementation of GetHashCode() here
  
        return base.GetHashCode();
    }

    public override string ToString(){
        return "Aluno [matricula=" + Matricula + ", nome=" + Nome + "]";
    }


    
}