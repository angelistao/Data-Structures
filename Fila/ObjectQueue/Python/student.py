class Student:
    def __init__(self, registration, name):
        self.registration = registration
        self.name = name
    
    def __str__(self, obj):
        return "Aluno [registration=" + self.registration + ", name=" + self.name + "]"
    
    # def __eq__(self, obj):
    #     if (self.matricula != obj.matricula):
    #         return False
    #     if (self.nome != obj.nome):
    #         return False
    #     return True
        