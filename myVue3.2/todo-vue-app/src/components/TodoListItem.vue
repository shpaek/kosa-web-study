<template>
    <li class="list-group-item" :class="{ 'list-group-item-success': item.completed }">
      <span class="pointer" @click="updateTodo" :class="{ 'todo-done': item.completed }">
        {{ item.todo }}{{ item.completed ? '(완료)' : '' }}
      </span>
      <span class="float-end badge bg-secondary pointer" @click="deleteTodo">삭제</span>
    </li>
  </template>
  
  <script>
  export default {
    props: {
      item: Object,
    },
    methods: {
      updateTodo() {
        this.$emit("update-todo", this.item);
      },
      deleteTodo() {
        this.$emit("delete-todo", this.item.id);
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
  
  .todo-done {
    text-decoration: line-through;
  }
  
  .pointer {
    cursor: pointer;
  }
  </style>
  