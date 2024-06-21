class Atleta
{
    public string Nome { get; set; }
    public string Apelido { get; set; }
    public double Altura { get; set; }
    public string Posicao { get; set; }

    public override string ToString()
    {
        return $"Nome: {Nome}, Apelido: {Apelido}, Altura: {Altura}m, Posição: {Posicao}";
    }
}