class PessoaJuridica(_id: String, _nome: String, _cnpj: String) extends Pessoa(_id, _nome) {
  def cnpj = _cnpj
}