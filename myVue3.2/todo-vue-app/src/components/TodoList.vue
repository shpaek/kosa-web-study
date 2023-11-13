<template>
    <div id="app" class="container">
      <div class="row">
        <div class="col">
          <ul class="list-group">
            <TodoListItem
              v-for="(item, index) in todolist"
              :key="item.id"
              :item="item"
              @update-todo="updateTodo"
              @delete-todo="deleteTodo(index)"
            />
          </ul>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import TodoListItem from "./TodoListItem.vue";
  
  export default {
    name: "TodoList",
    components: { TodoListItem },
    props: {
      todolist: Array,
    },
    methods: {
      updateTodo(updatedItem) {
        const index = this.todolist.findIndex((todo) => {
          return todo.id === updatedItem.id;
        });
        this.todolist[index].completed = !this.todolist[index].completed;
      },
      deleteTodo(index) {
        this.$emit("delete-todo", index);
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
  </style>
  