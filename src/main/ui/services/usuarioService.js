import axios from 'axios'

const BASE_URL = 'http://localhost:8080'

export default{

  salvarConta: (usuario) => axios.post(BASE_URL + '/api/salvar'),
  alterarConta: (usuario) => axios.put(BASE_URL + '/api/alterar'),
  excluirConta: (idUsuario) => axios.delete(BASE_URL + '/api/excluir/' + idUsuario),
  listarContas: () => axios.get(BASE_URL + '/api/listar-todas'),
  validarEmail: (emailUsuario) => axios.get(BASE_URL + '/api/validar-email/' + emailUsuario)
}