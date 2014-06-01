
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Map

class Cadastrinho {

  private var _pessoas = ListBuffer[Pessoa]()

  def pessoas = this._pessoas

  def cadastrar(pessoa: Pessoa) {
    this._pessoas += pessoa
  }

  def isEmpty(): Boolean = this._pessoas.length == 0

  def getLast(): Pessoa = _pessoas.last

  def total(): Int = _pessoas.length

  def remover(nome: String) {
    var pessoaEncontrada = _pessoas.indexWhere(x => x.nome.equals(nome))
    if (pessoaEncontrada != -1) {
      _pessoas.remove(pessoaEncontrada)
    }
  }
  
  def getQntDePessoasPorTipo(): Map[TipoDePessoa.TipoDePessoa, Int] = {
    var qnt : Map[TipoDePessoa.TipoDePessoa, Int] = Map()
    
    var fisica: Int = _pessoas.filter(x => x.isInstanceOf[PessoaFisica]).length
    
    qnt(TipoDePessoa.Fisica) = fisica
    qnt(TipoDePessoa.Juridica) = _pessoas.length - fisica
    
    return qnt
  }
}