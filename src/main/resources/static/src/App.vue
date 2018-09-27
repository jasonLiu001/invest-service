<template>
  <v-app id="inspire">

    <!--页面左侧-->
    <v-navigation-drawer v-model="drawer" fixed app>

      <v-list dense>
        <v-list-tile @click.stop="goProfit">
          <v-list-tile-action>
            <v-icon>home</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>查询</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>

        <v-list-tile @click.stop="goProfit">
          <v-list-tile-action>
            <v-icon>contact_mail</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>Contact</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>

      </v-list>
    </v-navigation-drawer>

    <!--页面顶部-->
    <v-toolbar color="indigo" dark fixed app>
      <v-toolbar-side-icon @click.stop="drawer = !drawer"></v-toolbar-side-icon>
      <v-toolbar-title>查询</v-toolbar-title>
    </v-toolbar>

    <!--页面正文-->
    <v-content>
      <v-container fluid fill-height>
        <v-layout
          justify-center
          align-center>
          <v-flex text-xs-center>

            <!--router outlet-->
            <router-view></router-view>
          </v-flex>
        </v-layout>
      </v-container>
    </v-content>

    <!--页面底部-->
    <v-footer color="indigo" app>
      <span class="white--text">&copy; 2018</span>
    </v-footer>

  </v-app>
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
        drawer: false,
        msg: 'Welcome to Your Vue.js App'
      }
    },
    methods: {
      goProfit() {
        //是否显示左侧菜单
        this.drawer = !this.drawer;
        this.$router.push({path: 'profit'});
      }
    },
    props: {
      source: String
    }
  }
</script>

<style lang="scss">

</style>
