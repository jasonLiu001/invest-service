<template>
  <v-app>

    <!--底部tab-->
    <v-bottom-nav :active.sync="bottomNav" :value="true" fixed app absolute color="transparent">
      <v-btn color="teal" flat value="profit" @click="goProfit">
        <span>Profit</span>
        <v-icon>search</v-icon>
      </v-btn>

      <v-btn color="teal" flat value="about" @click="goAbout">
        <span>About</span>
        <v-icon>person</v-icon>
      </v-btn>
    </v-bottom-nav>

    <!--router outlet-->
    <router-view></router-view>

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
        bottomNav: 'profit',
        drawer: false,
        msg: 'Welcome to Your Vue.js App'
      }
    },
    methods: {
      goProfit() {
        this.$router.push({path: 'profit'});
      },
      goAbout() {
        this.$router.push({path: 'about'});
      }
    },
    props: {
      source: String
    }
  }
</script>

<style lang="scss">

</style>
