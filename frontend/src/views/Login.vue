<template>
  <div>
    <h1>LOGIN</h1>
    <form @submit.prevent="login">
      <input v-model="username" placeholder="username" />
      <br />
      <br />
      <input v-model="password" placeholder="password" type="password" />
      <br />
      <br />
      <button type="submit">Login</button>
    </form>
  </div>
</template>
<script>
import axios from "axios";
export default {
  data: () => {
    return {
      username: "",
      password: "",
    };
  },
  methods: {
    // login() {
    //   console.log(this.username);
    //   console.log(this.password);
    //   fetch("http://localhost:8080/api/login", {
    //     method: "POST",
    //     headers: {
    //       "Content-Type": "application/json",
    //     },
    //     body: JSON.stringify({
    //       username: this.username,
    //       password: this.password,
    //     }),
    //   });
    // },
    login() {
      // this.loading = true;
      let options = {};
      options["username"] = this.username;
      options["password"] = this.password;
      axios({
        method: 'post',
        url: 'http://localhost:8080/api/login',
        data: options
      }).then(response => {
        console.log(response);
      }).catch((error) => {
        console.log(error);
      })
    },
  },
};
</script>