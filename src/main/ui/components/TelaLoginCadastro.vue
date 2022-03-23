<template>
<v-app>
  <v-content id="login-cadastro">
  <v-container class="fill-height" fluid>
    <v-row align="center" justify="center">
      <v-col cols="12" sm="8" md="8">
      <v-card class="elevation-12">
        <v-window v-model="step">
          <v-window-item :value="1">
            <v-row>
              <v-col cols="12" md="8">
                <v-card-text class="mt-12">
                  <h1 class="text-center display-2 teal--text text--accent-3">
                    Entre na sua conta PetShop
                  </h1>
                  <h4 class="text-center mt-4"> Utilize seu email cadastrado para realizar o login</h4>
                  <v-form>
                    <v-text-field
                      label="Email"
                      name="Email"
                      prepend-inner-icon="mdi-email"
                      type="text"
                      color="teal accent-3"
                    />

                    <v-text-field
                    id="senha"
                    label="Senha"
                    name="Senha"
                    prepend-inner-icon="mdi-key"
                    type="password"
                    color="teal accent-e"
                    />
                    <div class="text-center">
                      <v-btn rounded>Entrar</v-btn>
                    </div>
                  </v-form>
                  <h3 class="text-center mt-4">Esqueceu sua senha?</h3>
                </v-card-text>
                <div class="text-center mt-3">
                  <v-btn rounded color="teal accent-3" dark>Recuperar senha</v-btn>
                </div>
              </v-col>
              <v-col cols="12" md="4" class="teal accent-3">
                <v-card-text class="white--text mt-12">
                  <h1 class="text-center display-1">Bem-vindo, novo amigo!</h1>
                  <h5 class="text-center"
                  >Junte-se a nossa comunidade com o melhor gerenciador de PetShop online</h5>
                </v-card-text>
                <div class="text-center">
                  <v-btn rounded outlined dark @click="step++">Cadastre-se</v-btn>
                </div>
              </v-col>
            </v-row>
          </v-window-item>

          <v-window-item :value="2">
            <v-row class="fill-height">
              <v-col cols="12" md="4" class="teal accent-3">
                <v-card-text class="white--text mt-12">
                  <h1 class="text-center display-1">Bem vindo de volta!</h1>
                  <h5 class="text-center"
                  >Para ter acesso a sua conta, por favor realize o login</h5>
                </v-card-text>
                <div class="text-center">
                  <v-btn rounded outline dark @click="step--">Entrar</v-btn>
                </div>
              </v-col>

              <v-col cols="12" md="8">
                <v-card-text class="mt-12">
                  <h1 class="text-center display-2 teal--text text--accent-3">Crie sua conta</h1>
                  <h4 class="text-center mt-4">Informe seus dados para se registrar</h4>
                  <v-form>
                    <v-text-field
                    label="Nome"
                    name="Nome"
                    prepend-inner-icon="mdi-account"
                    type="text"
                    color="teal accent-3"
                    />

                    <v-text-field
                    label="Email"
                    name="Email"
                    prepend-inner-icon="mdi-email"
                    type="text"
                    color="teal accent-3"
                    />

                    <v-text-field
                    id="senha"
                    label="Senha"
                    name="Senha"
                    prepend-inner-icon="mdi-key"
                    type="password"
                    color="teal accent-3"
                    />
                  </v-form>
                </v-card-text>
                <div class="text-center mt-n5">
                  <v-btn rounded color="teal accent-3" dark>Criar conta</v-btn>
                </div>
              </v-col>
            </v-row>
          </v-window-item>
        </v-window>
      </v-card>
      </v-col>
    </v-row>
  </v-container>
  </v-content>
</v-app>
</template>

<script>
export default {
  data: () => ({
    step: 1
  }),
  props: {
    source: String
  }
};
</script>

<style>

</style>
