<template>
  <div class="container">
    <!--公共头部-->
    <Header></Header>

    <!-- route outlet -->
    <!-- component matched by the route will render here -->
    <router-view></router-view>

    <!--公共底部-->
    <Footer></Footer>
  </div>
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
        msg: 'Welcome to Your Vue.js App'
      }
    }
  }
</script>

<style lang="scss">

</style>
