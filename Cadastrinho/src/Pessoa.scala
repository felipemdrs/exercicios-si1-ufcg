abstract class Pessoa(_id: String, _nome: String) {

  def id = _id
  def nome = _nome
}

object TipoDePessoa extends Enumeration {
  type TipoDePessoa = Value
  val Juridica, Fisica = Value
}