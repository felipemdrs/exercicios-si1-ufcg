

import org.junit.Test
import org.junit.Assert._
import org.junit.Before
import scala.collection.mutable.Map

class CadastrinhoTest {

  private var app: Cadastrinho = null

  @Before def setup() {
    app = new Cadastrinho()
  }

  @Test def deveTerInseridoPessoa() {
    var pessoa = new PessoaFisica("525448", "Felipe", "12345")
    app.cadastrar(pessoa)
    assertFalse(app.isEmpty)
  }

  @Test def deveIniciarVazio() {
    assertTrue(app.isEmpty)
  }

  @Test def devePegarAUltimaPessoaInserida() {
    var pessoa, lastPessoa: Pessoa = null

    pessoa = new PessoaFisica("525448", "Felipe", "12345")
    app.cadastrar(pessoa)
    lastPessoa = app.getLast
    assertEquals("525448", lastPessoa.id);
    assertEquals("Felipe", lastPessoa.nome);
    assertEquals("12345", lastPessoa.asInstanceOf[PessoaFisica]cpf);

    pessoa = new PessoaFisica("123456", "Manoel", "54321")
    app.cadastrar(pessoa)
    lastPessoa = app.getLast
    assertEquals("123456", lastPessoa.id);
    assertEquals("Manoel", lastPessoa.nome);
    assertEquals("54321", lastPessoa.asInstanceOf[PessoaFisica]cpf);

    pessoa = new PessoaJuridica("654987", "Mariana", "789456")
    app.cadastrar(pessoa)
    lastPessoa = app.getLast
    assertEquals("654987", lastPessoa.id);
    assertEquals("Mariana", lastPessoa.nome);
    assertEquals("789456", lastPessoa.asInstanceOf[PessoaJuridica]cnpj);
  }

  @Test def deveSaberQuantosTiposDePessoasTem() {
    var pessoa, lastPessoa: Pessoa = null
    var esperado: Map[TipoDePessoa.TipoDePessoa, Int] = Map()

    esperado = app.getQntDePessoasPorTipo()

    assertEquals(0, esperado.get(TipoDePessoa.Fisica).get)
    assertEquals(0, esperado.get(TipoDePessoa.Juridica).get)

    pessoa = new PessoaFisica("525448", "Felipe", "12345")
    app.cadastrar(pessoa)
    esperado = app.getQntDePessoasPorTipo()

    assertEquals(1, esperado.get(TipoDePessoa.Fisica).get)
    assertEquals(0, esperado.get(TipoDePessoa.Juridica).get)

    pessoa = new PessoaFisica("123456", "Manoel", "54321")
    app.cadastrar(pessoa)
    esperado = app.getQntDePessoasPorTipo()

    assertEquals(2, esperado.get(TipoDePessoa.Fisica).get)
    assertEquals(0, esperado.get(TipoDePessoa.Juridica).get)

    pessoa = new PessoaJuridica("654987", "Mariana", "789456")
    app.cadastrar(pessoa)
    esperado = app.getQntDePessoasPorTipo()

    assertEquals(2, esperado.get(TipoDePessoa.Fisica).get)
    assertEquals(1, esperado.get(TipoDePessoa.Juridica).get)

    app.remover("Felipe")
    esperado = app.getQntDePessoasPorTipo()
    assertEquals(1, esperado.get(TipoDePessoa.Fisica).get)
    assertEquals(1, esperado.get(TipoDePessoa.Juridica).get)
  }

  @Test def deveTerAQuantidadeDePessoasInseridas() {
    assertEquals(0, app.total)

    var pessoa: Pessoa = null
    pessoa = new PessoaFisica("525448", "Felipe", "12345")
    app.cadastrar(pessoa)

    assertEquals(1, app.total)

    pessoa = new PessoaFisica("123456", "Manoel", "54321")
    app.cadastrar(pessoa)
    assertEquals(2, app.total)
  }

  @Test def deveRemoverAPessoaCerta() {
    var pessoa, lastPessoa: Pessoa = null

    pessoa = new PessoaFisica("525448", "Felipe", "12345")
    app.cadastrar(pessoa)

    pessoa = new PessoaFisica("123456", "Manoel", "54321")
    app.cadastrar(pessoa)

    app.remover("Felipe")
    assertEquals(1, app.total)

    lastPessoa = app.getLast

    assertEquals("Manoel", lastPessoa.nome);
    assertEquals("123456", lastPessoa.id);
  }
}