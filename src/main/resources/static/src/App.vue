<template>
  <v-app id="inspire">
    <v-navigation-drawer
      v-model="drawer"
      fixed
      app>
      <v-list dense>
        <v-list-tile @click="">
          <v-list-tile-action>
            <v-icon>home</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>Home</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
        <v-list-tile @click="">
          <v-list-tile-action>
            <v-icon>contact_mail</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>Contact</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
      </v-list>
    </v-navigation-drawer>
    <v-toolbar color="indigo" dark fixed app>
      <v-toolbar-side-icon @click.stop="drawer = !drawer"></v-toolbar-side-icon>
      <v-toolbar-title>Application</v-toolbar-title>
    </v-toolbar>
    <v-content>
      <v-container fluid fill-height>
        <v-layout
          justify-center
          align-center>
          <v-flex text-xs-center>

          </v-flex>
        </v-layout>
      </v-container>
    </v-content>
    <v-footer color="indigo" app>
      <span class="white--text">&copy; 2017</span>
    </v-footer>
  </v-app>
  <!--<div class="container">-->
  <!--&lt;!&ndash;公共头部&ndash;&gt;-->
  <!--<Header></Header>-->

  <!--&lt;!&ndash; route outlet &ndash;&gt;-->
  <!--&lt;!&ndash; component matched by the route will render here &ndash;&gt;-->
  <!--<router-view></router-view>-->

  <!--&lt;!&ndash;公共底部&ndash;&gt;-->
  <!--<Footer></Footer>-->
  <!--</div>-->
</template>

<script>
  import Header from './components/Header';
  import Footer from './components/Footer';

  export default {
    components: {
      Header,
      Footer
    },
    name: 'app',
    data() {
      return {
        drawer: null,
        msg: 'Welcome to Your Vue.js App'
      }
    },
    props: {
      source: String
    }
  }
</script>

<style lang="scss">

</style>
