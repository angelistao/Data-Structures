class aluno:
    def __init__(self, matricula, nome):
        self.matricula = matricula
        self.nome = nome

    def __str__(self):
        return f'Aluno [matricula={self.matricula} nome={self.nome}'
    
    def __hash__(self):
        return (hash(self.matricula))
    
    