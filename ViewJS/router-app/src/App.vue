<template>
<div id="nav">
    <router-link to="/">Home</router-link> |
    <router-link to="/about/Rahim">Rahim's About Page</router-link> |
    <router-link to="/about/Papon">Papon's About Page</router-link> |
    <router-link to="/about/Karim">Karim's About Page</router-link>
</div>
<router-view />
</template>

<script>
export default {
    name: 'App',
}
</script>

<style>
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
}
</style>
