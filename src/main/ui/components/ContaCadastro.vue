<template>
<div class="container-lg" style="margin-top: 30px">
    <div class="column">
      <template v-for="notificacao in notificacoes">
        <div
          :class="notificacao.tipo=== 1 ? 'alert alert-success alert-dismissible fade show':'alert alert-danger alert-dismissible fade show' "
          :key="notificacao.index">
          <i :class="notificacao.tipo === 1 ? 'fas fa-check': 'fas fa-exclamation-triangle'" style="margin-right: 10px;"></i>{{notificacao.mensagem}}
          <button
            type="button"
            class="close"
            @click="fechar(notificacao)"
          >
            <span> <i class="fas fa-times"></i></span>
          </button>
        </div>
      </template>
    </div>
    <div class="column justify-content-md-center">
      <div class="card" style="margin-bottom: 16px">
        <div class="card-body">
          <h5 class="card-title">Cadastro de Conta</h5>
          <form id="cadastro" @submit="salvarAny" @reset="limpar">
            <div class="form-group">
              <label>Nome</label>
              <input
                v-model="usuario.nomeUsuario"
                class="form-control"
                id="exampleInputEmail1"
                placeholder="Digite o seu nome"
                required
              />
            </div>
            <div class="form-group">
              <label for="exampleInputEmail1">E-mail</label>
              <input
                v-model="usuario.emailUsuario"
                placeholder="Digite seu e-mail"
                type="email"
                class="form-control"
                id="email"
                aria-describedby="emailHelp"
                required           
              />
            </div>
            <div class="form-group">
              <label>Senha</label>
              <input
                v-model="usuario.senhaUsuario"
                class="form-control"
                type="password"
                id="exampleInputEmail1"
                placeholder="Digite sua senha"
                required
              />
            </div>
            <button
              type="submit"
              class="btn btn-success"
              style="margin-right: 16px"
            >
              <i class="fas fa-save" style="padding-right: 5px"></i> Salvar
            </button>
            <button type="reset" class="btn btn-secondary">
              <i class="fas fa-eraser" style="padding-right: 5px"></i> Limpar
            </button>
          </form>
        </div>
      </div>
      <div class="card">
        <div class="card-body">
          <h5 class="card-title">Contas Cadastradas</h5>
          <table class="table">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Nome</th>
                <th scope="col">E_mail</th>
                <th scope="col">Opções</th>
              </tr>
            </thead>
            <tbody>
              <template v-for="usuario in getUsuariosCadastrados">
                <tr :key="usuario.idUsuario">
                  <th scope="row">{{ usuario.idUsuario }}</th>
                  <td>{{ usuario.nomeUsuario }}</td>
                  <td>{{ usuario.emailUsuario }}</td>
                  <td>
                    <div class="row">
                      <button
                        class="btn btn-primary botao"
                        style="margin-right: 6px"
                        @click="editar(usuario)"
                      >
                        <i class="fas fa-edit"></i>
                      </button>
                      <button
                        class="btn btn-danger botao"
                        @click="excluir(usuario)"
                      >
                        <i class="fas fa-trash-alt"></i>
                      </button>
                    </div>
                  </td>
                </tr>
              </template>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import usuarioService from "../services/usuarioService.js" 

export default{
  name: "usuarioCadastro",

  data(){
    return{

      usuario: {
        nomeUsuario: null,
        emailUsuario: null,
        senhaUsuario: null,
      },

      usuariosCadastrados: [],
      notificacoes: [],
    };
  },

  computed:{
    getUsuariosCadastrados(){
      return this.usuariosCadastrados
    },
    getEmailUsuario(){
      return this.usuario.emailUsuario
    }
  },

  watch:{
   
    async created(){
      this.usuariosCadastrados = await usuarioService
        .listarContas()
        .then((response) => response.data);
    }
  },

  methods: {
    salvar(){
      if(this.usuario.idUsuario !== null){
        usuarioService
          .alterarConta(this.usuario)
          .then((response) => {
            if(response.status === 200) {
              this.limpar();
              this.editarTabela(response.data)
              this.notificacoes.push(this.gerarNotificacao('Conta Alterada com Sucesso !', 1))
            }
          })
          .catch((err) => {
          this.notificacoes.push(this.gerarNotificacao(err.response.data.message), 0)
          });
      } else {
      usuarioService
        .salvarConta(this.usuario)
        .then((response) => {
          if (response.status === 201) {
            this.limpar();
            this.usuariosCadastrados.unshift(response.data);
            this.notificacoes.push(this.gerarNotificacao('Conta Criada com Sucesso !', 1))
          }
        })
        .catch((err) => {
          this.notificacoes.push(this.gerarNotificacao(err.response.data.message), 0)
        });
      }
    },
    editarTabela (usuario) {
      let index =  this.usuariosCadastrados.findIndex(c => c.idUsuario === usuario.idUsuario)
      let chaves = Object.keys(usuario)
      chaves.forEach(c => {
        this.usuariosCadastrados[index][c] = usuario[c]
      })
    },
    fechar(notificacao) {
      this.notificacoes = this.notificacoes.filter(n => n.mensagem !== notificacao.mensagem)
    },
    gerarNotificacao(mensagem, tipo) {
      return {
        index: this.notificacoes.length + 1,
        mensagem: mensagem,
        tipo: tipo
      }
    },
    formataData(data) {
      var val = data.split("-");
      return `${val[2]}/${val[1]}/${val[0]}`;
    },
    editar(usuario) {
      console.log(usuario);
      const chaves = Object.keys(usuario);
      chaves.forEach((c) => {
        this.usuario[c] = usuario[c];
      });
    },
     
     salvarAny(){
       usuarioService.salvarConta(this.usuario)
     },

    async excluir(usuario) {
      const res = await usuarioService.excluirConta(usuario.idUsuario)
      .then(response => {
        return response
      }).catch(err=>{
        this.notificacoes.push(this.gerarNotificacao(err.response.data.message), 0)
      })
      if (res.status === 204) {
         this.usuariosCadastrados = this.usuariosCadastrados.filter(c => c.idUsuario !== usuario.idUsuario)
         this.notificacoes.push(this.gerarNotificacao('Conta Removida com Sucesso !', 1))
        }
    },

    limpar() {
      this.usuario.nomeUsuario = null;
      this.usuario.emailUsuario = null;
      this.usuario.senhaUsuario = null;
    }
  },

}
</script>

<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
