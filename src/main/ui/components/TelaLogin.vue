<template>

  <v-app>
    <div class="background"></div>
    <v-main class="d-flex justify-center align-center">
    <v-col cols="10" lg="4" class="mx-auto">
      <v-card class="pa-4">
        <div class="text-center">
          <v-avatar size="100" color="indigo lighten-4">
            <v-icon size="40" color="indigo">mdi-account</v-icon>
          </v-avatar>
          <h2 class="indigo-text">Faça o Login</h2>
        </div>
        <v-form @submit.prevent="submitHandler" ref="form">
          <v-card-text>
            <v-text-field
              v-model="usuario"
              :rules="usuarioRules"
              type="text"
              label="Usuário"
              placeholder="Usuário"
              prepend-inner-icon="mdi-account"
            ></v-text-field>
            <v-text-field
              v-model="password"
              :rules="passwordRules"
              :type="passwordShow? 'text' : 'password' "
              label="Senha"
              placeholder="Senha"
              prepend-inner-icon="mdi-key"
              :append-icon="passwordShow ? 'mdi-eye' : 'mdi-eye-off'"
              @click:append="passwordShow = !passwordShow"
            ></v-text-field>
          </v-card-text>
          <v-card-actions class="justify-center">
            <v-btn :loading="loading" type="submit" color="indigo">
              <span class="white--text px-8">Entrar</span>
             </v-btn>
          </v-card-actions>
        </v-form>
      </v-card>
    </v-col>
    </v-main>
    <v-snackbar top color="green" v-model="snackbar">
      Login Success
    </v-snackbar>
  </v-app>



</template>

<script>
export default {

    data: () => ({
        loading:false,
        snackbar:false,
        passwordShow:false,
        password: '',
        passwordRules: [
          v => !!v || 'Senha is required',
        ],

        usuario: '',
        usuarioRules: [
        v => !!v || 'Usuario is required',
      ],
    }),

    methods:{
      submitHandler(){
        if(this.$refs.form.validate()){
          this.loading = true
          setTimeout( ()=> {
            this.loading = false
            this.snackbar = true
          }, 1000)
        }
      }
    }
  };

</script>

<style>


</style>
