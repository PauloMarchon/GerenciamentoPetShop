<template>
<v-card id="lateral">
    <v-toolbar
      dark
      tabs
      flat
      color="grey"
    >
      <v-app-bar-nav-icon></v-app-bar-nav-icon>
      <v-toolbar-title>Gerenciamento de Pet Shop</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn icon>
        <v-icon>mdi-magnify</v-icon>
      </v-btn>

      <v-btn icon>
        <v-icon>mdi-dots-vertical</v-icon>
      </v-btn>
      
      <template v-slot:extension>
        <v-tabs
          v-model="tabs"
          align-with-title
        >
        
          <v-tab href="#um">
            Agenda
            <v-icon dark right>
          mdi-application-edit-outline
            </v-icon>
          </v-tab>

          <v-tab href="#dois">
            Animal
            <v-icon dark right>
          mdi-dog-side
            </v-icon>
          </v-tab>
          
          <v-tab href="#tres">
            Caixa
            <v-icon dark right>
          mdi-storefront-outline
            </v-icon>
          </v-tab>

          <v-tab href="#quatro">
            Consulta
            <v-icon dark right>
          mdi-magnify
            </v-icon>
          </v-tab>

          <v-tab href="#cinco">
            Cliente
            <v-icon dark right>
          mdi-account-details
            </v-icon>
          </v-tab>

          <v-tab href="#seis">
            Nota xml
            <v-icon dark right>
          mdi-note-text-outline
            </v-icon>
          </v-tab>

          <v-tab href="#sete">
            Nota de serviço
            <v-icon dark right>
          mdi-notebook-check-outline
            </v-icon>
          </v-tab>

          <v-tab href="#oito">
            Medicamento
            <v-icon dark right>
          mdi-medical-bag
            </v-icon>
          </v-tab>

          <v-tab href="#nove">
            Relatório
            <v-icon dark right>
          mdi-note-multiple-outline
            </v-icon>
          </v-tab>

          <v-tab href="#dez">
            Serviços
            <v-icon dark right>
          mdi-room-service-outline
            </v-icon>
          </v-tab>

          <v-tab href="#onze">
            Usuário
            <v-icon dark right>
          mdi-account
            </v-icon>
          </v-tab>
          
          <v-tabs-slider color="white"></v-tabs-slider>
        </v-tabs>
      </template>
    </v-toolbar>
    <v-card-text>
      <v-tabs-items v-model="tabs">
        <v-tab-item
          v-for="content in ['um', 'dois', 'tres', 'quatro', 'cinco', 'seis', 'sete', 'oito', 'nove', 'dez', 'onze']"
          :key="content"
          :value="content"
        >
          <v-card
            height="650px"
            flat
          >
          </v-card>
        </v-tab-item>
      </v-tabs-items>
    </v-card-text>
    <v-fab-transition>
      <v-btn
        :key="activeFab.icon"
        :color="activeFab.color"
        fab
        large
        dark
        bottom
        left
        class="v-btn--example"
      >
        <v-icon>{{ activeFab.icon }}</v-icon>
      </v-btn>
    </v-fab-transition>
  </v-card>
</template>


<script>
 export default {
    data: () => ({
      fab: false,
      hidden: false,
      tabs: null,
    }),

    computed: {
      activeFab () {
        switch (this.tabs) {
          case 'um': return { color: 'success', icon: 'mdi-account' }
          case 'dois': return { color: 'red', icon: 'mdi-pencil' }
          case 'tres': return { color: 'green', icon: 'mdi-chevron-up' }
          default: return {}
        }
      },
    },
  }
</script>

<style>

</style>