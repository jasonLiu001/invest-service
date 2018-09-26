<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <router-link to="/" class="navbar-brand">首页</router-link>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <router-link to="/" class="nav-item nav-link active">首页 <span class="sr-only">(current)</span>
        </router-link>
        <router-link to="/about" class="nav-item nav-link">关于</router-link>
      </div>
    </div>
  </nav>
</template>

<script>
  export default {
    name: "Header"
  }
</script>

<style scoped>

</style>
