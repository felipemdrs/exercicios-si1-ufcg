class PessoaFisica(_id: String, _nome: String, _cpf: String) extends Pessoa(_id, _nome) {
  def cpf() = _cpf
}