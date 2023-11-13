<template>
    <div id="app" class="container">
      <!--3. 템플릿 완성-->
      <div class="card card-body bg-light">
        <div class="title">:: Todolist App</div>
      </div>
      <div class="card card-default card-borderless">
        <div class="card-body">
          <div class="row mb-3">
            <div class="col">
              <div class="input-group">
                <input id="msg" type="text" class="form-control" 
                       name="msg" 
                       placeholder="할일을 여기에 입력!" 
                       v-model="todo"
                       @keyup.enter="add"
                />
                <span class="btn btn-primary input-group-addon" 
                @click="add">추가</span>
              </div>
            </div>
          </div>
        </div>
          </div>
        </div>
</template>
<script>
export default {
  data() {
    return {
      todo: "",
    };
  },
  methods: {
    add() {
      if (this.todo.trim().length >= 3) {
        this.$emit("addItem", { todo: this.todo });
        this.todo = "";
      } else {
        alert("3자 이상 입력하세요");
      }
    },
  },
};
</script>

<style scoped>
@import "https://unpkg.com/bootstrap@5.2.3/dist/css/bootstrap.min.css";
body {
      margin: 0;
      padding: 0;
      font-family: sans-serif;
    }

.title {
  text-align: center;
  font-weight: bold;
  font-size: 20pt;
}

.card-borderless {
  border: 0;
  box-shadow: none;
}
</style>